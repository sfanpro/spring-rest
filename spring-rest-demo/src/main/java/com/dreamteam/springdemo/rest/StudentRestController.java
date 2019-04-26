package com.dreamteam.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
		// check the studentId against list size
		if ((studentId >= theStudents.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student id not found: " + studentId);
		}
		return theStudents.get(studentId);
	}

	// Add an exception handler using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e) {
		// create a StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessege(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// return RespomseEntity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// add exception handler ... to catch any other exception
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception e) {
		// create a StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessege(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// return RespomseEntity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
