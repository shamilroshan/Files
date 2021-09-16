package com.spring.student.controller;

import java.util.List;
import java.util.Objects;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.student.model.Student;
import com.spring.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	
	@Autowired
	public StudentService service;
	
	@RequestMapping(value ="/getstudentdata",method=RequestMethod.GET)
	public List<Student> getStudentInfo() {
		
		List<Student> li = service.getStudentData();
		return li;
		
		
	}
	
	@RequestMapping(value = "/poststudentdata", method = RequestMethod.POST, consumes= org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces =org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public Student studentPostCall(@RequestBody Student student) {
		
		if(Objects.isNull(student.getId()) || (student.getId()==0)) {
			throw new IllegalArgumentException("Student id is mandatory or invalid argument passed");
		}
		
		Student studentobj = service.getStudentId(student.getId());
		
		return studentobj;																															
		
	}
	
	@RequestMapping(value="/putstudentdata" , method = RequestMethod.PUT, consumes=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public String studentPutCall(@RequestBody Student st) {
		
		boolean status = service.addstudentToDb(st);
		if(status==true) {
			return "Student details are added";		}
		else {
			return "Student details are not added";
		}
		
		
		
	}
	
	@RequestMapping(value ="/delstudentdata/{id}" , method=RequestMethod.DELETE)
	public String StudentDel(@PathVariable int id) {
		
		
		boolean status =  service.delstudentfromdb(id);
		if(status==true) {
			return id + "deleted";
		}
		else {
			return id + "not deleted";
		}
	}
	
	

}
