package com.nit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Sort;

import com.nit.entity.Employee;
import com.nit.repositories.EmployeeRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		EmployeeRepository repository = run.getBean(EmployeeRepository.class);
		/*
		 * Sort s = Sort.by("empId"); //Sorting List<Employee> all =
		 * repository.findAll(s.reverse()); System.out.println(all);
		 */
		
		List<Employee> all = repository.findAll(Sort.by("empSal","empName").descending()); 
		for (Employee employee : all) {           //another way to the Sort we can sort based on multiple values also like above
			System.out.println(employee);
		}
	}
}
