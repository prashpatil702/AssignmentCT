package com.example.EmployeeMgmt;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;

import com.example.model.Response1;
import com.example.service.EmployeeService;

@RestController
@RequestMapping(value="/EmployeeMgmt")
public class EmployeeController {

@Autowired
EmployeeService empService;
	

	@RequestMapping(value="/addEmp", method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public Response1 addEmp(@RequestBody Employee emp1)
	{
		Response1 response;
		/*System.out.println("Inside add emp controller");
		Employee emp = new Employee();
		
		emp.setEmpName("Prashant");
		emp.setId(1);
		System.out.println("Before adding");*/
		Boolean b = empService.addEmp(emp1);
		if (b==true)
		{
			response = new Response1("Emp Added",true);
		}
		else
		{
			response = new Response1("Emp not Added",false);
		}
		return response;
	}
	
	@RequestMapping(value="/deleteEmp",method=RequestMethod.DELETE)
	public Response1 deleteEmp(@RequestParam("id") Integer id)
	{
		Response1 response;
		System.out.println("Employee to be deleted "+id);
		Boolean b = empService.deleteEmp(id);
		if (b==true)
		{
			response = new Response1("Emp deleted",true);
		}
		else
		{
			response = new Response1("Emp not deleted",false);
		}
		return response;
	}
	
	@RequestMapping(value="/updateEmp",method=RequestMethod.PUT)
	public Response1 updateEmp(@RequestBody Employee emp1)
	{
		Response1 response;
		System.out.println("Employee to be updated "+emp1.toString());
		Boolean b = empService.updateEmp(emp1);
		if (b==true)
		{
			response = new Response1("Emp updated",true);
		}
		else
		{
			response = new Response1("Emp not updated",false);
		}
		return response;
	}
	
	

}
