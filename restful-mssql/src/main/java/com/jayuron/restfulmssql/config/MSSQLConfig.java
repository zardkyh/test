package com.jayuron.restfulmssql.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

public class MSSQLConfig implements ApplicationRunner {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public MSSQLConfig( DataSource dataSource,
                        JdbcTemplate jdbcTemplate ) {

        this.dataSource     = dataSource;
        this.jdbcTemplate   = jdbcTemplate;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try (Connection connection = dataSource.getConnection() ){
            System.out.println( "   >> dataSource Class > " + dataSource.getClass() );
            System.out.println( "   >> URL > " + connection.getMetaData().getURL() );
            System.out.println( "   >> userName > " + connection.getMetaData().getUserName() );

            Statement statement   = connection.createStatement();
            String      sql         = "select * from test";
            statement.execute( sql );
        }

        jdbcTemplate.execute( "select * from test" );
    }
}
