package com.size.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.size.entity.Tiku;

public class TikuDaoImp extends BaseDao implements TikuDao{

	@Override
	public int insertTiku(Connection conn, Tiku tiku) throws SQLException {
		String sql = "insert into tiku(problem,answer) value (?,?)";
		return super.updateDate(conn,sql,tiku.getProblem(),tiku.getAnswer());
	}

	
	
}