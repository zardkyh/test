package com.gccity.traffic.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "oracleEntityManagerFactory",
		transactionManagerRef = "oracleTransactionManager",
		basePackages = {"com.gccity.traffic.repository.oracle"}
)
public class OracleDBConfig {

	@Autowired
	private Environment env;

	@Primary
	@Bean(name = "oracleEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean icubeEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(icubeDataSource());
		em.setPackagesToScan(new String[] {"com.gccity.traffic.entity.base.oracle"});
		em.setPersistenceUnitName("oracleEntityManager"); // 영속성 객체 이름을 지정
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("datasource-oracle.jpa.hibernate.ddl-auto"));
		properties.put("hibernate.dialect", env.getProperty("datasource-oracle.jpa.database-platform"));
		em.setJpaPropertyMap(properties);
		return em;
	}

	@Primary
	@Bean
	@ConfigurationProperties(prefix = "datasource-oracle")
	public DataSource icubeDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean
	public PlatformTransactionManager icubeTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(icubeEntityManagerFactory().getObject());
		return transactionManager;
	}
}
