package com.size.test;

import com.size.entity.Tiku;
import com.size.service.TikuServiceImp;

public class MathTest {


	public static void main(String[] args) {
		
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
		System.out.println(firNum + "+" + secNum + "+" + tirNum + "=?");

		problem = firNum + "+" + secNum + "+" + tirNum + "=?";
		answer = firNum + secNum + tirNum;
						
		}

		else if(operaNum1 == 1 && operaNum2 == 2)
		{
		System.out.println(firNum + "+" + secNum + "-" + tirNum + "=?");
		
		problem = firNum + "+" + secNum + "-" + tirNum + "=?";
		answer = firNum + secNum - tirNum;
			
		}
		
		else if(operaNum1 == 1 && operaNum2 == 3)
		{
		System.out.println(firNum + "+" + secNum + "*" + tirNum + "=?");
		
		problem = firNum + "+" + secNum + "*" + tirNum + "=?";
		answer = firNum + secNum * tirNum;
			
		}
		
		else if(operaNum1 == 1 && operaNum2 == 4)
		{
		System.out.println(firNum + "+" + secNum + "/" + tirNum + "=?");
		
		problem = firNum + "+" + secNum + "/" + tirNum + "=?";
		answer = firNum + secNum / tirNum;
		}
		
		else if(operaNum1 == 2 && operaNum2 == 1)
		{
		System.out.println(firNum + "-" + secNum + "+" + tirNum + "=?");
		
		problem = firNum + "-" + secNum + "+" + tirNum + "=?";
		answer = firNum - secNum + tirNum;
		}
		
		else if(operaNum1 == 2 && operaNum2 == 2)
		{
		System.out.println(firNum + "-" + secNum + "-" + tirNum + "=?");
		
		problem = firNum + "-" + secNum + "-" + tirNum + "=?";
		answer = firNum - secNum - tirNum;
		}
		
		else if(operaNum1 == 2 && operaNum2 == 3)
		{
		System.out.println(firNum + "-" + secNum + "*" + tirNum + "=?");
		
		problem = firNum + "-" + secNum + "*" + tirNum + "=?";
		answer = firNum - secNum * tirNum;
		}
		
		else if(operaNum1 == 2 && operaNum2 == 4)
		{
		System.out.println(firNum + "-" + secNum + "/" + tirNum + "=?");
		
		problem = firNum + "-" + secNum + "/" + tirNum + "=?";
		answer = firNum - secNum / tirNum;
		}

		else if(operaNum1 == 3 && operaNum2 == 1)
		{
		System.out.println(firNum + "*" + secNum + "+" + tirNum + "=?");
		
		problem = firNum + "*" + secNum + "+" + tirNum + "=?";
		answer = firNum * secNum + tirNum;
		}
		
		else if(operaNum1 == 3 && operaNum2 == 2)
		{
		System.out.println(firNum + "*" + secNum + "-" + tirNum + "=?");
		
		problem = firNum + "*" + secNum + "-" + tirNum + "=?";
		answer = firNum * secNum - tirNum;
		}
		
		else if(operaNum1 == 3 && operaNum2 == 3)
		{
		System.out.println(firNum + "*" + secNum + "*" + tirNum + "=?");
		
		problem = firNum + "*" + secNum + "*" + tirNum + "=?";
		answer = firNum * secNum * tirNum;
		}
		
		else if(operaNum1 == 3 && operaNum2 == 4)
		{
		System.out.println(firNum + "*" + secNum + "/" + tirNum + "=?");
		
		problem = firNum + "*" + secNum + "/" + tirNum + "=?";
		answer = firNum * secNum / tirNum;
		}

		if(operaNum1 == 4 && operaNum2 == 1)
		{
		System.out.println(firNum + "/" + secNum + "+" + tirNum + "=?");
		
		problem = firNum + "/" + secNum + "+" + tirNum + "=?";
		answer = firNum / secNum + tirNum;
		}
		
		if(operaNum1 == 4 && operaNum2 == 2)
		{
		System.out.println(firNum + "/" + secNum + "-" + tirNum + "=?");
		
		problem = firNum + "/" + secNum + "-" + tirNum + "=?";
		answer = firNum / secNum - tirNum;
		}
		
		if(operaNum1 == 4 && operaNum2 == 3)
		{
		System.out.println(firNum + "/" + secNum + "*" + tirNum + "=?");
		
		problem = firNum + "/" + secNum + "*" + tirNum + "=?";
		answer = firNum / secNum * tirNum;
		}
		
		if(operaNum1 == 4 && operaNum2 == 4)
		{
		System.out.println(firNum + "/" + secNum + "/" + tirNum + "=?");
		
		problem = firNum + "/" + secNum + "/" + tirNum + "=?";
		answer = firNum / secNum / tirNum;
		}
		
		Tiku tiku = new Tiku(problem,answer);
        new TikuServiceImp().AddTiku(tiku);	

    }

  }
		
}
