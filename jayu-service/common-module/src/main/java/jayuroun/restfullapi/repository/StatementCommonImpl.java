package jayuroun.restfullapi.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;

public class StatementCommonImpl implements StatementCommon {
    private final JPAQueryFactory queryFactory;

    private final EntityManager em;

    public StatementCommonImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
        this.em = em;
    }
}
