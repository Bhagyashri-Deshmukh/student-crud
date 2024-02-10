package com.justcodeit.studentcrude.pojo;

import java.time.LocalDateTime;

public class Student {

	private Integer id;
	private String name;
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
