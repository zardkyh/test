package com.jayuron.restfulmssql.exeception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler( Exception.class )
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request ){
        ExceptionResponse   exceptionResponse =
                new ExceptionResponse( new Date(), ex.getMessage(), request.getDescription( false ) );

        return new ResponseEntity( exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR );
    }

    @ExceptionHandler( UserNotFoundException.class )
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request ){
        ExceptionResponse   exceptionResponse =
                new ExceptionResponse( new Date(), ex.getMessage(), request.getDescription( false ) );

        return new ResponseEntity( exceptionResponse, HttpStatus.NOT_FOUND );
    }

    @ExceptionHandler( UserAlreadyException.class )
    public final ResponseEntity<Object> handleAlreadyException(Exception ex, WebRequest request ){
        ExceptionResponse   exceptionResponse =
                new ExceptionResponse( new Date(), ex.getMessage(), request.getDescription( false ) );

        return new ResponseEntity( exceptionResponse, HttpStatus.ALREADY_REPORTED );
    }

    @ExceptionHandler( BadParameterException.class )
    public final ResponseEntity<Object> BadParameterException(Exception ex, WebRequest request ){
        ExceptionResponse   exceptionResponse =
                new ExceptionResponse( new Date(), ex.getMessage(), request.getDescription( false ) );

        return new ResponseEntity( exceptionResponse, HttpStatus.BAD_REQUEST );
    }

    // Data Validation 예외처리 부
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {

        String  msg = ex.getMessage();
        String[]    arMsg = msg.split( ";" );
        String  msgErr  = arMsg[arMsg.length -1];

        ExceptionResponse   exceptionResponse = new ExceptionResponse( new Date(), msgErr, ex.getBindingResult().toString() );

        return new ResponseEntity( exceptionResponse, HttpStatus.BAD_REQUEST );

    }

}
