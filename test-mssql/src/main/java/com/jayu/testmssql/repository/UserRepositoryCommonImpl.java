package com.jayu.testmssql.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;

public class UserRepositoryCommonImpl implements UserRepositoryCommon {

    private final JPAQueryFactory queryFactory;

    public void UserRepositoryCommonImpl(EntityManager em){

        this.queryFactory   = new JPAQueryFactory( em );
    }

}
