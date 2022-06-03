package com.oth.student;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.oth.student.dao.StudentRepository;
import com.oth.student.entities.Student;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

	@Bean
	CommandLineRunner run(StudentRepository studentRepository) {
		return args -> {
			List<Student> students = Arrays.asList(
					new Student("Othman", "BOUAZZAOUI", LocalDate.now(), Student.GENDER.MALE),
					new Student("Abdellah", "Abdellah", LocalDate.now(), Student.GENDER.MALE),
					new Student("Salim", "Salem", LocalDate.now(), Student.GENDER.MALE),
					new Student("Ayoub", "BOUAZZAOUI", LocalDate.now(), Student.GENDER.MALE),
					new Student("Mohamed", "Khaled", LocalDate.now(), Student.GENDER.MALE),
					new Student("Fatima", "FAT", LocalDate.now(), Student.GENDER.MALE),
					new Student("Khadouj", "LAK", LocalDate.now(), Student.GENDER.FEMALE)
					);
		
			students.stream().forEach(s -> studentRepository.save(s));
		};
	}

}
