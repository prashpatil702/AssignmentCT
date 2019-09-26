package com.example.service;

import com.example.model.Employee;


public interface EmployeeService {

	Boolean addEmp(Employee emp);

	Boolean deleteEmp(Integer id);

	Boolean updateEmp(Employee emp1);

}
