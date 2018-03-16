/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a97lynk.event;

import com.a97lynk.object.entity.User;
import org.springframework.context.ApplicationEvent;

import java.util.Locale;

/**
 * @author 97lynk
 */
public class SendConfirmMailEvent extends ApplicationEvent {
    private String appUrl;
    private Locale locale;
    private User user;
 
    public SendConfirmMailEvent(
            User user, Locale locale, String appUrl) {
        super(user);
         
        this.user = user;
        this.locale = locale;
        this.appUrl = appUrl;
    }
     
    // standard getters and setters

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

  
    
}