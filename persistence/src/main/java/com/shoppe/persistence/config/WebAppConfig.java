package com.shoppe.persistence.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author NarenderK
 *
 */
@Configuration
@ComponentScan(basePackages = { "com.shoppe.persistence" })
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.shoppe.persistence.repository" })
public class WebAppConfig {

	@Value("${db.driver}")
	private String dbDriver;

	@Value("${db.url}")
	private String dbURL;

	@Value("${db.username}")
	private String dbUserName;

	@Value("${db.password}")
	private String dbPassword;

	@Value("${hibernate.dialect}")
	private String hibernateDialect;

	@Value("${hibernate.ejb.naming_strategy}")
	private String hibernateEjbNamingStrategy;

	@Bean(name = "dataSource", destroyMethod = "close")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(dbDriver);
		dataSource.setUrl(dbURL);
		dataSource.setUsername(dbUserName);
		dataSource.setPassword(dbPassword);
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagaerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "com.shoppe" });

		JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(jpaVendorAdapter);
		em.setJpaProperties(jpaProperties());
		return em;
	}

	Properties jpaProperties() {
		Properties prop = new Properties();
		prop.setProperty("hibernate.dialect", hibernateDialect);
		prop.setProperty("hibernate.ejb.naming_strategy", hibernateEjbNamingStrategy);
		return prop;

	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

}
