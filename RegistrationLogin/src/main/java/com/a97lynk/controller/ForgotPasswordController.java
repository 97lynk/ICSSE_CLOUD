/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a97lynk.controller;

import com.a97lynk.object.dto.PasswordDTO;
import com.a97lynk.object.entity.PasswordResetToken;
import com.a97lynk.object.entity.User;
import com.a97lynk.event.SendResetPassMailEvent;
import com.a97lynk.service.IUserService;
import com.a97lynk.utils.TokenStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 97lynk
 */
@Controller
public class ForgotPasswordController {

    private static final Logger logger
            = Logger.getLogger(ForgotPasswordController.class.getName());

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private IUserService userService;

    @Autowired
    private MessageSource messageSource;

    /**
     * chuyển trang nhập email lấy lại password
     *
     * @return forgotPasswordPage.html
     */
    @GetMapping("/u/resetPassword")
    public String forgotPasswordPage() {
        return "signin/forgotPasswordPage";
    }

    /**
     * Submit mail cần reset password
     *
     * @param request
     * @param model
     * @param email
     * @return forgotPasswordPage.html
     */
    @PostMapping("/u/resetPassword")
    public String resetPassword(WebRequest request, Model model, @RequestParam("email") String email) {
        logger.log(Level.INFO, ">> Request send email to reset password to {0}", email);

        // đựa vào email gửi về lấy user
        Optional<User> user = Optional.ofNullable(email).map(userService::getUserByEmail);

        // dự vào user lấy token
        Optional<PasswordResetToken> token = user.map(userService::getPasswordResetTokenByUser);

        // biến trạng thái và thông báo
        String messageName = "message.notSuccess";
        String textColor = "alert alert-danger";
        boolean sendMail = userService.allowSendResetPassEmail(user.orElse(null), token.orElse(null));

        logger.log(Level.INFO, ">> Status request is {0}", sendMail);
        // gửi mail
        if (sendMail) {
            try {
                // gửi bằng event reset pass
                eventPublisher.publishEvent(new SendResetPassMailEvent(
                        user.get(), request.getLocale(), request.getContextPath()));
                messageName = "message.checkMail";
                textColor = "alert alert-success";
            } catch (Exception ex) {
                logger.log(Level.WARNING, "[x] Here exception {0}", ex.getMessage());
            }
        }
        String msg = messageSource.getMessage(messageName, null, request.getLocale());
        logger.log(Level.INFO, ">> Message request is {0}", msg );
        logger.log(Level.INFO, "");

        // hiển thị thông báo
        model.addAttribute("result", msg);
        model.addAttribute("textColor", textColor);
        return "signin/forgotPasswordPage";
    }

    /**
     * Người dùng nhấn link reset password trong mail
     *
     * @param model
     * @param id    của tài khoản
     * @param token thay đổi password
     * @return changePasswordPage.html
     */
    @GetMapping("/u/changePassword")
    public String changePasswordPage(Model model,
                                     @RequestParam(value = "id", defaultValue = "") long id,
                                     @RequestParam(value = "token", defaultValue = "") String token) {
        // kiểm tra token có hợp lệ
        TokenStatus status = userService.validatePasswordResetToken(id, token);

        if (status != TokenStatus.VALID) {
            model.addAttribute("message", "id or token is " + status.toString());
            return "signup/badConfirmPage";
        }

        model.addAttribute("password", new PasswordDTO());
        logger.log(Level.INFO, ">>>>>> Confirm email to reset password status {0}", status);
        return "signin/changePasswordPage";
    }

    /**
     * Submit password mới
     *
     * @param password
     * @param result
     * @return
     */
    @PostMapping("/u/changePassword")
    public String changePassword(@ModelAttribute("password") @Valid PasswordDTO password, BindingResult result) {
        if (result.hasErrors()) {
            return "signin/changePasswordPage";
        }
        return "signin/loginPage";
    }

}
