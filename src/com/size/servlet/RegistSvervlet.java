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


@WebServlet("/regist")
public class RegistSvervlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	AdminServiceImp as;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistSvervlet() {
    	as=new AdminServiceImp();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name = request.getParameter("userName");
		String password = request.getParameter("password");
		System.out.println(name+"  "+password);
		Admin admin = new Admin();
		int i = as.AddAdmin(new Admin(name, password));
		PrintWriter out = response.getWriter();
		if(i==1){
			//登陆成功后，应该把登陆用户名，存进session中
			HttpSession session = request.getSession();
			session.setAttribute("loginName", admin.getAdmin_name());
			
			out.write("<script>alert('恭喜，注册成功！');location.href='login1.html'</script>");
			
		}else{
			out.write("<script>alert('对不起！注册失败！');history.back();</script>");			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
