package com.application.start.restcontroller.exception;

import com.application.start.entity.ErrorResponseHandler;
import com.application.start.exception.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class GlobalExceptionController {
    @ExceptionHandler(value = DataNotFoundException.class)
    public ResponseEntity<ErrorResponseHandler> handleException(DataNotFoundException exception){
        ErrorResponseHandler errorResponseHandler=new ErrorResponseHandler();
        errorResponseHandler.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponseHandler.setMessage(exception.getMessage());
        errorResponseHandler.setTimeStamp(OffsetDateTime.now());
        return new ResponseEntity<>(errorResponseHandler,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponseHandler> catchAllException(Exception e){
        ErrorResponseHandler errorResponseHandler=new ErrorResponseHandler();
        errorResponseHandler.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponseHandler.setMessage(e.getMessage());
        errorResponseHandler.setTimeStamp(OffsetDateTime.now());
        return new ResponseEntity<>(errorResponseHandler,HttpStatus.BAD_REQUEST);
    }
}
