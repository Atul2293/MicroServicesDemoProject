package com.course.intercomm;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.course.model.Student;

@FeignClient("student-service")
public interface CourseClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/students/{id}")
    Student getStudById(@PathVariable("id") Long id);
	
    
}
