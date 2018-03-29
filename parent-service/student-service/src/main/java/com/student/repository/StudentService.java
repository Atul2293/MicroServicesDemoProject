package com.student.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.model.Student;


@Service
public class StudentService {

	
	@Autowired
	StudentRepo repo;
	
	
	public List<Student> getAllStudents() 
	{
		
		return repo.findAll();
	}
	
	
	public Student createNewStudent(Student student)
	{
		return repo.save(student);
	}
	
	
	
   public Student getStudById(Long id) {
		
		return repo.findOne(id);
		
	}
   
   
   public Student updateStudent(Student newStud) {
		
		
		Student updatedStud=repo.save(newStud);
		return updatedStud;
		
	}
}
