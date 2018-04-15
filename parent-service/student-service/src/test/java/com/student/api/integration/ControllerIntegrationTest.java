package com.student.api.integration;

import static org.hamcrest.CoreMatchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.student.api.Api2;
import com.student.intercomm.StudentClient;
import com.student.repository.StudentRepo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,classes = Api2.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.yml")
public class ControllerIntegrationTest {

	@Autowired
    private MockMvc mockMvc;
 
    @Autowired
    private StudentRepo studentRepo ;
    
    @Autowired
	StudentClient studentClient;
    
    @Test
    public void test_get_all_students() throws Exception {
	
	 
		
		mockMvc.perform(get("/api/students"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
     //  .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].id", is(11)))
        .andExpect(jsonPath("$[0].name", is("Atul M")))
       .andExpect(jsonPath("$[0].standard", is("BE")));

		
	 
 }
	
	
}
