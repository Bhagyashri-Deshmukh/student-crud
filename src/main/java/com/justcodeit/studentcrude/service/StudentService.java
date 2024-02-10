package com.justcodeit.studentcrude.service;

import java.util.List;
import com.justcodeit.studentcrude.pojo.Student;

public interface StudentService {

	public List<Student> getAllStudents();
	
	public Student getStudentById(Integer id);
}
