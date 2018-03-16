/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a97lynk.utils;

/**
 *
 * @author 97lynk
 */
public enum ResendConfirmStatus {
    OK, // allow send email
    EMAIL_NOT_EXIST, // email isn't exist
    EMAIL_ENABLE, //  email is enable
    SPAM // this requirement is spam
}
