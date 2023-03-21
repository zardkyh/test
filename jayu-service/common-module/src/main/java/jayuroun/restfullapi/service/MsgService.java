package jayuroun.restfullapi.service;

import jayuroun.restfullapi.dto.MsgDto;
import jayuroun.restfullapi.entity.Msg;
import jayuroun.restfullapi.repository.MsgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.List;

import static jayuroun.restfullapi.entity.Msg.*;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class MsgService {

    private final EntityManager em;

    private final MsgRepository msgRepository;

    public List<MsgDto> lists() {
        List<MsgDto> items = new ArrayList<>();
        items = msgRepository.getAll().orElse( new ArrayList<MsgDto>() );
        return items;
    }

    public Integer InitData()
    {
        StoredProcedureQuery    spQuery  = em.createNamedStoredProcedureQuery( sp_InitData );

        if ( spQuery.execute() == false )
            return 0;

        return (Integer) spQuery.getUpdateCount();
    }

    public List<Msg> GetAll()
    {
        List<Msg> list = msgRepository.sp_getall();

        return list;
    }

    public List<Msg> GetAll2()
    {
        return msgRepository.GetAllBySP();
    }

    public String getMsg( String name ) {

        return msgRepository.getMsg( name );
    }

    public Msg getRow( String name ) {

        return msgRepository.findByName( name );
    }

    public Msg newMsg( String name, String msg ) {

        Msg oldMsg  = getRow( name ),
            newMsg  = null;

        if ( oldMsg == null || oldMsg.getSeq() <= 0 )
            newMsg  = Msg.builder().name( name ).msg( msg ).echo( null ).build();

        else {
            msgRepository.updateMsg( name, msg );

            return getRow( name );
        }

        return msgRepository.save( newMsg );

    }

    public Msg delMsg( String name ) {

        if ( name.isEmpty() == true ) return null;

        Msg msg  = getRow( name );

        if ( msg == null || msg.getSeq() <= 0 )
            return null;

        msgRepository.delMsg( name );

        return msg;

    }

    public Msg echo( String name ) {

        if ( name.isEmpty() == true ) return null;

        Msg msg = getRow( name );

        if ( msg == null || msg.getSeq() <= 0 ) return null;

        msgRepository.Echo( name );

        return getRow( name );
    }


}
