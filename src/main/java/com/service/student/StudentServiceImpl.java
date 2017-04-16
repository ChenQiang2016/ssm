package com.service.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.StudentMapper;
import com.model.Student;
import com.model.StudentExample;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;

	@Override
	@Transactional
	public int insert(Student student) {
		return studentMapper.insert(student);
	}

	@Override
	public List<Student> selectByExample(StudentExample example) {
		return studentMapper.selectByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(int studentId) {
		Student student = new Student();
		student.setStudentId(studentId);
		student.setState("0");
		return studentMapper.updateByPrimaryKeySelective(student);
	}
}