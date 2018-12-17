package com.springboot.jasper.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements  RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Student student = new Student();
		//select SPRIDEN_ID,SPRIDEN_LAST_NAME,SPRIDEN_FIRST_NAME
		student.setId(rs.getString("SPRIDEN_ID"));
		student.setFirstName(rs.getString("SPRIDEN_FIRST_NAME"));
		student.setLastName(rs.getString("SPRIDEN_LAST_NAME"));
		return student;
	}

}
