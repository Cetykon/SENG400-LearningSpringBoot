package com.SENG400.BookSpringProject1.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


//offers methods to fetch entities using pagination and sorting
//import org.springframework.data.repository.PagingAndSortingRepository;
//public interface CarRepository extends PagingAndSortingRepository<Car,
//Long> {
//}



public interface CarRepository extends CrudRepository <Car, Long> {
	// three simple queries:
	// Fetch cars by brand
	List<Car> findByBrand(String brand);
	// Fetch cars by color
	List<Car> findByColor(String color);
	 // Fetch cars by year
	List<Car> findByYear(int year);
	
	//multiple fields after the By keyword, concatenated with the And or Or
	// Fetch cars by brand and model
	List<Car> findByBrandAndModel(String brand, String model);
	// Fetch cars by brand or color
	List<Car> findByBrandOrColor(String brand, String color);
	 
	//Queries can be sorted by using the OrderBy
	// Fetch cars by brand and sort by year
	List<Car> findByBrandOrderByYearAsc(String brand);
	 
	//create queries by using SQL statements via the @Query annotation
	// Fetch cars by brand using SQL
	@Query("select c from Car c where c.brand = ?1")
	List<Car> findByBrandMade(String brand);
	// Fetch cars by brand using SQL
	@Query("select c from Car c where c.brand like %?1")
	List<Car> findByBrandEndsWith(String brand);
	

}


