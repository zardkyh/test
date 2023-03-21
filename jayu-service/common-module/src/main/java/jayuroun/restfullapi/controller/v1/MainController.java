package jayuroun.restfullapi.controller.v1;

import jayuroun.restfullapi.dto.MsgDto;
import jayuroun.restfullapi.entity.Msg;
import jayuroun.restfullapi.service.MsgService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MainController {

    private final MsgService    msgService;

    @GetMapping( "/msg" )
    public String GetUserMsg(@RequestParam String name ) {

        return msgService.getMsg( name );
    }

    @GetMapping( "/msg/getrow" )
    public Msg GetRow(@RequestParam String name ) {

        return msgService.getRow( name );
    }

    @GetMapping( "/msg/all" )
    public List<Msg> GetAllMsg() {

        //return msgService.lists();

        return msgService.GetAll();
    }

    @GetMapping( "/msg/all2" )
    public List<Msg> GetAllMsg2() {

        return msgService.GetAll2();
    }

    @PostMapping("/msg")
    public Msg NewMsg(@RequestParam String name, String msg ) {

        return msgService.newMsg( name, msg );
    }

    @PutMapping("/msg")
    public Msg UpdateMsg(@RequestParam String name, String msg ) {

        return msgService.newMsg( name, msg );
    }

    @DeleteMapping("/msg")
    public Msg DeleteMsg(@RequestParam String name ) {

        return msgService.delMsg( name );
    }


    @PostMapping( "/msg/echo" )
    public Msg echo( @RequestParam String name )
    {
        return msgService.echo( name );
    }

    @PostMapping( "/msg/init" )
    public Integer Init()
    {
        return msgService.InitData();
    }

}
