package com.demo2.spring.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.demo2.spring.dao.DepartmentDAO;
import com.demo2.spring.dao.DepartmentDAOImpl;
import com.demo2.spring.dao.EmployeeDAO;
import com.demo2.spring.dao.EmployeeDAOImpl;
import com.demo2.spring.dao.MeetingDAO;
import com.demo2.spring.dao.MeetingDAOImpl;
import com.demo2.spring.dao.MeetingDetailDAO;
import com.demo2.spring.dao.MeetingDetailDAOImpl;

@Configuration
@ComponentScan(basePackages="com.demo2.spring")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/worddb");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		
		return dataSource;
	}
	
	@Bean
	public DepartmentDAO getDepartmentDAO() {
		return new DepartmentDAOImpl(getDataSource());
	}

	@Bean
	public EmployeeDAO getEmployeeDAO() {
		return new EmployeeDAOImpl(getDataSource());
	}

	@Bean
	public MeetingDAO getMeetingDAO() {
		return new MeetingDAOImpl(getDataSource());
	}	
	
	@Bean
	public MeetingDetailDAO getMeetingDetailDAO() {
		return new MeetingDetailDAOImpl(getDataSource());
	}		
}
