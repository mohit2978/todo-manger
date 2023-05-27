package com.todoapi.todomanger.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> NullptrException(NullPointerException ex){
        logger.info("Handling null ptr excpetion from global handler");
        return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotfoundException(
            ResourceNotFoundException ex){
        logger.error(ex.getMessage());
        ExceptionResponse ex1=new ExceptionResponse();
        ex1.setMessage("You are trying to find something which we dont have");
        ex1.setStatus(HttpStatus.NOT_FOUND);
        ex1.setIsSuccess(false);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex1);
    }
}
