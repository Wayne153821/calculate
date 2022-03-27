package com.size.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.size.entity.Admin;

public class AdminDaoImp extends BaseDao implements AdminDao {

	@Override
	public ResultSet selectAdminByLogin(Connection conn, Admin admin) throws SQLException {
		String sql="select * from admin where admin_name=? and admin_password=?";
		return super.selectDate(conn, sql, admin.getAdmin_name(),admin.getAdmin_password());
	}

	@Override
	public ResultSet selectAdminById(Connection conn, int id) throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultSet selectAllAdmins(Connection conn) throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public int insertAdmin(Connection conn, Admin admin) throws SQLException {
		String sql = "insert into admin(admin_name,admin_password) value (?,?)";
		return super.updateDate(conn,sql,admin.getAdmin_name(),admin.getAdmin_password());
	}

}
