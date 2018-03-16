package com.a97lynk.object.dto;

import com.a97lynk.valid.annotation.PasswordMatches;
import com.a97lynk.valid.annotation.ValidPassword;

import java.io.Serializable;

/**
 *
 * @author 97lynk
 */
@PasswordMatches
public class PasswordDTO implements Serializable {

    @ValidPassword
    private String newPassword;

    private String confirmPassword;

    public PasswordDTO() {
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return String.format("Password: [newPassword=%s,confirmPassword=%s]",
                newPassword, confirmPassword);
    }

}
