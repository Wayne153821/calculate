package com.size.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.size.entity.Grade;

public class GradeDaoImp extends BaseDao implements GradeDao {
	@Override
	public ResultSet selectAllGrades(Connection conn) throws SQLException {
		String sql ="select * from grade";		
		return super.selectDate(conn, sql);
	}

	@Override
	public int insertGrade(Connection conn, Grade grade) throws SQLException {
		String sql = "insert into grade(score,time) value (?,?)";
		return super.updateDate(conn,sql,grade.getScore(),grade.getTime());
	}

	@Override
	public ResultSet selectTodayGrades(Connection conn,String now_time) throws SQLException {
		String sql ="select * from grade where time=?";
		return super.selectDate(conn, sql, now_time);
	}

	@Override
	public ResultSet selectFive(Connection conn) throws SQLException {
		String sql="SELECT * FROM (select * from grade order by id desc limit 5) aa ORDER BY id";
		// TODO 自动生成的方法存根
		return super.selectDate(conn, sql);
	}

}
