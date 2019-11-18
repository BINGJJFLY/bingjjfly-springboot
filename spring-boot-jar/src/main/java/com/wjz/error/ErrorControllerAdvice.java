package com.wjz.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(ErrorException.class)
    public String handleException(Exception e, HttpServletRequest req) {
        Map<String, Object> messages = new HashMap<>();
        messages.put("code", "000");
        messages.put("message", e.getMessage());
        req.setAttribute("messages", messages);
        req.setAttribute("javax.servlet.error.status_code", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return "forward:/error";
    }
}
