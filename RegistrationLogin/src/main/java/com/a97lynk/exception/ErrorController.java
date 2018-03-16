package com.a97lynk.exception;

import org.springframework.ui.Model;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 97lynk
 */
@ControllerAdvice
public class ErrorController {

    private static final Logger logger = Logger.getLogger(ErrorController.class.getName());

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public String exception(HttpServletRequest request, Exception exception, Model model) {
        logger.log(Level.WARNING, "Exception handler: {0}", exception.getMessage());
        String errorMessage = (exception != null) ? exception.getMessage() : "Unknown error";
        model.addAttribute("message", errorMessage);
        return "signup/badConfirmPage";
    }

}
