/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a97lynk.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 97lynk
 */
@Controller
public class LoginController {

    private static final Logger logger
            = Logger.getLogger(LoginController.class.getName());

    /**
     * gửi form login
     *
     * @return loginPage.html
     */
    @GetMapping("/u/login")
    public String loginPage(Principal principal, HttpServletRequest request) {
        if (principal != null)
            return "redirect:/u/info";
        loggingAuth("LOGIN PAGE");
//        return "signin/loginPage";
//        request.getSession().removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        return "signin/loginPage";
    }

    /**
     * chuyển trang logout thành công
     *
     * @param model
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/u/logout")
    public String logoutSuccessfulPage(Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("title", "Logout");
        loggingAuth("LOGOUT REQUEST");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        logger.log(Level.INFO, ">> {0} is logout success", auth.getPrincipal());
//        return "signin/logoutSuccessfulPage";
        return "redirect:/";
    }

    /**
     * Chuyển trang cho admin
     *
     * @param model
     * @param principal
     * @return adminPage.html
     */
    @GetMapping("/u/admin")
    public String adminPage(Model model, Principal principal) {
        //principal - đối tượng cần xác thực
        User loginedUser = (User) ((Authentication) principal).getPrincipal(); // ép kiểu User cùa spring security

        String userInfo = loginedUser.toString();
        model.addAttribute("userName", principal.getName());
        model.addAttribute("userInfo", userInfo);

        return "adminPage";
    }

    /**
     * chuyển trang thông tin
     *
     * @param model
     * @param principal
     * @return userInfoPage
     */
    @GetMapping("/u/info")
    public String userInfo(Model model, Principal principal) {
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String userInfo = loginedUser.toString();
        model.addAttribute("userName", principal.getName());
        model.addAttribute("userInfo", userInfo);
        loggingAuth("INFO PAGE");
        return "userInfoPage";
    }

    /**
     * Trang access deny
     *
     * @param model
     * @param principal
     * @return
     */
    @GetMapping("/u/403")
    public String accessDenied(Model model, Principal principal) {
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String userInfo = loginedUser.toString();
        model.addAttribute("userInfo", userInfo);
        String message = "Hi " + principal.getName() //
                + "<br> You do not have permission to access this page!";
        model.addAttribute("message", message);
        return "403Page";
    }

    void loggingAuth(String title) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            logger.log(Level.INFO, "------------------{0}--------------------------", title);
            logger.log(Level.INFO, ">> Is authencated: {0}", auth.isAuthenticated());
            logger.log(Level.INFO, ">> Credentials: {0}", auth.getCredentials());
            logger.log(Level.INFO, ">> Details: {0}", auth.getDetails());
            logger.log(Level.INFO, ">> Principal: {0}", auth.getPrincipal());
            logger.log(Level.INFO, ">> List authorities: ");
            auth.getAuthorities().forEach(ga -> {
                logger.log(Level.INFO, "\t{0}", ga.toString());
            });

            logger.log(Level.INFO, "---------------------------------------------------------");
        }
    }
}
