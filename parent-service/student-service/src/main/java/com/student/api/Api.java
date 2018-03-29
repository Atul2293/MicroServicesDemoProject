package com.student.api;

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

import com.student.intercomm.StudentClient;
import com.student.model.Course;
import com.student.model.Student;
import com.student.model.StudentCopy;
import com.student.repository.StudentService;


@RestController
@RequestMapping("/api")
public class Api {

	@Autowired
	StudentService service;
	
	@Autowired
	StudentClient studentClient;

	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return service.getAllStudents();
	}

	// Create a new student(/api/students)
	@PostMapping("/students")
	public Student createStud(@RequestBody Student student) {
		return service.createNewStudent(student);
	}

	// Get a Single Student by its ID
	@GetMapping("/students/{id}")
	public Student getStudById(@PathVariable Long id) {

		Student student = service.getStudById(id);

		if (student == null) {
			return null;
		}
		return student;
	}
	
	
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestBody Student newStud) {
		
		newStud.setId(id);
		Student newStudent=service.updateStudent(newStud);
		if (newStudent == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(newStudent);
		
	
	}
	
	//Get one student and their respective courses
	@GetMapping("/students/{sid}/course")
	public ResponseEntity<StudentCopy> getStudentWithTheirCourses(@PathVariable Long sid)
	{
		List<Course> courses=studentClient.getAllCourse(sid);
		
		Student studentOrignal=service.getStudById(sid);
		
		StudentCopy student=new StudentCopy();
		
		student.setId(studentOrignal.getId());
		student.setName(studentOrignal.getName());
		student.setStandard(studentOrignal.getStandard());
		student.setCourses(courses);
		
	
		return ResponseEntity.ok(student);
	}
	
	
	
	
	//Delete Student 
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
		
		Integer deleteFlag=service.deleteStudent(id);
	    if(deleteFlag == 0) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().build();
	}
	
}
