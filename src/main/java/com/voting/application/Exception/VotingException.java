package com.voting.application.Exception;

import org.springframework.http.HttpStatus;

public class VotingException extends RuntimeException{
    private final HttpStatus httpStatus;
    public VotingException(String message, HttpStatus status){
        super(message);
        this.httpStatus=status;
    }

    public HttpStatus getHttpStatus(){
        return httpStatus;
    }
}
