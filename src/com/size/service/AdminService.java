package com.size.service;

import java.util.List;

import com.size.entity.Admin;


public interface AdminService {
	//增
	int AddAdmin(Admin admin);
	//删
	//改
	
	//查
	Admin findAdminByLogin(Admin admin);
	//查
	Admin findAdminById(int id);
	//查
	List<Admin> findAllAdmins();
	//查
}
