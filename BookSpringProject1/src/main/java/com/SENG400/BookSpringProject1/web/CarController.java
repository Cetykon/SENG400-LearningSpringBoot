package com.SENG400.BookSpringProject1.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SENG400.BookSpringProject1.domain.Car;
import com.SENG400.BookSpringProject1.domain.CarRepository;

@RestController
public class CarController {
	//You can define which method is accepted using
	//the following @RequestMapping("/cars", method=GET)
	
	@Autowired
	private CarRepository repository;

	@RequestMapping("/cars")
	public Iterable<Car> getCars() {
		return repository.findAll();
	}
}