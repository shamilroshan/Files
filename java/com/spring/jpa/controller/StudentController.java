package com.spring.jpa.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.entities.Student;
import com.spring.jpa.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	
	@Autowired
	private StudentService service;
	
	@RequestMapping(value="/studentinfo",method=RequestMethod.GET)
	public List<Student> getAllData(){
		
		return service.getStudentData();		
	}
	
	@RequestMapping(value="/poststudent" ,method=RequestMethod.POST,consumes= org.springframework.http.MediaType.APPLICATION_JSON_VALUE,produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public Student getDataByid(@RequestBody Student student) {
		
		int id=student.getId();
		Student st = service.getStudentInfo(id);
		return st;
	}
	
	@RequestMapping(value="/putstudent",method =RequestMethod.PUT,consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public Student putDataIntoDb(@RequestBody Student student) {
		
		
		return service.putStudentInfo(student);
		
	}

}
