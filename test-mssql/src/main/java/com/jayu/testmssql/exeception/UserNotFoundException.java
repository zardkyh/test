package com.jayu.testmssql.exeception;


// 2XX  -> OK
// 4xx  -> Client
// 5xx  -> Server

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 예외처리 시 반환 될 리턴값(HTTP Status Code)에 대한 것을 정의 할 수 있다.
// 에러 별로 예외 클래스를 생성 할 것
@ResponseStatus( HttpStatus.NOT_FOUND )
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super( message );
    }
}
