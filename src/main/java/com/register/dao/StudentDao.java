package com.register.dao;

import java.util.List;

import com.register.entity.Student;

public interface StudentDao {
	
	int insertStudent(Student student);
	int updateStudent(Student student);
	int deleteStudent(int id);
	Student getStudent(int id);
	List<Student> getStudents();
}
