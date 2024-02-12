package com.justcodeit.studentcrude.service;

import java.util.List;

import com.justcodeit.studentcrude.exception.StudentNotFoundException;
import com.justcodeit.studentcrude.pojo.Student;

public interface StudentService {

	public List<Student> getAllStudents();
	
	public Student getStudentById(Integer id) throws StudentNotFoundException;
	
	public Student updateStudent(Student student, Integer id);
	
	public Student createStudent(Student student);
	
	public boolean deletStudent(Integer id);
}
