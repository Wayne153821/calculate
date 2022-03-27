package com.size.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.size.util.DBHelper;
import com.size.dao.GradeDaoImp;
import com.size.entity.Grade;

public class GradeServiceImp implements GradeService {
	
     private GradeDaoImp gd;
	
	public  GradeServiceImp() {
		gd=new GradeDaoImp();
	}
	

	@Override
	public List<Grade> findAllGrades() {
		ArrayList<Grade> list = new ArrayList<Grade>();		
		Connection conn = DBHelper.getConnection();
		ResultSet set;
		try {
			set = gd.selectAllGrades(conn);
			while(set.next()) {
				int id = set.getInt("id");
				int score = set.getInt("score");
				String time = set.getString("time");
				
				
				list.add(new Grade(id,score,time));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			gd.closeALL();
		}
		
		
		
		return list;
	}

	@Override
	public int AddGrade(Grade grade) {
		int i=0;
        Connection conn=null;
        try {
            conn=DBHelper.getConnection();
            i=gd.insertGrade(conn, grade);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            gd.closeALL();
        }
        return i;
	}


	@Override
	public List<Grade> findTodayGrades(String now_time) {
		ArrayList<Grade> list = new ArrayList<Grade>();		
		Connection conn = DBHelper.getConnection();
		ResultSet set;
		try {
			set = gd.selectTodayGrades(conn,now_time);
			while(set.next()) {
				int id = set.getInt("id");
				int score = set.getInt("score");
				String time = set.getString("time");		
				list.add(new Grade(id,score,time));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			gd.closeALL();
		}
		
		
		
		return list;
	}


	@Override
	public List<Grade> findFive() {
		Connection conn=DBHelper.getConnection();
		ArrayList<Grade> list = new ArrayList<Grade>();
		ResultSet set;
		try {
			set=gd.selectFive(conn);
			while (set.next()) {
				int id=set.getInt("id");
				int score=set.getInt("score");
				String time=set.getString("time");
				list.add(new Grade(id,score,time));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			gd.closeALL();
		}
		// TODO 自动生成的方法存根
		return list;
	}

}
