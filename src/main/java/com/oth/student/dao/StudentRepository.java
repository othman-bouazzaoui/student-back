package com.oth.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oth.student.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
