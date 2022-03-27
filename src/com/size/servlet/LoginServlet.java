package com.size.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.size.entity.Admin;
import com.size.service.AdminServiceImp;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	AdminServiceImp as;
	
    public LoginServlet() {
        as=new AdminServiceImp();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name = request.getParameter("userName");
		String password = request.getParameter("password");
		System.out.println(name+"  "+password);
		
		Admin admin = as.findAdminByLogin(new Admin(name, password));
		PrintWriter out = response.getWriter();
		if(admin!=null) {
			//登陆成功后，应该把登陆用户名，存进session中
			HttpSession session = request.getSession();
			session.setAttribute("loginName", admin.getAdmin_name());
			
			out.write("<script>alert('恭喜，登录成功！');location.href='index1.html'</script>");
			
		}else {
			out.write("<script>alert('对不起！用户名或密码错误!');history.back();</script>");			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
