package com.example.springboothelloworld;

import com.example.springboothelloworld.servlet.HelloFilter;
import com.example.springboothelloworld.servlet.HelloListener;
import com.example.springboothelloworld.servlet.HelloServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootHelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloworldApplication.class, args);
	}

	//Register servlet
	@Bean
	public ServletRegistrationBean getServletRegistrationBean(){
		ServletRegistrationBean servletBean = new ServletRegistrationBean(new HelloServlet());
		servletBean.addUrlMappings("/helloServlet");
		return servletBean;
	}

	//Register Filter
	@Bean
	public FilterRegistrationBean getFilterRegistrationBean(){
		FilterRegistrationBean filterBean = new FilterRegistrationBean(new HelloFilter());
		// Add Filter path
		filterBean.addUrlPatterns("/helloServlet");
		return filterBean;
	}

	//Register Listener
	@Bean
	public ServletListenerRegistrationBean<HelloListener> getServletListenerRegistrationBean(){
		ServletListenerRegistrationBean listenerBean = new ServletListenerRegistrationBean(new HelloListener());
		return listenerBean;
	}
}
