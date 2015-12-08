package com.example.mvc.exception;

@SuppressWarnings("serial")
public class CustomException extends Exception {

	public CustomException(String str){
		 super(str);
	}
    public String getMessage(){
        return super.getMessage();
    }
}
