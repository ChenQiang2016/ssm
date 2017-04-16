package com.service.student;

import java.util.List;

import com.model.Student;
import com.model.StudentExample;

public interface StudentService {

	int insert(Student student);
	
	List<Student> selectByExample(StudentExample example);
	
	int deleteByPrimaryKey(int studentId);
}