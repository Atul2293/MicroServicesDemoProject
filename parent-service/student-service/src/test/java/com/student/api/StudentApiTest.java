/*package com.student.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestBody;

import com.student.api.Api2;
import com.student.intercomm.StudentClient;
import com.student.model.Student;
import com.student.repository.StudentService;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(value = Api2.class, secure = false)
public class StudentApiTest {


	
	
	
	@MockBean
	StudentService service;
	

	@MockBean
	StudentClient studentClient;
		
	
	
	
	@Test
	public void getAllStudentsTest() throws Exception {
		
		List<Student> allStudents=new ArrayList<>();
		
	  Student s1=new Student();;
		
		s1.setId(new Long(11));
		s1.setName("Atul M");
		s1.setStandard("BE");
		
		
		allStudents.add(s1);
		
		for(Student l:allStudents)
		{
			System.out.println(l.getId()+" "+l.getName()+" "+l.getStandard());
		}
		
		
	
		MvcResult result = null;

 		
		
			
		when(service.getAllStudents()).thenReturn(allStudents);
		

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/students").accept(MediaType.APPLICATION_JSON);
		
		result = mockMvc.perform(requestBuilder).andReturn();
		
		
		
		
		

		System.out.println(result.getResponse());
		String expected = "{id:11,name:Atul M,standard:BE}";
		
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);

		
		
		
	}
}
*/