package com.SENG400.BookSpringProject1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.SENG400.BookSpringProject1.web.CarController;

@SpringBootTest
class BookSpringProject1ApplicationTests {
	@Autowired
	private CarController controller;
	
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}
}