package com.oth.student.service;

import java.util.List;

import com.oth.student.entities.Student;

public interface StudentService {
	
	Student findStudentById(Long id);
	
	List<Student> findAllStudents();

	Student addStudent(Student student);
	
	Student updateStudent(Student student);
	
	void deleteStudentById(Long id);
	
}
