package com.jayuron.restfulmssql.controller;

import com.jayuron.restfulmssql.exeception.BadParameterException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/global")
public class GlobalController {

    private final String X_API_VERSION = "v1.0.0";

    @GetMapping("/version" )
    public String getVersion(){

        return X_API_VERSION;
    }

    @PostMapping( "/echo" )
    public String echo( String message ){

        if ( message.isEmpty() == true )
            throw new BadParameterException( "No Messages" );

        return String.format( "[Server Echo] " + message );
    }

}
