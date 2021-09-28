package com.example.employeepayrollapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employeepayrollapp.dto.EmployeePayrollDTO;
import com.example.employeepayrollapp.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		 List<EmployeePayrollData> employeeList=new ArrayList<>();
		 employeeList.add(new EmployeePayrollData(1,new EmployeePayrollDTO("kshitija",40000)));
		 
		return employeeList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		EmployeePayrollData empData=null;
		empData=new EmployeePayrollData(1,new EmployeePayrollDTO("Kshitija",40000));
		return empData;
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empDTO) {
		EmployeePayrollData empData=null;
		empData=new EmployeePayrollData(1,empDTO);
		return empData;
		
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO empDTO) {
		EmployeePayrollData empData=null;
		empData=new EmployeePayrollData(1,empDTO);
		return empData;
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
	
		
	}

}
