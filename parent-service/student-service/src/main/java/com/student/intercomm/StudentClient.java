package com.student.intercomm;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import  com.student.model.Course;;

@FeignClient("course-service")
public interface StudentClient {

	//this will get all courses of student by student id..
    @RequestMapping(method = RequestMethod.GET, value = "/api/courses/student/{stud_id}")
    List<Course> getAllCourse(@PathVariable("stud_id") Long sid);
	
	
}
