package com.example.Employee;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Employee.domain.Employee;
import com.example.Employee.domain.EmployeeRepository;
import com.example.Employee.domain.Department;
import com.example.Employee.domain.DepartmentRepository;
import com.example.Employee.domain.User;
import com.example.Employee.domain.UserRepository;

@SpringBootApplication
public class EmployeeApplication {
	private static final Logger log = LoggerFactory.getLogger(EmployeeApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(EmployeeRepository repository,DepartmentRepository crepository, UserRepository urepository) {
	return (args) -> {
		log.info("save a couple of books");
		
		crepository.save(new Department("Sales"));
		crepository.save(new Department("Marketing"));
		crepository.save(new Department("Development"));
		
		Employee book1 = new Employee("John", "Sales Representative", 25, "S21", 2500, crepository.findByName("Sales").get(0));
		Employee book2 = new Employee("Mikka", "Sales Manger", 30, "S12", 6000, crepository.findByName("Sales").get(0));
		Employee book3 = new Employee("Ettu", "Digital Marketing", 41, "M13", 2500, crepository.findByName("Marketing").get(0));
		Employee book4 = new Employee("Jussi", "Specialist", 27, "M14", 2000, crepository.findByName("Marketing").get(0));
		Employee book5 = new Employee("Jonna", "Software Developer", 34, "D11", 4500, crepository.findByName("Development").get(0));
		Employee book6 = new Employee("Marko", "Researcher", 42, "D23", 4000, crepository.findByName("Development").get(0));
		
	
		repository.save(book1);
		repository.save(book2);
		repository.save(book3);
		repository.save(book4);
		repository.save(book5);
		repository.save(book6);
		
		//Demo user
				//https://www.browserling.com/tools/bcrypt using this to generate bcrypt password
				User user1 = new User("user", "$2a$10$n1UULdce1utCr3tC/XLP0OjIOAwjFB0yCImFkAgeyXcevf9jPnK3.", "admin@gmail.com", "USER");
				User user2 = new User("admin", "$2a$10$cDLOfjCusgDBg0WSaWOs7ewujF4PTAgW5FednrvNlpR05d73Jp./q", "user@gmail.com", "ADMIN");
				urepository.save(user1);
			    urepository.save(user2);

		
		
		log.info("fetch all books");
		for (Employee book : repository.findAll()) {
			log.info(book.toString());
		}
	
	};
	}

}
