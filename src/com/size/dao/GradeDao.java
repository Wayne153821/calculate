package com.size.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.size.entity.Grade;

public interface GradeDao {
	int insertGrade(Connection conn,Grade grade)throws SQLException;

	ResultSet selectAllGrades(Connection conn) throws SQLException;
	
	ResultSet selectTodayGrades(Connection conn,String now_time) throws SQLException;
	
	ResultSet selectFive(Connection conn) throws SQLException;
}
