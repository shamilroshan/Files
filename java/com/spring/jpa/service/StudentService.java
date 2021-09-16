package com.spring.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.jpa.entities.Student;
import com.spring.jpa.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	

	public List<Student> getStudentData() {
		
		 List<Student> stlist = repository.findAll();
		return stlist;
	}
	
	public Student getStudentInfo(int id) {
		Student stu = repository.findByid(id);
		return stu;
		
	
	}
	
	public Student putStudentInfo(Student student) {
		Student st = repository.save(student);
		st.setId(student.getId());
		st.setName(student.getName());
		st.setBranch(student.getBranch());
		return st;
		
		
	}

}
