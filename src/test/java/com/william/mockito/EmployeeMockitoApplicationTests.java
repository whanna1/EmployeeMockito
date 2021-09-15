package com.william.mockito;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.william.mockito.model.Employee;
import com.william.mockito.model.Response;

import ch.qos.logback.core.status.Status;
import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeMockitoApplicationTests {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	private ObjectMapper om = new ObjectMapper();
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void addEmployeeTest() throws Exception {
		
		Employee employee = new Employee();
		employee.setName("Billy");
		employee.setDept("IT");
		
		String jsonRequest = om.writeValueAsString(employee);
		System.out.println("OK1");
		MvcResult result = mockMvc.perform(post("/EmployeeService/addEmployee").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE)).
									andExpect(status().isOk()).andReturn();
		System.out.println("OK2");
		String resultContent = result.getResponse().getContentAsString();
		Response response    = om.readValue(resultContent, Response.class);
		
		Assert.assertTrue(response.getStatus() == Boolean.TRUE);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void getEmployeesTest() throws Exception {
		
		//MvcResult result     = mockMvc.perform(get("/EmployeeService/getEmployees").content(MediaType.APPLICATION_JSON_VALUE)).
		MvcResult result     = mockMvc.perform(get("/EmployeeService/getEmployees")).
									     andExpect(status().isOk()).andReturn();
		MockHttpServletResponse mockHttpServletResponse = result.getResponse();
		String resultContent = mockHttpServletResponse.getContentAsString();
		//String resultContent = result.getResponse().getContentAsString();		//getResponse() gets a MockHttpServletResponse not a Response
		Response response    = om.readValue(resultContent, Response.class);
		
		Assert.assertTrue(response.getStatus() == Boolean.TRUE);
	}
		
	
	
}
