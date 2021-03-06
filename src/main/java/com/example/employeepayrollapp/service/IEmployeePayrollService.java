package com.example.employeepayrollapp.service;

import java.util.List;

import com.example.employeepayrollapp.dto.EmployeePayrollDTO;
import com.example.employeepayrollapp.model.EmployeePayrollData;

public interface IEmployeePayrollService {

	List<EmployeePayrollData> getEmployeePayrollData();
	EmployeePayrollData getEmployeePayrollDataById(int empId);
	List<EmployeePayrollData>getEmployeesByDepartment(String department);
	
	EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empDTO);
	EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO empDTO);
void deleteEmployeePayrollData(int empId);
}
