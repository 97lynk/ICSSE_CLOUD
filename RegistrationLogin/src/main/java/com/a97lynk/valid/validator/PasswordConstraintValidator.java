/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a97lynk.valid.validator;

import com.a97lynk.valid.annotation.ValidPassword;
import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 *
 * @author 97lynk
 */
public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    private static final Logger logger
            = Logger.getLogger(PasswordConstraintValidator.class.getName());

    @Override
    public void initialize(ValidPassword arg0) {
    }


    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {

        PasswordValidator validator = new PasswordValidator(
                Arrays.asList(
                        new LengthRule(8, 30),
                        new UppercaseCharacterRule(1),
                        new DigitCharacterRule(1),
                        new SpecialCharacterRule(1),
                        new NumericalSequenceRule(3, false),
                        new AlphabeticalSequenceRule(3, false),
                        new QwertySequenceRule(3, false),
                        new WhitespaceRule()));
        RuleResult result = validator.validate(new PasswordData(password));
        if (result.isValid()) {
            return true;
        }


        context.buildConstraintViolationWithTemplate(
                String.join(" ", validator.getMessages(result))).addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}
