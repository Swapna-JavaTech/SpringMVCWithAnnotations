package com.hexware.springmvcjdbcannotationsexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.hexware.springmvcjdbcannotationsexample.dao.EmployeeDao;
import com.hexware.springmvcjdbcannotationsexample.dao.EmployeeDaoImpl;

@Configuration
@EnableWebMvc
@ComponentScan("com.hexware.springmvcjdbcannotationsexample")
public class WebMvcConfig {
	
	@Bean
	InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/JSP/");
		vr.setSuffix(".jsp");
		return vr;
	}
	
	@Bean
	DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/sample");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	
	@Bean
	EmployeeDao getEmpDao() {
		return new EmployeeDaoImpl(getDataSource());
	}

}
