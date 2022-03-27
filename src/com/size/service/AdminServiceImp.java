package com.size.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.size.dao.AdminDaoImp;
import com.size.entity.Admin;
import com.size.util.DBHelper;

public class AdminServiceImp implements AdminService{

	private AdminDaoImp ad;
	
	public AdminServiceImp() {
		ad=new AdminDaoImp();
	}

	@Override
	public Admin findAdminByLogin(Admin admin) {
		Connection conn = DBHelper.getConnection();
		try {
			ResultSet set = ad.selectAdminByLogin(conn, admin);
			if(set.next()) {
				int admin_id=set.getInt("admin_id");
				String admin_name = set.getString("admin_name");
				String admin_password = set.getNString("admin_password");
				return new Admin(admin_id,admin_name,admin_password);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ad.closeALL();
		}
		return null;
	}

	@Override
	public Admin findAdminById(int id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<Admin> findAllAdmins() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public int AddAdmin(Admin admin) {
		int i=0;
        Connection conn=null;
        try {
            conn=DBHelper.getConnection();
            i=ad.insertAdmin(conn,admin);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ad.closeALL();
        }
        return i;
	}
	
	

}
