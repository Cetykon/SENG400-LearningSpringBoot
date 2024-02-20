package com.SENG400.BookSpringProject1.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
// @JsonIgnore is use so the find all cars doesn't go in an infinite loop 
//as it looks for the cars then the owner and they the owner has cars so on...
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Owner {
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private long ownerid;
	 private String firstname, lastname;
	 public Owner() {}
	 public Owner(String firstname, String lastname) {
	 super();
	 this.firstname = firstname;
	 this.lastname = lastname;
	 }
	 
	 
	 @OneToMany(cascade = CascadeType.ALL, mappedBy="owner")
	 @JsonIgnore
	 private List<Car> cars;
	 //Getter and setter
	 public List<Car> getCars() {
		 return cars;
	 }
	 public void setCars(List<Car> cars) {
		 this.cars = cars;
	 }
	 
	 public long getOwnerid() {
	 return ownerid;
	 }
	 public void setOwnerid(long ownerid) {
	 this.ownerid = ownerid;
	 }
	 public String getFirstname() {
	 return firstname;
	 }
	 public void setFirstname(String firstname) {
	 this.firstname = firstname;
	 }
	 public String getLastname() {
	 return lastname;
	 }
	 public void setLastname(String lastname) {
	 this.lastname = lastname;
	 }
	 }
