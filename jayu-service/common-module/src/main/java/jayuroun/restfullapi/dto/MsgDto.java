package jayuroun.restfullapi.dto;

import jayuroun.restfullapi.entity.Msg;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
public class MsgDto {

    private Long seq;

    private String  name;

    private String  msg;

    private String  echo;

    public MsgDto( Msg msg ) {

        this.seq    = msg.getSeq();
        this.name   = msg.getName();
        this.msg    = msg.getMsg();
        this.echo   = msg.getEcho();
    }

}
