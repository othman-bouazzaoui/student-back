package com.oth.student.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oth.student.entities.Student;
import com.oth.student.service.StudentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("students")
public class StudentRestController {

	private StudentService studentService;

	public StudentRestController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping
	public ResponseEntity<List<Student>> allStudents() {
		return ResponseEntity.ok(studentService.findAllStudents());
	}

	@GetMapping("{id}")
	public ResponseEntity<Student> findStudentById(@PathVariable Long id) {
		return ResponseEntity.ok(studentService.findStudentById(id));
	}

	@PostMapping
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(student));
	}

	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student student) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentService.updateStudent(student));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteStudentById(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return ResponseEntity.noContent().build();

	}

}
