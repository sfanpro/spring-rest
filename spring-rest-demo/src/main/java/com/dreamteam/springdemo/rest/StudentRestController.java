package com.dreamteam.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dreamteam.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;

	// define @PostConstruct to load the student data ... only once!
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();

		theStudents.add(new Student("Mike", "Fast"));
		theStudents.add(new Student("Nike", "Doer"));
		theStudents.add(new Student("Mary", "Smith"));
		theStudents.add(new Student("John", "Honest"));

	}

	// define endpoint for "/student/{studentId}" - return student at index
	@GetMapping("/students/{studentId}")
	public Student getStudents(@PathVariable int studentId) {
		// index into the list
		return theStudents.get(studentId);
	}

}
