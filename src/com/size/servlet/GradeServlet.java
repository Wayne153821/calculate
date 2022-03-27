package com.size.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.size.entity.Grade;
import com.size.service.GradeServiceImp;

/**
 * Servlet implementation class GradeServlet
 */
@WebServlet("/getGrade")
public class GradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Integer score = Integer.parseInt(request.getParameter("score"));
		Calendar now = Calendar.getInstance();
		String time=now .get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH)+1)+"-"+now.get(Calendar.DAY_OF_MONTH);
		Grade grade = new Grade(score,time);
		GradeServiceImp gs = new GradeServiceImp();
		gs.AddGrade(grade);
		PrintWriter out = response.getWriter();
		out.write("<script>alert('恭喜,添加成绩成功！');location.href='login1.html'</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
