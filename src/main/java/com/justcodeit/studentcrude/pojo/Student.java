package com.justcodeit.studentcrude.pojo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

//@JsonIgnoreProperties("birthDate") => to ignore field at class level
//@JsonIgnoreProperties({"birthDate","name"}) // to ignore multiple fields at class level
public class Student {

	@Positive
	private Integer id;
	
	@Size(min=4, message="Name should be at least 4 characters.")
	private String name;
	
	@PastOrPresent
	//@JsonProperty("birth_date")
	//@JsonIgnore => to ignore field at field level
	private LocalDateTime birthDate;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Integer id, String name, LocalDateTime birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}

}
