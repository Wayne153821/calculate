package com.size.test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.size.entity.Admin;
import com.size.entity.Grade;
import com.size.entity.Tiku;
import com.size.service.AdminServiceImp;
import com.size.service.GradeServiceImp;
import com.size.service.TikuServiceImp;



public class Process {
	AdminServiceImp as;
	GradeServiceImp gs;
	TikuServiceImp ts;
	private Scanner scanner;
	
	public Process() {
		as =new AdminServiceImp();
		gs = new GradeServiceImp();
		ts = new TikuServiceImp();
		
	}
	
	public String input() {
		byte[] buf = new byte[50];
		try {
			System.in.read(buf);
		} catch (IOException e) { 
			e.printStackTrace();
		}
		return new String(buf).trim();
	}	
	
	public void process()  {
		boolean f=true;
		System.out.println("欢迎你使用本系统");
		while(f) {
			System.out.println("请选择操作 1：登录 2：退出 3:注册");
			String op = input();
			if("1".equals(op)) {
				System.out.println("请输入用户名");
				String name = input();
				System.out.println("请输入密码");
				String password = input();
				
				Admin admin=as.findAdminByLogin(new Admin(name,password));
				if(admin!=null) {
					System.out.println("--- 登录成功 ---");
					System.out.println("请选择操作 1：查看成绩 2：添加成绩 3：开始答题 4：添加题目 5:查看今天的成绩 6:最近五次成绩");
					String op1 = input();
					
					if("1".equals(op1)) {
						List<Grade> list = gs.findAllGrades();
						for(Grade grade : list) {
							System.out.println(grade);
						}
					}
					
					if("2".equals(op1)) {
						scanner = new Scanner(System.in);
						System.out.println("请输入你要新增的成绩分数：");
						int score=scanner.nextInt();
						Calendar now = Calendar.getInstance();
						String time=now .get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH)+1)+"-"+now.get(Calendar.DAY_OF_MONTH);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						try {
							Date date = sdf.parse(time);
							System.out.println(date);
						} catch (ParseException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();}
						Grade grade = new Grade(score,time);
						int i = new GradeServiceImp().AddGrade(grade);
						if(i==1) System.out.println("新增成绩成功！");
						else System.out.println("对不起！新增成绩失败！");
					}
					
					if("3".equals(op1)) {
						scanner = new Scanner(System.in);
						int score = 0;
						List<Tiku> list = ts.CreatePro();
						for(Tiku tiku : list) {
							System.out.println(tiku);
							int answer = scanner.nextInt();
							if(answer == tiku.getAnswer()) {
								score += 5;
							}
							System.out.println(score);
						}
						
						Calendar now = Calendar.getInstance();
						String time=now .get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH)+1)+"-"+now.get(Calendar.DAY_OF_MONTH);
						Grade grade = new Grade(score,time);
						new GradeServiceImp().AddGrade(grade);
						
					}
					
					if("4".equals(op1)) {
						ts.CreatePro();
					}
					
					if("5".equals(op1)) {
						Calendar now = Calendar.getInstance();
						String now_time=now .get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH)+1)+"-"+now.get(Calendar.DAY_OF_MONTH);
						List<Grade> list = gs.findTodayGrades(now_time);
						for(Grade grade : list) {
							System.out.println(grade);
						}
					}

					if("6".equals(op1)) {
						List<Grade> list = gs.findFive();
						for(Grade grade : list) {
							System.out.println(grade);
						}
					}
					
				}
			}else if("2".equals(op)) {
				break;
			}else if("3".equals(op)) {
				scanner = new Scanner(System.in);
				System.out.println("请输入账号：");
				String admin_name=scanner.nextLine();
				System.out.println("请输入密码：");
				String admin_password=scanner.nextLine();
				Admin admin = new Admin(admin_name,admin_password);
				int i = new AdminServiceImp().AddAdmin(admin);
				if(i==1) System.out.println("注册成功！");
				else System.out.println("对不起！注册失败！");
			}
			else {
				System.out.println("-- 请正确输入选项 --");
			}					
					
		}
		System.out.println("---end---");
		
	}
	
	
	
	
	
}
