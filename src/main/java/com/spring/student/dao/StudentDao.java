package com.spring.student.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.spring.student.model.Student;

@Component
public class StudentDao {
	
	@Autowired
	public JdbcTemplate template;

	public List<Student> getStudentData() {

		String sql = "SELECT * FROM studentdetails";

		List<Student> studentlist = template.query(sql, new ResultSetExtractor<List<Student>>() {

			@Override
			public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<Student> list = new ArrayList<>();
				while (rs.next()) {
					Student student = new Student();
					student.setId(rs.getInt("id"));
					student.setName(rs.getString("name"));
					student.setBranch(rs.getString("branch"));
					list.add(student);

				}
				return list;

			}

		});
		studentlist.stream().forEach(student -> {
			System.out.println(student.getId() + student.getName() + student.getBranch());
		});
		return studentlist;

	}
	
	public boolean addstudentToDb(Student st) {
		
		
		boolean status=false;
		try {
		String sql ="insert into studentdetails(id,name,branch) values("+st.getId()+",'"+st.getName()+"','"+st.getBranch()+"')";
		
		template.execute(sql);
		status =true;
		}
		catch(Exception e) {
			status=false;
		}
		return status;
	}

	public boolean delstudentfromDb(int id) {
		
		boolean status=false;
		try {
		String sql = "delete from studentdetails where id="+id;
		template.execute(sql);
		status=true;
		}
		catch(Exception e)
		{
		status=true;
		}
		
		return status;
	}
	
	

}
