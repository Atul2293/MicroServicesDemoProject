package com.course.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.model.Course;


@Service
public class CourseService {

	@Autowired
	CourseRepository repo;
	
	
	public List<Course> getAllCouses() {
		   
		   List<Course> courses=new ArrayList<>();
		   
		   repo.findAll().forEach(courses::add);
		
		   	return courses;
	     }
	
	
	public List<Course> getAllCousesOfStudent(Long student_id) 
	{
		
		List<Course> courses=new ArrayList<>();
		
		repo.findBySid(student_id).forEach(courses::add);
		
		return courses;
		
	}
	
	 public void createCourse(Course course) {
			
		   repo.save(course);
			
		}
	 
	   public Course getCourseById(Long course_id) 
	   {
//		   return repo.findById(course_id).get(); 
		   return repo.findOne(course_id);
	   }


	
	  /* 
	   public Course updateCourse(Course courses) {
			
			return repo.save(courses);
		   }




		public Integer deleteCourse(Long course_id) {
			Course course = repo.findOne(course_id);
		    if(course == null) {
		        return 0;
		    }

		     repo.delete(course);
		    return 1;
		}
		*/
		
	
}
