package com.size.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.size.entity.Admin;


public interface AdminDao {	
	//��
	int insertAdmin(Connection conn,Admin admin)throws SQLException;
	//ɾ
	//��
	
	//��
	ResultSet selectAdminByLogin(Connection conn,Admin admin) throws SQLException;
	//��
	ResultSet selectAdminById(Connection conn,int id) throws SQLException;
	//��
	ResultSet selectAllAdmins(Connection conn) throws SQLException;
	//��

}
