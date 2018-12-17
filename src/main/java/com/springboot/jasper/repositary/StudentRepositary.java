package com.springboot.jasper.repositary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.jasper.model.Student;
import com.springboot.jasper.model.StudentBudgetCode;
import com.springboot.jasper.model.StudentBudgetCodeMapper;
import com.springboot.jasper.model.StudentMapper;

@Repository
public class StudentRepositary {
	
	 @Autowired
	    JdbcTemplate jdbcTemplet;
	 
private final String STUDENT_ID =  "select SPRIDEN_ID,SPRIDEN_LAST_NAME,SPRIDEN_FIRST_NAME from spriden where SPRIDEN_ID= ?";


private final String STUDENTS =  "select SPRIDEN_ID,SPRIDEN_LAST_NAME,SPRIDEN_FIRST_NAME from spriden";

private final String STUDENTS_BUDGET =  "SELECT\r\n" + 
		"     SPRIDEN.\"SPRIDEN_ID\",\r\n" + 
		"     sum(RBRAPBC_AMT)Amount\r\n" + 
		"FROM\r\n" + 
		"     \"SPRIDEN\" SPRIDEN,\r\n" + 
		"     \"RBRAPBC\" RBRAPBC\r\n" + 
		"WHERE\r\n" + 
		"     1 = 1\r\n" + 
		"     and spriden_change_ind IS null\r\n" + 
		"     and RBRAPBC_PBCP_CODE = 'AWAY'\r\n" + 
		"     and SPRIDEN_PIDM = RBRAPBC_PIDM\r\n" + 
		"     and RBRAPBC_AIDY_CODE = 1819\r\n" + 
		"GROUP BY\r\n" + 
		"     SPRIDEN_ID,\r\n" + 
		"     SPRIDEN_LAST_NAME,\r\n" + 
		"     SPRIDEN_FIRST_NAME\r\n" + 
		"ORDER BY\r\n" + 
		"     1 ASC";



	public Student getStudent(String id) {
	
		return jdbcTemplet.queryForObject(STUDENT_ID, new Object[] { id }, new StudentMapper());
	}
	
	public List<Student> getAllStudents(){
		return jdbcTemplet.query(STUDENTS,new StudentMapper());
	}
	
	public List<StudentBudgetCode> getBudgetCodeStudentsList() {
		return jdbcTemplet.query(STUDENTS_BUDGET,new StudentBudgetCodeMapper());
	}
	
}
