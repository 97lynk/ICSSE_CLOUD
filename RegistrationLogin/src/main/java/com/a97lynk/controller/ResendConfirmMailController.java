/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a97lynk.controller;

import com.a97lynk.object.entity.User;
import com.a97lynk.object.entity.VerificationToken;
import com.a97lynk.event.SendConfirmMailEvent;
import com.a97lynk.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 97lynk
 */
//@Controller
public class ResendConfirmMailController {

    private static final Logger logger
            = Logger.getLogger(ResendConfirmMailController.class.getName());
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private IUserService userService;

    // gửi resend mail form
    @RequestMapping(value = "/u/resendRegistration", method = RequestMethod.GET)
    public String resendConfirmPage(Model model,
                                    @RequestParam(name = "email", defaultValue = "") String email) {
        model.addAttribute("email", email);
        model.addAttribute("result", null);
        return "signup/resendConfirmPage";
    }

    // submit resend
    @RequestMapping(value = "/u/resendRegistration", method = RequestMethod.POST)
    public String resendRegistrationToken(
            WebRequest request, Model model,
            @RequestParam("email") String email) {
        logger.log(Level.INFO, "* Request send email to confirm account to {0}", email);

        // lấy user bằng email
        Optional<User> user = Optional.ofNullable(email).map(userService::getUserByEmail);
        Optional<VerificationToken> token = user.map(userService::getVerificationToken);

        String message = "message.notSuccess";
        String textColor = "alert alert-danger";
        boolean sendMail = userService.allowSendConfirmEmail(user.orElse(null), token.orElse(null));
        logger.log(Level.INFO, ">> Status request is {0}", sendMail);

        // gửi mail
        if (sendMail) {
            try {
                eventPublisher.publishEvent(new SendConfirmMailEvent(
                        user.get(), request.getLocale(), request.getContextPath()));
                message = "message.checkMail";
                textColor = "alert alert-success";
            } catch (Exception ex) {
                logger.log(Level.WARNING, "[x] Here exception {0}", ex.getMessage());
            }

        }
        String mgs = messageSource.getMessage(message, null, request.getLocale());
        logger.log(Level.INFO, ">> Message request is {0}", mgs);
        model.addAttribute("result", mgs);
        model.addAttribute("textColor", textColor);
        return "signup/resendConfirmPage";

    }

}
