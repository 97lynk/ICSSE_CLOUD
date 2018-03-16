package com.a97lynk.event;

import com.a97lynk.object.entity.User;
import com.a97lynk.object.entity.VerificationToken;
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
public class RegistrationListener implements
        ApplicationListener<SendConfirmMailEvent> {

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
    public void onApplicationEvent(SendConfirmMailEvent event) {
        Optional<User> user = Optional.of(event).map(SendConfirmMailEvent::getUser);
        Optional<VerificationToken> token = user.map(service::getVerificationToken);

        if (token.isPresent()) {
            token = token.map(VerificationToken::getToken)
                    .map(service::generateNewVerificationToken);
        } else {// confirm lần đầu
            token = user.map(service::createVerificationToken);
        }
        this.confirmRegistration(token.get());
    }

    public void confirmRegistration(VerificationToken verificationToken) {
        logger.log(Level.INFO,">> Generate VerificationToken");
        String token = verificationToken.getToken();
        User user = verificationToken.getUser();

        try {
            final String recipientAddress = user.getEmail();
            final String subject = "Confirm your email address";
            final String confirmationUrl = "http://localhost:8080/u/registrationConfirm?token=" + token;
            final String content
                    = String.format("Hi! %s %s%n"
                            + "You recently added a new email address to your account%n"
                            + "To confirm the address click or paste it into your browser:%n"
                            + "%s%nThanks!",
                            user.getFirstName(), user.getLastName(),
                            confirmationUrl);

            emailService.sendSimpleMessage(recipientAddress, subject, content);

        } catch (MailException ex) {
            logger.warning(ex.getMessage());
        }

    }

}
