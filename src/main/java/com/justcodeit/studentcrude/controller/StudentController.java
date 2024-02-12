package com.justcodeit.studentcrude.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.justcodeit.studentcrude.exception.StudentNotFoundException;
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
	public Student getStudentById(@PathVariable Integer id) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		return studentService.getStudentById(id);
	}
	
	@PutMapping("/update-student/{id}")
	public Student updateStudent(@RequestBody Student student,@PathVariable Integer id) {
		// TODO Auto-generated method stub
		return studentService.updateStudent(student, id);
	}
	
	@PostMapping("/add-student")
	public ResponseEntity<Object> createStudent(@RequestBody Student student) {
		// TODO Auto-generated method stub
		//return studentService.createStudent(student);
		// /add-student/104
		Student st = studentService.createStudent(student);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(st.getId())
						.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/delete-student/{id}")
	public boolean deletStudent(@PathVariable Integer id) {
		// TODO Auto-generated method stub
		return studentService.deletStudent(id);
	}
}
