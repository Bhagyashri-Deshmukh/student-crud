package com.justcodeit.studentcrude.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.justcodeit.studentcrude.pojo.Student;
import com.justcodeit.studentcrude.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@GetMapping("/get-all-students")
	public List<Student> getAllStudents() {		
		// TODO Auto-generated method stub
		return studentService.getAllStudents();
	}
	
	@GetMapping("/get-student-by-id/{id}")
	public Student getStudentById(@PathVariable Integer id) {
		// TODO Auto-generated method stub
		return studentService.getStudentById(id);
	}
}
