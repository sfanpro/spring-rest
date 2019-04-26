package com.dreamteam.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dreamteam.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	// define endpoint for "/student" - return list of student
	@GetMapping("/student")
	public List<Student> getStudents() {
		List<Student> theStudent = new ArrayList<>();

		theStudent.add(new Student("Mike", "Fast"));
		theStudent.add(new Student("Nike", "Doer"));
		theStudent.add(new Student("Mary", "Smith"));
		theStudent.add(new Student("John", "Honest"));

		return theStudent;
	}
}
