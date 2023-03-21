package jayuroun.restfullapi.repository;

import jayuroun.restfullapi.dto.MsgDto;
import jayuroun.restfullapi.entity.Msg;

import java.util.List;
import java.util.Optional;

public interface MsgCommon {
    Optional<List<MsgDto>> getAll();

    String getMsg(String name);

    public String Test( String msg );
    public Msg findByName(String name);
    Long updateMsg(String name, String msg );
    Long delMsg(String name );
    Long Echo(String name );

    List<Msg> GetAllBySP();
}
