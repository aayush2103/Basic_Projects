package com.infy.exercise;

@ComponentScan(basePackages= {"exercise"})
public class EmployeeStarter {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.register(ConfigurationFactory.class);
		appContext.refresh();
		Employee employee = (Employee) appContext.getBean("employee");
		System.out.println(employee.getName());
		appContext.close();
	}
}
