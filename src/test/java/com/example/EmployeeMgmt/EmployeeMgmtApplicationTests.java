package com.example.EmployeeMgmt;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.model.Employee;

import com.example.model.Response1;
import com.example.service.EmployeeService;
import com.example.service.EmployeeServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeMgmtApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EmployeeService employeeService;
	
	
	private WebApplicationContext context;
	
	ObjectMapper obj = new ObjectMapper();
	
	
	@Test
	public void addEmployeeTest1() throws Exception  {
		
		Mockito.when(
				employeeService.addEmp(Mockito.any(Employee.class))).thenReturn(true);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/EmployeeMgmt/addEmp")
				.accept(MediaType.APPLICATION_JSON).content("{\n" + 
						"	\"id\": 1,\n" + 
						"	\"empName\":\"prashant\"\n" + 
						"}")
				.contentType(MediaType.APPLICATION_JSON); 
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();
		
		System.out.println("xxx "+response.getContentAsString());
		Assert.assertEquals("{\"msg\":\"Emp Added\",\"flag\":true}",response.getContentAsString());
		
		//Assert.assertEquals("String","String");
	}
	
	@Test
	public void deleteEmpTest() throws Exception {
		
		Mockito.when(employeeService.deleteEmp(Mockito.anyInt())).thenReturn(true);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/EmployeeMgmt/deleteEmp/{id}","2");
				//.accept(MediaType.APPLICATION_JSON) //.contentType(MediaType.APPLICATION_JSON_VALUE)
				//;
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		System.out.println("Employee deleted successfully "+response.getContentAsString());
		Assert.assertEquals("{\"msg\": \"Emp deleted\",\"flag\": true}",response.getContentAsString());
	}
	
	
	@Test
	public void updateEmp() throws Exception {
		
		Mockito.when(employeeService.updateEmp(Mockito.any(Employee.class))).thenReturn(true);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/EmployeeMgmt/updateEmp/")
				.accept(MediaType.APPLICATION_JSON).content("{\n" + 
						"	\"id\": 100,\n" + 
						"	\"empName\":\"prashant\"\n" + 
						"}")
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		System.out.println("Employee updated successfully100 "+response.getContentAsString());
		Assert.assertEquals("{\"msg\":\"Emp updated\",\"flag\":true}",response.getContentAsString());
	}
	

}
