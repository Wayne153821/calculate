package com.size.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet set;
	
//  ͨ�õ�����ɾ����                                     �ɱ����
	public int updateDate(Connection conn,String sql,Object... objs) throws SQLException {
		// �������ݿⲽ��
		
//			Connection conn=DBHelper.getConnection();
//			String sql ="insert into user(name,password) values (?,?)";
		this.conn=conn;
		//�õ�ִ��ƽ̨
			ps=conn.prepareStatement(sql);
			//3-1:���ʺŸ�ֵ
			for(int i = 0;i<objs.length;i++) {
				ps.setObject(i+1, objs[i]);
			}
			//4:ִ��sql���
//			ps.setString(1,"С����");
//			ps.setString(2,"6678");
			
			//4��ִ��sql���
			return ps.executeUpdate();

	
		
	}
	//ͨ�õ�һ���޸Ķ������ݵķ���
	public int[] updateDateMore(Connection conn,String sql,Object[][] objs) throws SQLException {
		this.conn=conn;
		//�õ�ִ��ƽ̨
			ps=conn.prepareStatement(sql);
			//3-1:���ʺŸ�ֵ
			for(int i = 0;i<objs.length;i++) {
				for(int j = 0;j<objs[i].length;j++) {
				ps.setObject(j+1, objs[i][j]);
				}
				ps.addBatch();
				
			}	
			//4��ִ��sql���
			return ps.executeBatch();

	
		
	}
	
	
	
//  ͨ�õĲ�ѯ                                         �ɱ����
	public ResultSet selectDate(Connection conn,String sql,Object... objs) throws SQLException {		    
		    this.conn=conn;
			ps=conn.prepareStatement(sql);
			for(int i = 0;i<objs.length;i++) {
				ps.setObject(i+1, objs[i]);
			}
			set = ps.executeQuery();
			return set;
	}	
	
	//ͨ�õĹر���Դ�ķ���
	public void closeALL() {
			try {
				if(set != null) {
				set.close();
			    } 
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close();
				}
//				System.out.println("---��Դ�رճɹ�---");
			}	catch (SQLException e) {
				e.printStackTrace();
			}
		
		
	}

}