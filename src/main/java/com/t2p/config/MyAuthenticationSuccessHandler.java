/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t2p.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 97lynk
 */
@Service
public class MyAuthenticationSuccessHandler
        extends SimpleUrlAuthenticationSuccessHandler {

    private static final Logger logger
            = Logger.getLogger(MyAuthenticationSuccessHandler.class.getName());

    @Autowired
    private LocaleResolver localeResolver;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        Enumeration<String> headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String headerName = headerNames.nextElement();
//            logger.log(Level.INFO, "{0}: {1}", new Object[]{headerName, request.getHeader(headerName)});
//        }
        String refererURL = request.getHeader("referer");
        if (refererURL.indexOf('?') > 0) {
            refererURL = refererURL.substring(0, refererURL.indexOf('?'));
        }
        setDefaultTargetUrl(refererURL); // chuyển trang
        super.onAuthenticationSuccess(request, response, authentication); // set failure
        String successMessage = "Login success " + authentication.toString();
        logger.log(Level.INFO, ">> Referer: {0}", refererURL);
        logger.log(Level.INFO, ">> Success auth: {0}", successMessage);
        request.getSession().removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

}