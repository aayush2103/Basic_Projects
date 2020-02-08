package com.infy.exercise;

@Configuration
public class ConfigurationFactory {
	@Bean
	public Employee employee() {
		return new Employee();
	}
}
