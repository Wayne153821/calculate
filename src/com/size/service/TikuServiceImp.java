package com.size.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.size.dao.TikuDaoImp;
import com.size.entity.Tiku;
import com.size.util.DBHelper;

public class TikuServiceImp implements TikuService {
	
    private TikuDaoImp td;
	
	public  TikuServiceImp() {
		td=new TikuDaoImp();
	}
	

	@Override
	public List<Tiku> CreatePro() {
		ArrayList<Tiku> list=new ArrayList<Tiku>();
        String problem = null;
		
		int answer = 0;
		
		// TODO Auto-generated method stub

		for(int i = 0;i < 20;i++){
			
		int firNum = (int)(1 + Math.random()*99);//生成1到99的随机数

		int secNum = 1 + (int)(Math.random()*99);
		
		int tirNum = 1 + (int)(Math.random()*99);
		
		int operaNum1 = 1 + (int)(Math.random()*4);
		
		int operaNum2 = 1 + (int)(Math.random()*4);//用1到4分别代表加减乘除

		if(operaNum1 == 1 && operaNum1 == 1)
		{
		

		problem = firNum + "+" + secNum + "+" + tirNum + "=?";
		answer = firNum + secNum + tirNum;
						
		}

		else if(operaNum1 == 1 && operaNum2 == 2)
		{
		
		problem = firNum + "+" + secNum + "-" + tirNum + "=?";
		answer = firNum + secNum - tirNum;
			
		}
		
		else if(operaNum1 == 1 && operaNum2 == 3)
		{
		
		problem = firNum + "+" + secNum + "*" + tirNum + "=?";
		answer = firNum + secNum * tirNum;
			
		}
		
		else if(operaNum1 == 1 && operaNum2 == 4)
		{
		
		problem = firNum + "+" + secNum + "/" + tirNum + "=?";
		answer = firNum + secNum / tirNum;
		}
		
		else if(operaNum1 == 2 && operaNum2 == 1)
		{
		
		problem = firNum + "-" + secNum + "+" + tirNum + "=?";
		answer = firNum - secNum + tirNum;
		}
		
		else if(operaNum1 == 2 && operaNum2 == 2)
		{
		
		problem = firNum + "-" + secNum + "-" + tirNum + "=?";
		answer = firNum - secNum - tirNum;
		}
		
		else if(operaNum1 == 2 && operaNum2 == 3)
		{
		
		problem = firNum + "-" + secNum + "*" + tirNum + "=?";
		answer = firNum - secNum * tirNum;
		}
		
		else if(operaNum1 == 2 && operaNum2 == 4)
		{
		
		problem = firNum + "-" + secNum + "/" + tirNum + "=?";
		answer = firNum - secNum / tirNum;
		}

		else if(operaNum1 == 3 && operaNum2 == 1)
		{
		
		problem = firNum + "*" + secNum + "+" + tirNum + "=?";
		answer = firNum * secNum + tirNum;
		}
		
		else if(operaNum1 == 3 && operaNum2 == 2)
		{
		
		problem = firNum + "*" + secNum + "-" + tirNum + "=?";
		answer = firNum * secNum - tirNum;
		}
		
		else if(operaNum1 == 3 && operaNum2 == 3)
		{
		
		problem = firNum + "*" + secNum + "*" + tirNum + "=?";
		answer = firNum * secNum * tirNum;
		}
		
		else if(operaNum1 == 3 && operaNum2 == 4)
		{
		
		problem = firNum + "*" + secNum + "/" + tirNum + "=?";
		answer = firNum * secNum / tirNum;
		}

		if(operaNum1 == 4 && operaNum2 == 1)
		{
		
		problem = firNum + "/" + secNum + "+" + tirNum + "=?";
		answer = firNum / secNum + tirNum;
		}
		
		if(operaNum1 == 4 && operaNum2 == 2)
		{
		
		problem = firNum + "/" + secNum + "-" + tirNum + "=?";
		answer = firNum / secNum - tirNum;
		}
		
		if(operaNum1 == 4 && operaNum2 == 3)
		{
		
		problem = firNum + "/" + secNum + "*" + tirNum + "=?";
		answer = firNum / secNum * tirNum;
		}
		
		if(operaNum1 == 4 && operaNum2 == 4)
		{
		
		problem = firNum + "/" + secNum + "/" + tirNum + "=?";
		answer = firNum / secNum / tirNum;
		}
		Tiku tiku = new Tiku(problem,answer);
		list.add(tiku);
        new TikuServiceImp().AddTiku(tiku);	

    }
		return list;
	}
	
	@Override
	public int AddTiku(Tiku t) {
		int i=0;
        Connection conn=null;
        try {
            conn=DBHelper.getConnection();
            i=td.insertTiku(conn, t);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            td.closeALL();
        }
        return i;
	}




	

}
