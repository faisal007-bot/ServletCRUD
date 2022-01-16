package com.register.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.register.connection.ConnectionProvider;
import com.register.entity.Student;

public class StudentDaoImpl implements StudentDao{

	@Override
	public int insertStudent(Student student) {
		
		Connection conn = null;
		final String query = "insert into student (id,name,city) values (?,?,?)";
		int status = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setString(3, student.getCity());
			status = ps.executeUpdate();
			conn.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public int updateStudent(Student student) {
		
		Connection conn = null;
		final String query = "update student set name = ? , city = ? where  id = ?";
		int status = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setString(3, student.getCity());
			status = ps.executeUpdate();
			conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public int deleteStudent(int id) {
		
		Connection conn = null;
		final String query = "delete from student where id = ?";
		int status = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			status = ps.executeUpdate();
			conn.close();
		}
		catch (Exception e) {
			
		}
		
		return status;
	}

	@Override
	public Student getStudent(int id) {
		
		Connection conn = null;
		final String query = "select * from student where id = ?";
		Student student = new Student();
		
		try {
			conn = ConnectionProvider.getConnection();
			PreparedStatement ps = conn.prepareCall(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setCity(rs.getString(3));
			}
			conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return student;
	}

	@Override
	public List<Student> getStudents() {
		
		Connection conn = null;
		final String query = "select * from student";
		List<Student> students = new ArrayList<Student>();
		
		try {
			conn = ConnectionProvider.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setCity(rs.getString(3));
				students.add(student);
			}
			conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return students;
	}
	
}
