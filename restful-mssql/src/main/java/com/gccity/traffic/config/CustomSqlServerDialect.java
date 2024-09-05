package com.gccity.traffic.config;

import java.sql.Types;

import org.hibernate.type.StandardBasicTypes;

public class CustomSqlServerDialect extends org.hibernate.dialect.SQLServerDialect {

	public CustomSqlServerDialect() {

		registerColumnType(Types.LONGNVARCHAR, StandardBasicTypes.STRING.getName());
		registerHibernateType(Types.LONGNVARCHAR, StandardBasicTypes.STRING.getName());
	}

}
