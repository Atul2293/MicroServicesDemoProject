package com.course.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.intercomm.CourseClient;
import com.course.model.Course;
import com.course.model.Student;
import com.course.repository.CourseService;

@RestController
@RequestMapping("/api")
public class Api {

	@Autowired
	CourseService service;
	
	
	@Autowired
	private CourseClient client;
	
	//get all courses 
		@GetMapping("/courses")
		public List<Course> getAllCourse() 
		{
			return service.getAllCouses();	
		}
	
		//get single course by its course id
		@GetMapping("/courses/{id}")
		public Course getCourse(@PathVariable Long id) 
		{
			return service.getCourseById(id);
		}
		/*
		// Get a Single course by it id
				@GetMapping("courses/student/{course_id}")
				public ResponseEntity<Course> getCourseById(@PathVariable Long course_id) 
				{
					
					Course course =service.getCourseById(course_id);
					
					if (course == null) {
						return	ResponseEntity.notFound().build();
					}
					return ResponseEntity.ok(course);
				}*/
		
		
		
		
		// get all courses by a student id
		@GetMapping("/courses/student/{stud_id}")
		public List<Course> getAllCourse(@PathVariable Long stud_id) {
			
			return service.getAllCousesOfStudent(stud_id);
			
		}
		
		
		// Create a new course with student id mapping
		@PostMapping("/courses/student/{stud_id}")
		public ResponseEntity<Course> createCourse(@PathVariable Long stud_id,@RequestBody Course courses) {
			
			if(client.getStudById(stud_id) != null)
			{
			courses.setSid(stud_id);
			service.createCourse(courses);
			return ResponseEntity.ok(courses);
			
			}
			return ResponseEntity.notFound().build();
			
		}
		
		
		
		
		
		/*
		
		// Update course with its student id mapping


		@PutMapping("/students/{stud_id}/courses/{course_id}")
		public ResponseEntity<Course> updateCourse(@PathVariable Long course_id,@PathVariable Long stud_id,@RequestBody CourseModel courses) {
			
			courses.setStudent(new Student(stud_id,"",""));
			courses.setCid(course_id);
			Course updatedStudent=service.updateCourse(courses);
			if (updatedStudent == null) {
				return ResponseEntity.notFound().build();
			}
			
			return ResponseEntity.ok(updatedStudent);
			
		
		}
		
		//Delete course by its id
		@DeleteMapping("/students/{stud_id}/courses/{course_id}")
		public ResponseEntity<Student> deleteCourse(@PathVariable Long course_id) 
		{
			
			Integer deleteFlag=service.deleteCourse(course_id);
		    if(deleteFlag == 0) {
		        return ResponseEntity.notFound().build();
		    }
		    return ResponseEntity.ok().build();
		}
		*/
		
		
}
