package com.justcodeit.studentcrude.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.justcodeit.studentcrude.pojo.Student;
import com.justcodeit.studentcrude.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	static List<Student> studentList = new ArrayList<Student>();
	
	static {
		
		Student st1 = new Student(100, "Rohit", LocalDateTime.of(1992, 04, 14, 10, 59, 25, 50));
		Student st2 = new Student(101, "Neha", LocalDateTime.of(1995, 05, 10, 11, 59, 26, 55));
		Student st3 = new Student(102, "Priyanka", LocalDateTime.of(1993, 04, 14, 10, 59, 25, 50));
		Student st4 = new Student(103, "Sunil", LocalDateTime.of(1996, 05, 10, 11, 59, 26, 55));
		
		studentList.add(0, st1);
		studentList.add(1, st2);
		studentList.add(2, st3);
		studentList.add(3, st4);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentList;
	}

	@Override
	public Student getStudentById(Integer id) {
		// TODO Auto-generated method stub
		for(Student student:studentList) {
			if(student.getId().equals(id)) {
				return student;
			}
		}
		return null;
	}

	@Override
	public Student updateStudent(Student student, Integer id) {
		// TODO Auto-generated method stub
		student.setId(student.getId());
		student.setName(student.getName());
		student.setBirthDate(student.getBirthDate());
		studentList.set(1, student);
		return student;
	}

	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		 studentList.add(student);
		 return student;
	}

	@Override
	public boolean deletStudent(Integer id) {
		// TODO Auto-generated method stub
		for(Student student : studentList) {
			if(student.getId().equals(id)) {
				studentList.remove(student);
				return true;
			}
		}
		return false;
	}

}
