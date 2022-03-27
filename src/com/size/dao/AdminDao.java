package com.size.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.size.entity.Admin;


public interface AdminDao {	
	//增
	int insertAdmin(Connection conn,Admin admin)throws SQLException;
	//删
	//改
	
	//查
	ResultSet selectAdminByLogin(Connection conn,Admin admin) throws SQLException;
	//查
	ResultSet selectAdminById(Connection conn,int id) throws SQLException;
	//查
	ResultSet selectAllAdmins(Connection conn) throws SQLException;
	//查

}
