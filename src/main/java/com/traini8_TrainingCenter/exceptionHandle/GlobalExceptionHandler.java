package com.traini8_TrainingCenter.exceptionHandle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage("Validation failed");
        errorResponse.setErrors(ex.getBindingResult().getFieldErrors());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleEmailAlreadyExistsException(EmailAlreadyExistsException ex) {
    	ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(ex.getMessage());
        
        List<FieldError> errors = errorResponse.getErrors();
                
        errorResponse.setErrors(new ArrayList<>()); // You can add custom error details if needed

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    
}
