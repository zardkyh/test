package jayuroun.restfullapi.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jayuroun.restfullapi.dto.MsgDto;
import jayuroun.restfullapi.entity.Msg;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static jayuroun.restfullapi.entity.Msg.sp_GetAll;
import static jayuroun.restfullapi.entity.QMsg.msg1;


public class MsgCommonImpl implements MsgCommon {

    private final JPAQueryFactory queryFactory;

    private final EntityManager em;

    public MsgCommonImpl( EntityManager em ) {

        this.queryFactory = new JPAQueryFactory(em);
        this.em = em;
    }

    @Override
    public String Test( String msg ) {
        return msg;
    }

    @Override
    public Optional<List<MsgDto>> getAll(){

        QueryResults<Msg> results = queryFactory
                .select( msg1 )
                .from( msg1 )
                .fetchResults();

        List<MsgDto> content = results.getResults().stream()
                .map(o -> new MsgDto(o))
                .collect(toList());

        return Optional.of(content);
    }

    @Override
    public String getMsg(String name)
    {
        Msg result = queryFactory
                .select(msg1)
                .from(msg1)
                .where( msg1.name.eq( name ) )
                .fetchOne();

        if ( result == null ) {
            return null;
        }

        return result.getMsg();
    }

    @Override
    public Msg findByName(String name) {

        Msg result = queryFactory
                .select(msg1)
                .from(msg1)
                .where( msg1.name.eq( name ) )
                .fetchOne();

        if ( result == null ) {
            return null;
        }

        return result;
    }

    @Override
    public Long updateMsg(String name, String msg )
    {
        Long    execute = queryFactory
                .update(msg1)
                .set( msg1.msg, msg )
                .where( msg1.name.eq( name ) )
                .execute();

        return execute;
    }

    @Override
    public Long delMsg(String name )
    {
        Long    execute = queryFactory
                .delete(msg1)
                .where( msg1.name.eq( name ))
                .execute();

        return execute;
    }


    @Override
    public Long Echo(String name )
    {
        Long    execute = queryFactory
                .update(msg1)
                .set( msg1.echo, msg1.msg )
                .where( msg1.name.eq( name ) )
                .execute();

        return execute;
    }


    @Override
    public List<Msg> GetAllBySP()
    {
        StoredProcedureQuery spQuery  = em.createNamedStoredProcedureQuery( sp_GetAll );

        spQuery.execute();

        Integer cnt =  (Integer) spQuery.getOutputParameterValue( "RETCODE" );

        return spQuery.getResultList();
    }
}
