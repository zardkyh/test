package com.gccity.traffic.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
		entityManagerFactoryRef = "mariadbEntityManagerFactory",
		transactionManagerRef = "mariadbTransactionManager",
		basePackages = {"com.gccity.traffic.repository.mariadb"}
)
public class MariaDBConfig {

	@Autowired
	private Environment env;

	@Bean(name = "mariadbEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean erpEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(erpDataSource());
		em.setPackagesToScan(new String[] {"com.gccity.traffic.entity.mariadb"});
		em.setPersistenceUnitName("mariadbEntityManager"); // 영속성 객체 이름을 지정
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("datasource-mariadb.jpa.hibernate.ddl-auto"));
		properties.put("hibernate.dialect", env.getProperty("datasource-mariadb.jpa.database-platform"));
		em.setJpaPropertyMap(properties);
		return em;
	}

	@Bean
	@ConfigurationProperties(prefix = "datasource-mariadb")
	public DataSource erpDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	public PlatformTransactionManager erpTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(erpEntityManagerFactory().getObject());
		return transactionManager;
	}
}
