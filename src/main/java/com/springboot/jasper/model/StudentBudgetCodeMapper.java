package com.springboot.jasper.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentBudgetCodeMapper implements  RowMapper<StudentBudgetCode> {

	@Override
	public StudentBudgetCode mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		StudentBudgetCode student = new StudentBudgetCode();
		//select SPRIDEN_ID,SPRIDEN_LAST_NAME,SPRIDEN_FIRST_NAME
		student.setSPRIDEN_ID((rs.getString("SPRIDEN_ID")));
		student.setAMOUNT(rs.getDouble("Amount"));
		return student;
	}

}
