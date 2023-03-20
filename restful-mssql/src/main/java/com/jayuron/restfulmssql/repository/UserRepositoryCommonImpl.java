package com.jayuron.restfulmssql.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

public class UserRepositoryCommonImpl implements UserRepositoryCommon {

    private final JPAQueryFactory queryFactory = null;

    public void UserRepositoryCommonImpl(EntityManager em){

        //this.queryFactory   = new JPAQueryFactory( em );
    }

}
