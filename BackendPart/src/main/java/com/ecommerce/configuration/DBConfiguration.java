package com.ecommerce.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan("com.ecommerce")
@EnableTransactionManagement

public class DBConfiguration {
    
	private static final String DB_DRIVER="org.h2.Driver";
	private static final String DB_URL="jdbc:h2:tcp://localhost/~/test";
	private static final String DB_USERNAME="sa";
	private static final String DB_PASSWORD="";
	private static final String DB_DIALECT="org.hibernate.dialect.H2Dialect";
	
	@Bean("dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
	    dataSource.setDriverClassName(DB_DRIVER);
	    dataSource.setUrl(DB_URL);
	    dataSource.setUsername(DB_USERNAME);
	    dataSource.setPassword(DB_PASSWORD);
	    return dataSource;
	    		
	}
	@Bean("sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder Isfb = new LocalSessionFactoryBuilder(dataSource);
		
		Isfb.addProperties(getHibernateProperties());
		Isfb.scanPackages("com.ecommerce.model");
		return Isfb.buildSessionFactory();
	}
	private Properties getHibernateProperties()
	{
	Properties prop = new Properties();
	prop.put("hibernate.delect","DBDIALECT");
	prop.put("hibernate.show_sql","true");
	prop.put("hibernate.format_sql","true");
	prop.put("hibernate.hbm2ddl.auto","update");
	
	return prop;
	}
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	
}
