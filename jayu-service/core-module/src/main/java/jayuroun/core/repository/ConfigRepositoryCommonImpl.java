package jayuroun.core.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jayuroun.core.entity.Config;
import jayuroun.core.model.response.dto.ConfigDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static jayuroun.core.entity.QConfig.config;

/**
 * -------------------------------------------------------------------------------------
 * ::::::'OO::::'OOO::::'OO:::'OO:'OO::::'OO:'OOOOOOOO:::'OOOOOOO::'OO::::'OO:'OO....OO:
 * :::::: OO:::'OO OO:::. OO:'OO:: OO::::.OO: OO.....OO:'OO.....OO: OO:::: OO: OOO...OO:
 * :::::: OO::'OO:..OO:::. OOOO::: OO::::.OO: OO::::.OO: OO::::.OO: OO:::: OO: OOOO..OO:
 * :::::: OO:'OO:::..OO:::. OO:::: OO::::.OO: OOOOOOOO:: OO::::.OO: OO:::: OO: OO.OO.OO:
 * OO:::: OO: OOOOOOOOO:::: OO:::: OO::::.OO: OO.. OO::: OO::::.OO: OO:::: OO: OO..OOOO:
 * :OO::::OO: OO.....OO:::: OO:::: OO::::.OO: OO::. OO:: OO::::.OO: OO:::: OO: OO:..OOO:
 * ::OOOOOO:: OO:::..OO:::: OO::::. OOOOOOO:: OO:::. OO:. OOOOOOO::. OOOOOOO:: OO::..OO:
 * :......:::..:::::..:::::..::::::.......:::..:::::..:::.......::::.......:::..::::..::
 * <p>
 * ConfigRepositoryCommonImpl 의 설명을 작성해주세요.
 *
 * @author :
 * @packageName : jayuroun.core.repository.ConfigRepositoryCommonImpl
 * @fileName :
 * @date :
 * @description :
 * =======================================================================
 * DATE                   AUTHOR                NOTE
 * -----------------------------------------------------------------------
 *
 */

public class ConfigRepositoryCommonImpl implements ConfigRepositoryCommon {

    private final JPAQueryFactory queryFactory;

    private final EntityManager em;

    public ConfigRepositoryCommonImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
        this.em = em;
    }


    @Override
    public Page<ConfigDto> search(Pageable pageable ) {
        QueryResults<Config> results = queryFactory
                .select(config)
                .from(config)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<ConfigDto> content = results.getResults().stream()
                .map(o -> new ConfigDto(o))
                .collect(toList());

        long total = results.getTotal();
        return new PageImpl<>(content, pageable, total);
    }

    @Override
    public Optional<List<ConfigDto>> getAll() {

        QueryResults<Config> results = queryFactory
                .select(config)
                .from(config)
                .fetchResults();

        List<ConfigDto> content = results.getResults().stream()
                .map(o -> new ConfigDto(o))
                .collect(toList());

        return Optional.of(content);
    }


    @Override
    public Optional<List<ConfigDto>> findByKeys( List<String> keys ) {

        QueryResults<Config> results = queryFactory
                .select(config)
                .from(config)
                .where( config.cfgKey.in( keys ) )
                .fetchResults();

        List<ConfigDto> content = results.getResults().stream()
                .map(o -> new ConfigDto(o))
                .collect(toList());

        return Optional.of(content);
    }


    @Override
    public String getKeyValue(String key) {

        Config result = queryFactory
                .select(config)
                .from(config)
                .where( config.cfgKey.eq( key ) )
                .fetchOne();

        if ( result == null ) {
            return "";
        }

        return result.getCfgValue();
    }

    @Override
    public Config getKey(String key) {

        Config result = queryFactory
                .select(config)
                .from(config)
                .where( config.cfgKey.eq( key ) )
                .fetchOne();

        return result;
    }


}
