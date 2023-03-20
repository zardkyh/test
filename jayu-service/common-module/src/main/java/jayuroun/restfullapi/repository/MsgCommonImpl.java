package jayuroun.restfullapi.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jayuroun.core.entity.Config;
import jayuroun.restfullapi.dto.MsgDto;
import jayuroun.restfullapi.entity.Msg;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static jayuroun.core.entity.QConfig.config;
import static jayuroun.restfullapi.entity.QMsg.msg1;


public class MsgCommonImpl implements MsgCommon {

    private final JPAQueryFactory queryFactory;

    private final EntityManager em;

    public MsgCommonImpl( EntityManager em ) {

        this.queryFactory = new JPAQueryFactory(em);
        this.em = em;
    }

//    @Override
//    public Optional<List<MsgDto>> getAll(){
//
//        QueryResults<Msg> results = queryFactory
//                .select( msg1 )
//                .from( msg1 )
//                .fetchResults();
//
//        List<MsgDto> content = results.getResults().stream()
//                .map(o -> new MsgDto(o))
//                .collect(toList());
//
//        return Optional.of(content);
//    }

//    @Override
//    public String getMsg(String name)
//    {
//        Msg result = queryFactory
//                .select(msg1)
//                .from(msg1)
//                .where( msg1.msg.eq( name ) )
//                .fetchOne();
//
//        if ( result == null ) {
//            return null;
//        }
//
//        return result.getMsg();
//    }
}
