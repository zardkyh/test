package jayuroun.restfullapi.controller.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( value="/global")
public class MainController {

    private final String X_API_VERSION = new String( "v1.0" );

    @GetMapping( "/version")
    public String getVersion() {
        return X_API_VERSION;
    }

    @PostMapping( "/echo" )
    public String echo( @RequestParam  String message ) {
        return message;
    }
}
