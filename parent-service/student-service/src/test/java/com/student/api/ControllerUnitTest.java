package com.student.api;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.api.Api2;
import com.student.intercomm.StudentClient;
import com.student.model.Student;
import com.student.repository.StudentService;


//@RunWith(SpringRunner.class)
//@WebMvcTest(Api2.class)
public class ControllerUnitTest {
	
	@Autowired
	private MockMvc mockMvc;
	 
	@Mock
    private StudentService StudentServiceMock;
	
	@InjectMocks
	private Api2 controllerClass;
	
	
	 public List<Student> allStudents=null;
	 public Student s1=null;
	 
	 @Before
	    public void init(){
	        MockitoAnnotations.initMocks(this);
	        mockMvc = MockMvcBuilders
	                .standaloneSetup(controllerClass)
	                .build();
	        
	        allStudents=new ArrayList<Student>();
	        s1=new Student();
	        
	        s1.setId(new Long(11));
			s1.setName("Atul M");
			s1.setStandard("BE");
			allStudents.add(s1);
	        
	    }
	
	 
    
	 
	 @Test
	    public void test_get_all_students() throws Exception {
		
		
			 when(StudentServiceMock.getAllStudents()).thenReturn(allStudents);
			
			mockMvc.perform(get("/api/students"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
           // .andExpect(jsonPath("$", hasSize(1)));
            .andExpect(jsonPath("$[0].id", is(11)))
            .andExpect(jsonPath("$[0].name", is("Atul M")))
           .andExpect(jsonPath("$[0].standard", is("BE")));
			
    verify(StudentServiceMock, times(1)).getAllStudents();
    verifyNoMoreInteractions(StudentServiceMock);
			
		 
	 }
	
	
}
