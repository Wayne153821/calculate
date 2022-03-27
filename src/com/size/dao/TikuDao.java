package com.size.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.size.entity.Tiku;


public interface TikuDao {
	int insertTiku(Connection conn,Tiku tiku)throws SQLException;
	
}
