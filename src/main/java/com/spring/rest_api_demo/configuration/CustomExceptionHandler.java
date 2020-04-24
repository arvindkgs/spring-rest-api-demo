package com.spring.rest_api_demo.configuration;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NumberFormatException.class)
    public void handleAPINumberFormatException(Exception ex, HttpServletResponse response) throws IOException {
        response.sendError(400, "Only numbers are can be passed as input.");
    }
}
