package com.register.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.register.dao.StudentDaoImpl;
import com.register.entity.Student;

@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		
		StudentDaoImpl dao = new StudentDaoImpl();
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setCity(city);
		int result = dao.insertStudent(student);
		
		if(result>0) {
			out.print("<h1>Student Registered Successfully</h1>");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
		else {
			out.print("<h1>Student Registeration Is Failed</h1>");
			response.sendRedirect("index.jsp");
		}
	}

}
