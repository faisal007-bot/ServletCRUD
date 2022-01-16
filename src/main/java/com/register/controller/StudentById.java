package com.register.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.register.dao.StudentDaoImpl;
import com.register.entity.Student;

@WebServlet("/StudentById")
public class StudentById extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		StudentDaoImpl dao = new StudentDaoImpl();
		Student student = dao.getStudent(id);
		
		out.println("<h1>Update The Student</h1>");
		out.println("<form action='Update' method='POST'>");
		out.println("<table>");
		out.println("<tr><td><input type='hidden' name='id' value='"+student.getId()+"'/></td></tr>");
		out.println("<tr><td><label>Enter Name</label><input type='text' name='name' value='"+student.getName()+"'/></td></tr>");
		out.println("<tr><td><label>Enter City</label><input type='text' name='city' value='"+student.getCity()+"'/></td></tr>");
		out.println("</table>");
		out.println("<input type='submit' value='update'/>");
		out.print("</form>");
	}

}
