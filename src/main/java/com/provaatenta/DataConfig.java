package com.provaatenta;

import javax.sql.DataSource;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


import javax.annotation.Resource;



@Configuration
public class DataConfig {

	

	@Bean
	public DataSource dataSource() {
	
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/teste?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		
		dataSource.setUsername("root");
		dataSource.setPassword("thi4gon");
		
		return dataSource;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter(); /// cria conexao com o hibernate
		adapter.setDatabase(Database.MYSQL); // define banco
		adapter.setShowSql(true); 
		adapter.setGenerateDdl(true);//  
		adapter.setPrepareConnection(true);
		
		return adapter;
	}
	
	

}

	

