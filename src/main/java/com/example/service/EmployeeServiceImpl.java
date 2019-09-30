package com.example.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.example.model.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
private static HashMap<Integer,String> empHM = new HashMap<>();

	@Override
	public Boolean addEmp(Employee emp) {
		// TODO Auto-generated method stub
		System.out.println("Employee will get added here");
		System.out.println(emp.toString());
		empHM.put(emp.getId(),emp.getEmpName());
		return true;	
	}

	@Override
	public Boolean deleteEmp(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("Employee before delete");
		empHM.remove(id);
		System.out.println("Employee deleted successfully");
		
		return true;
		
	}

	@Override
	public Boolean updateEmp(Employee emp) {
		// TODO Auto-generated method stub
		System.out.println("inside update emp");
		
		empHM.put(emp.getId(),emp.getEmpName());
		
		return true;
	}
	

}
