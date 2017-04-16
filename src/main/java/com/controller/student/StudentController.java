package com.controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.framework.util.DateUtil;
import com.model.Student;
import com.model.StudentExample;
import com.service.student.StudentService;

@Controller
@RequestMapping("student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping("index")
	public ModelAndView index(String desc){
		System.out.println(desc);
		return new ModelAndView("index");
	}
	
	@RequestMapping("save")
	@ResponseBody
	public Object saveStudent(Student student){
		student.setState("1");
		student.setCtime(DateUtil.getCurrentTime());
		return studentService.insert(student);
	}
	
	@RequestMapping("list")
	@ResponseBody
	public Object list(){
		StudentExample example = new StudentExample();
		example.createCriteria().andStateEqualTo("1");
		return studentService.selectByExample(example);
	}
	
	@RequestMapping("delete/{studentId}")
	@ResponseBody
	public Object delete(@PathVariable("studentId") int studentId){
		
		return studentService.deleteByPrimaryKey(studentId);
	}
}