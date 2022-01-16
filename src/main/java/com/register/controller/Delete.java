package com.register.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.register.dao.StudentDaoImpl;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		StudentDaoImpl dao = new StudentDaoImpl();
		int result = dao.deleteStudent(id);
		
		if(result>0) {
			out.print("<h1>Student Deleted SuccessFully</h1>");
			out.print("<h3><a href='AllStudents'>See All Employees</a></h3><br/><br/><br/><br/>");
			out.print("<h3><a href='index.jsp'>Register Here!</a></h3><br/>");
		}
		else {
			out.print("<h1>Sorry Unable To Delete The Student?</h1>");
			response.sendRedirect("index.jsp");
		}
	}

}
