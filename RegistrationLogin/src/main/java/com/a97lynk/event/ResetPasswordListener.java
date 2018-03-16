package com.a97lynk.event;

import com.a97lynk.object.entity.PasswordResetToken;
import com.a97lynk.object.entity.User;
import com.a97lynk.service.EmailService;
import com.a97lynk.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 97lynk
 */
@Component
public class ResetPasswordListener implements
        ApplicationListener<SendResetPassMailEvent> {

    @Autowired
    private IUserService service;


    @Autowired
    private EmailService emailService;

    @Autowired
    private Environment env;

    private static final Logger logger
            = Logger.getLogger(RegistrationListener.class.getName());

    // API
    @Override
    public void onApplicationEvent(SendResetPassMailEvent event) {
        Optional<User> user = Optional.of(event).map(SendResetPassMailEvent::getUser);
        Optional<PasswordResetToken> token = user.map(service::getPasswordResetTokenByUser);

        if (token.isPresent()) {
            token = token.map(PasswordResetToken::getToken)
                    .map(service::generateNewPasswordResetToken);

        } else {
            token = user.map(service::createPasswordResetTokenForUser);
        }
        this.sendConfirmChangePassword(token.get());
    }

    public void sendConfirmChangePassword(PasswordResetToken resetToken) {
        logger.log(Level.INFO,">> Generate PasswordResetToken");
        String token = resetToken.getToken();
        User user = resetToken.getUser();

        try {
            final String recipientAddress = user.getEmail();
            final String subject = "Reset Password";
            final String confirmationUrl = String.format("http://localhost:8080/u/changePassword?id=%s&token=%s",
                    user.getId(), token);
            final String content
                    = String.format("Hi! %s %s%n"
                            + "You want to reset password%n"
                            + "Click or paste it into your browser:%n"
                            + "%s%nThanks!",
                            user.getFirstName(), user.getLastName(),
                            confirmationUrl);

            emailService.sendSimpleMessage(recipientAddress, subject, content);

        } catch (MailException ex) {
            logger.warning(ex.getMessage());
        }

    }

}
