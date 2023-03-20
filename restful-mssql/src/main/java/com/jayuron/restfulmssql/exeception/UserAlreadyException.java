package com.jayuron.restfulmssql.exeception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( HttpStatus.ALREADY_REPORTED )
public class UserAlreadyException extends RuntimeException{

    public UserAlreadyException(String message) {
        super(message);
    }

}
