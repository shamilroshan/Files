package com.spring.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.jpa.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findByid(int id);
}
