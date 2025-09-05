package com.librarymanagement.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserAlreadyExistsException.class)
    public String handleUserAlreadyExists(UserAlreadyExistsException ex, Model model) {
        model.addAttribute("errorMessage", "Username is already taken");
        return "error-page";
    }

    @ExceptionHandler(Exception.class)
    public String handleAllExceptions(Exception ex, Model model) {
        model.addAttribute("errorMessage", "An error has occurred");
        return "error-page";
    }
}

