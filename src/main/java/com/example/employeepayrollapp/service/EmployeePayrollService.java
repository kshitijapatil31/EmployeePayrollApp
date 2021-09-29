package com.example.employeepayrollapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employeepayrollapp.dto.EmployeePayrollDTO;
import com.example.employeepayrollapp.exception.EmployeePayrollException;
import com.example.employeepayrollapp.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
	 List<EmployeePayrollData> employeeList=new ArrayList<>();
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeeList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		return employeeList.stream()
				.filter(empDta->empDta.getEmployeeId()==empId)
				.findFirst()
				.orElseThrow(()->new EmployeePayrollException("Employee not found"));
	
	
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empDTO) {
		EmployeePayrollData empData=null;
		empData=new EmployeePayrollData(employeeList.size()-1,empDTO);
		employeeList.add(empData);
		return empData;
		
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO empDTO) {
		EmployeePayrollData empData=this.getEmployeePayrollDataById(empId);
		empData.setName(empDTO.name);
		empData.setSalary(empDTO.salary);
		employeeList.set(empId-1,empData);
		return empData;
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		employeeList.remove(empId-1);
		
	}

}
