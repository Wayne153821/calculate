package com.size.service;

import java.util.List;

import com.size.entity.Admin;


public interface AdminService {
	//��
	int AddAdmin(Admin admin);
	//ɾ
	//��
	
	//��
	Admin findAdminByLogin(Admin admin);
	//��
	Admin findAdminById(int id);
	//��
	List<Admin> findAllAdmins();
	//��
}
