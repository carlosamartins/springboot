package com.sample.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sample.app.model.Employee;

@Configuration
public class EmployeeConfiguration {

	@Bean("krishna")
	public Employee newEmployee1() {
		Employee emp = new Employee();
		emp.setId(1);
		emp.setFirstName("Krishna");
		emp.setLastName("Majety");
		return emp;
	}

	@Bean("ram")
	public Employee newEmployee2() {
		Employee emp = new Employee();
		emp.setId(2);
		emp.setFirstName("Ram");
		emp.setLastName("Gurram");
		return emp;
	}
}