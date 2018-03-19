/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a97lynk.controller;

import com.a97lynk.object.dto.UserDTO;
import com.a97lynk.object.entity.User;
import com.a97lynk.object.entity.VerificationToken;
import com.a97lynk.event.SendConfirmMailEvent;
import com.a97lynk.exception.EmailExistsException;
import com.a97lynk.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.Calendar;
import java.util.Locale;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 97lynk
 */
//@Controller
public class RegistrationController {

    private static final Logger logger
            = Logger.getLogger(RegistrationController.class.getName());

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private IUserService userService;

    /**
     * chuyển trang đăng kí
     *
     * @param userDTO
     * @return
     */
    @GetMapping("/u/registration")
    public String showRegistrationForm(@ModelAttribute("user") UserDTO userDTO) {
        userDTO = new UserDTO();
        return "signup/registrationPage";
    }

    /**
     * Xác nhận đăng kí
     *
     * @param model
     * @param userDTO
     * @param result
     * @param request
     * @return
     * @throws ConstraintViolationException
     */
    @PostMapping("/u/registration")
    public String registerUserAccount(Model model, @ModelAttribute("user") @Valid UserDTO userDTO,
                                      BindingResult result, WebRequest request)
            throws ConstraintViolationException {
        logger.info(">> Submit register");

        // kiểm tra lỗi
        if (result.hasErrors()) {
            logger.log(Level.WARNING,">> Has error in fields");
            result.getAllErrors().forEach(e -> {
                logger.log(Level.INFO,"\t{0}: {1}", new Object[]{e.getObjectName(), e.toString()});
            });
            model.addAttribute("user", userDTO);
            return "signup/registrationPage";
        }

        // lấy tạo user mới theo userdto đã valid
        Optional<User> register = Optional.ofNullable(createUserAccount(userDTO, result));

        // send mail confirm
        try {
            eventPublisher.publishEvent(new SendConfirmMailEvent(
                    register.orElse(null), request.getLocale(), request.getContextPath()));
        } catch (Exception ex) {
            logger.log(Level.WARNING, "[x] Here exception {0}", ex.getLocalizedMessage());
            model.addAttribute("user", userDTO);
            return "signup/registrationPage";
        }

        // chuyển trang success
        model.addAttribute("message", messageSource.getMessage("message.checkMail", null, request.getLocale()));
        model.addAttribute("user", register.orElse(new User()));
        return "signup/completeRegistrationPage";
    }

    /**
     * confirm link được gửi qua mail kèm token
     * @param locale
     * @param model
     * @param token
     * @return
     */
    @GetMapping("/u/registrationConfirm")
    public String confirmRegistration(Locale locale, Model model, @RequestParam(name = "token", defaultValue = "") String token) {

        // tìm token trong db
        Optional<VerificationToken> verificationToken
                = Optional.of(token).map(userService::getVerificationToken);

        // token không tồn tại
        if (!verificationToken.isPresent()) {
            String message = messageSource.getMessage("auth.message.invalidToken", null, locale);
            model.addAttribute("message", message);
            return "signup/badConfirmPage";
        }

        // kiểm tra liệu tài khoản này đã xác nhận chưa
        Optional<User> user = verificationToken.map(VerificationToken::getUser);
        if (user.get().isEnabled()) {
            String message = messageSource.getMessage("message.activitedEmail", null, locale);
            model.addAttribute("message", message);
            return "signup/badConfirmPage";
        }

        Calendar cal = Calendar.getInstance();
        // kiểm tra thời hạn token
        if (verificationToken.map(VerificationToken::getExpiryDate).get()
                .before(cal.getTime())) {
            String message = messageSource.getMessage("auth.message.expired", null, locale);
            model.addAttribute("message", message);
            model.addAttribute("mailAddress", user.map(User::getEmail).get());
            return "signup/badConfirmPage";
        }

        User u = user.orElse(new User());
        u.setEnabled(true);
        userService.saveRegisteredUser(u);
        model.addAttribute("user", u);
        return "signin/loginPage";
    }

    private User createUserAccount(UserDTO userDTO, BindingResult result) {
        User registered = null;
        try {
            registered = userService.registerNewUserAccount(userDTO);
            logger.info("Account i created");
        } catch (EmailExistsException emailExistsException) {
            result.rejectValue("email", "message.alreadyEmail");
            logger.warning(emailExistsException.getMessage());
            return null;
        } catch (ConstraintViolationException constraintViolationException) {
            result.rejectValue("matchingPassword", "message.dontMatchPass");
            logger.warning(constraintViolationException.getMessage());
            return null;
        }
        return registered;
    }

}
