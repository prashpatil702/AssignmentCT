package com.example.EmployeeMgmt;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;

import com.example.service.EmployeeService;

@RestController
@RequestMapping(value="/EmployeeMgmt")
public class EmployeeController {

@Autowired
EmployeeService empService;
	

	@RequestMapping(value="/addEmp", method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> addEmp(@RequestBody Employee emp1)
	{
		Boolean b = empService.addEmp(emp1);
		if (b==true)
		{
			return new ResponseEntity<Employee>(emp1, HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<Employee>(HttpStatus.METHOD_FAILURE);
		}
		
	}
	
	@RequestMapping(value="/deleteEmp/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEmp(@PathVariable("id") int id)
	{
		Boolean b = empService.deleteEmp(id);
		System.out.println("After deleting "+b);
		if (b==true)
		{
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(value="/updateEmp",method=RequestMethod.PUT)
	public ResponseEntity<Void> updateEmp(@RequestBody Employee emp1)
	{
		Boolean b = empService.updateEmp(emp1);
		if (b==true)
		{
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(value="/getEmpForDept/{dept}",method=RequestMethod.GET)
	public ResponseEntity<List<Employee>> getEmpForDept(@PathVariable("dept") String dept)
	{
		boolean flag = false;
		List<Employee> lstEmp = new ArrayList<>();
		//Populate emp
		for(int i=0;i<10;i++)
		{
			Employee em = new Employee();
			if(flag)
			{
				em.setId(i+1);
				em.setEmpName("emp"+i);
				em.setDeptName("xyz");
				flag = false;
			}
			else
			{
				em.setId(i+1);
				em.setEmpName("emp"+i);
				em.setDeptName("pqr");
				flag = true;
			}
			lstEmp.add(em);
		}
		
		System.out.println(lstEmp.toString());
		
		//Sort based on dept
		List<Employee> filteredList  = lstEmp.stream().filter(x->x.getDeptName().equals(dept)).collect(Collectors.toList());
		return new ResponseEntity<List<Employee>>(filteredList,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/message",method=RequestMethod.GET)
	public String message()
	{
		return "Hi Prashant";
		
	}
	
	

}
