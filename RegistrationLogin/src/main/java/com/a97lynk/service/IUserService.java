/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a97lynk.service;

import com.a97lynk.object.dto.UserDTO;
import com.a97lynk.object.entity.*;
import com.a97lynk.exception.EmailExistsException;
import com.a97lynk.utils.TokenStatus;

/**
 *
 * @author 97lynk
 */
public interface IUserService {

    User registerNewUserAccount(UserDTO userDTO)
            throws EmailExistsException;

    User getUser(String verificationToken);

    User getUserByEmail(String email);

    VerificationToken getVerificationToken(User user);

    void saveRegisteredUser(User user);

    VerificationToken createVerificationToken(User user);

    VerificationToken getVerificationToken(String VerificationToken);

    VerificationToken generateNewVerificationToken(String existingVerificationToken);

    TokenStatus validateVerificationToken(String token);

    Role getRoleByName(String name);

    Privilege getPrivilegeByName(String name);

    PasswordResetToken createPasswordResetTokenForUser(User user);

    PasswordResetToken generateNewPasswordResetToken(String existingPasswordResetToken);

    TokenStatus validatePasswordResetToken(long userID, String token);

    PasswordResetToken getPasswordResetTokenByUser(User user);

    boolean allowSendConfirmEmail(User user, VerificationToken token);
    boolean allowSendResetPassEmail(User user, PasswordResetToken token);

}
