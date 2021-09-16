package com.spring.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.student.dao.StudentDao;
import com.spring.student.model.Student;


@Service
public class StudentService {
	
	
	@Autowired
	private StudentDao dao;
	
	public List<Student> getStudentData(){
		List<Student> stlist = dao.getStudentData();
		return stlist;
	}

	public Student getStudentId(int id) {
		
		List<Student> stlist = dao.getStudentData();
		
		Optional<Student> student = stlist.stream().filter(studen->(studen.getId()==id)).findFirst();
		
//		System.out.println(student.get());
		
		return student.get();
	}
	
	public boolean addstudentToDb(Student st) {
		
		boolean status = dao.addstudentToDb(st);
		return status;
	}

	public boolean delstudentfromdb(int id) {
		
		boolean status = dao.delstudentfromDb(id);
		return status;
	}
}
