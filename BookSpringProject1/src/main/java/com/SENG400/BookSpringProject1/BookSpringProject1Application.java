package com.SENG400.BookSpringProject1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;


import com.SENG400.BookSpringProject1.domain.Car;
import com.SENG400.BookSpringProject1.domain.CarRepository;
import com.SENG400.BookSpringProject1.domain.Owner;
import com.SENG400.BookSpringProject1.domain.OwnerRepository;
import com.SENG400.BookSpringProject1.domain.User;
import com.SENG400.BookSpringProject1.domain.UserRepository;

//Main class

@SpringBootApplication
public class BookSpringProject1Application {

	private static final Logger logger = LoggerFactory.getLogger(BookSpringProject1Application.class);
	@Autowired
	private CarRepository repository;
	
	@Autowired
	private OwnerRepository orepository;
	
	@Autowired
	private UserRepository urepository;

	public static void main(String[] args) {
		SpringApplication.run(BookSpringProject1Application.class, args);
		logger.info("Hello Spring Boot");
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			// Add owner objects and save these to db
			Owner owner1 = new Owner("John" , "Johnson");
			Owner owner2 = new Owner("Mary" , "Robinson");
			orepository.save(owner1);
			orepository.save(owner2);
			// Add car object with link to owners and save these to db.
			repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1));
			repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2));
			repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2));
			
			urepository.save(new User("user", "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi", "USER"));
			urepository.save(new User("admin", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG", "ADMIN"));
		};

	}
}


