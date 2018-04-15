package com.student.api;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.api.Api2;
import com.student.intercomm.StudentClient;
import com.student.model.Student;
import com.student.repository.StudentService;


@RunWith(SpringRunner.class)
@WebMvcTest(Api2.class)  
/** @WebMvcTest. It will auto-configure the Spring MVC infrastructure for our unit tests.
 * also auto-configures MockMvc which offers a powerful way of easy testing MVC controllers
 *  without starting a full HTTP server.
  **/
public class ControllerUnitTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentService StudentServiceMock;
	/** @MockBean to provide mock implementations for required dependencies. **/

	@MockBean
	private StudentClient studentClient;

	public List<Student> allStudents = null;
	public Student s1 = null;
	 
	@Before
	public void init() {
		s1 = new Student();
		s1.setId(new Long(11));
		s1.setName("Atul M");
		s1.setStandard("BE");

		allStudents = Arrays.asList(s1);
	}
	
	 
    
	// GET-->/api/students
	@Test
	public void test_get_all_students() throws Exception {

		when(StudentServiceMock.getAllStudents()).thenReturn(allStudents);

		mockMvc.perform(get("/api/students")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				// .andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].id", is(11))).andExpect(jsonPath("$[0].name", is("Atul M")))
				.andExpect(jsonPath("$[0].standard", is("BE")));

		verify(StudentServiceMock, times(1)).getAllStudents();
		verifyNoMoreInteractions(StudentServiceMock);

	}
	
	 
	// Create a new student(/api/students)
	@Test
	public void test_createStud() throws Exception {

		when(StudentServiceMock.createNewStudent(Mockito.any(Student.class))).thenReturn(s1);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/students").accept(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(s1).getBytes()).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(200, response.getStatus());
		verify(StudentServiceMock, times(1)).createNewStudent(Mockito.any(Student.class));

	}
	 
	@Test
	public void test_getStudentById() throws Exception {

		when(StudentServiceMock.getStudById(Mockito.anyLong())).thenReturn(s1);

		MvcResult result = mockMvc.perform(get("/api/students/11")).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(200, response.getStatus());

		verify(StudentServiceMock, times(1)).getStudById(Mockito.anyLong());
		verifyNoMoreInteractions(StudentServiceMock);

	}
	 
	
}
