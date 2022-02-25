package com.intuit.java.oms.exceptionhandler;

import com.intuit.java.oms.exception.OrderNotFound;
import com.intuit.java.oms.exception.ProductNotFound;
import com.intuit.java.oms.model.ExceptionResponse;
import com.intuit.java.oms.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ProductNotFound.class, OrderNotFound.class})
    public ResponseEntity<Object> handleExceptions(RuntimeException exception, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setDateTime(LocalDateTime.now());
        response.setMessage("Not found");
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return entity;
    }
}
