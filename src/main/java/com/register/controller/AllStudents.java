package com.register.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.register.dao.StudentDaoImpl;
import com.register.entity.Student;

@WebServlet("/AllStudents")
public class AllStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<h3><a href='index.jsp'>Register Here!</a></h3>");
		out.println("<h2>List Of All The Employees</h2>");
		
		StudentDaoImpl dao = new StudentDaoImpl();
		List<Student> students = new ArrayList<Student>();
		students = dao.getStudents();
		
		for(Student s:students) {
			out.println("<table border=1px solid black width='50%'>");
			out.println("<tr><td>ID</td><td>Name</td><td>City</td></tr>");
			out.println("<tr><td>"+s.getId()+"</td><td>"+s.getName()+"</td><td>"+s.getCity()+"</td></tr>");
			out.print("</table>");
			out.println("<h3><a href='Delete?id="+s.getId()+"'>Delete Student</a></h3>");
			out.println("<h3><a href='StudentById?id="+s.getId()+"'>Update Student</a></h3>");
			out.print("<hr/>");
		}
		
		out.close();
	}

}
