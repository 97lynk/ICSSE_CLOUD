package com.a97lynk.object.dto;

import com.a97lynk.valid.annotation.PasswordMatches;
import com.a97lynk.valid.annotation.ValidEmail;
import com.a97lynk.valid.annotation.ValidPassword;

import javax.validation.constraints.NotNull;

/**
 *
 * @author 97lynk
 */
@PasswordMatches
public class UserDTO {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @ValidPassword
    private String password;

    private String matchingPassword;

    @NotNull
    @ValidEmail
    private String email;

    //contructors
    public UserDTO() {
    }

    // standard getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((email == null) ? 0 : email.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserDTO user = (UserDTO) obj;
        if (!email.equals(user.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("User [firstName=").append(firstName)
                .append(", lastName=").append(lastName)
                .append(", email=").append(email)
                .append(", password=").append(password)
                .append(", matching password=").append(matchingPassword)
                .append("]");
        return builder.toString();
    }
}
