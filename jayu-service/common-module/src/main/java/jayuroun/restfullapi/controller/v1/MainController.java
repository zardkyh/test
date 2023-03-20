package jayuroun.restfullapi.controller.v1;

import jayuroun.core.exception.CUserNotFoundException;
import jayuroun.restfullapi.repository.MsgCommonImpl;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;


@RestController
public class MainController {


    @GetMapping( "/global/get" )
    public String GetUserMsg(@RequestParam String name ) {
        return name;

     }
}
