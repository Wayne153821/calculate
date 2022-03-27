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
		System.out.println("��ӭ��ʹ�ñ�ϵͳ");
		while(f) {
			System.out.println("��ѡ����� 1����¼ 2���˳� 3:ע��");
			String op = input();
			if("1".equals(op)) {
				System.out.println("�������û���");
				String name = input();
				System.out.println("����������");
				String password = input();
				
				Admin admin=as.findAdminByLogin(new Admin(name,password));
				if(admin!=null) {
					System.out.println("--- ��¼�ɹ� ---");
					System.out.println("��ѡ����� 1���鿴�ɼ� 2����ӳɼ� 3����ʼ���� 4�������Ŀ 5:�鿴����ĳɼ� 6:�����γɼ�");
					String op1 = input();
					
					if("1".equals(op1)) {
						List<Grade> list = gs.findAllGrades();
						for(Grade grade : list) {
							System.out.println(grade);
						}
					}
					
					if("2".equals(op1)) {
						scanner = new Scanner(System.in);
						System.out.println("��������Ҫ�����ĳɼ�������");
						int score=scanner.nextInt();
						Calendar now = Calendar.getInstance();
						String time=now .get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH)+1)+"-"+now.get(Calendar.DAY_OF_MONTH);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						try {
							Date date = sdf.parse(time);
							System.out.println(date);
						} catch (ParseException e) {
							// TODO �Զ����ɵ� catch ��
							e.printStackTrace();}
						Grade grade = new Grade(score,time);
						int i = new GradeServiceImp().AddGrade(grade);
						if(i==1) System.out.println("�����ɼ��ɹ���");
						else System.out.println("�Բ��������ɼ�ʧ�ܣ�");
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
				System.out.println("�������˺ţ�");
				String admin_name=scanner.nextLine();
				System.out.println("���������룺");
				String admin_password=scanner.nextLine();
				Admin admin = new Admin(admin_name,admin_password);
				int i = new AdminServiceImp().AddAdmin(admin);
				if(i==1) System.out.println("ע��ɹ���");
				else System.out.println("�Բ���ע��ʧ�ܣ�");
			}
			else {
				System.out.println("-- ����ȷ����ѡ�� --");
			}					
					
		}
		System.out.println("---end---");
		
	}
	
	
	
	
	
}
