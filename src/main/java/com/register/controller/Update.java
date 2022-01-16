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

@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		
		StudentDaoImpl dao = new StudentDaoImpl();
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setCity(city);
		int result = dao.updateStudent(student);
		
		if(result>0) {
			out.print("<h1>Student Updated Successfully</h1><br/>");
			out.println("<h3><a href='AllStudents'>See All Students</a></h3>");
		}
		else {
			out.print("<h1>Unable To Update The Student</h1>");
		}
	}

}
