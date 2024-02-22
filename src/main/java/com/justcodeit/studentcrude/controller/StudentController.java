package com.justcodeit.studentcrude.controller;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
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

import jakarta.validation.Valid;

// this is rest controller which is combination pf @Controller and @ResponseBody
@RestController
public class StudentController {
	
	// @Autowired is used to inject bean at runtime
	@Autowired
	private StudentService studentService;
	
	// MessageSource is used for internationalisation using which we can display/read messages in multiple languages
	private MessageSource messageSource;	
	
	public StudentController(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}

	@GetMapping("/get-internationalisation")
	public String internationalisation() {		
		// TODO Auto-generated method stub
		
		// locale is used to get language information which we pass as header from postman
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "This is a default message in eng", locale);
	}

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
	public ResponseEntity<Object> createStudent(@Valid @RequestBody Student student) {
		// TODO Auto-generated method stub
		//return studentService.createStudent(student);
		// /add-student/104
		Student st = studentService.createStudent(student);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest() // this line gives the path of current request
						.path("/{id}") // here we appending id to the current request
						.buildAndExpand(st.getId()) // use the id of newly created user
						.toUri(); // convert it into URI
		
		return ResponseEntity.created(location).build(); // returning the status 201
	}
	
	@DeleteMapping("/delete-student/{id}")
	public boolean deletStudent(@PathVariable Integer id) {
		// TODO Auto-generated method stub
		return studentService.deletStudent(id);
	}
}
