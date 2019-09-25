package com.example.service;

import com.example.model.Employee;

import com.example.model.Response1;

public interface EmployeeService {

	Boolean addEmp(Employee emp);

	Boolean deleteEmp(Integer id);

	Boolean updateEmp(Employee emp1);

}
