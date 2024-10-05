package com.traini8_TrainingCenter.exceptionHandle;

import java.util.ArrayList;
import java.util.List;

class ErrorResponse {
    private int status;
    private String message;
    private List<FieldError> errors;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<FieldError> getErrors() {
		return errors;
	}
//	public void setErrors(List<FieldError> errors) {
//		this.errors = errors;
//	}
	 public void setErrors(List<org.springframework.validation.FieldError> errors) {
	        this.errors = new ArrayList<>();
	        for (org.springframework.validation.FieldError error : errors) {
	            FieldError fieldError = new FieldError();
	            fieldError.setField(error.getField());
	            fieldError.setMessage(error.getDefaultMessage());
	            this.errors.add(fieldError);
	        }
	    }

    
}
