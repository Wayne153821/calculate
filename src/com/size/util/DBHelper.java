package com.size.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//��������ȡ�����ݿ������
public class DBHelper {
    private static String url="jdbc:mysql://localhost:3306/business?serverTimezone=UTC";
    private static String user="root";
    private static String password="";
    
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("---�������سɹ�---");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() {
		 try {
			return DriverManager.getConnection(url, user,password);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		 return null;
	}
	
}
