package com.example.employeepayrollapp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeepayrollapp.dto.EmployeePayrollDTO;
import com.example.employeepayrollapp.exception.EmployeePayrollException;
import com.example.employeepayrollapp.model.EmployeePayrollData;
import com.example.employeepayrollapp.repository.EmployeePayrollRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {
	@Autowired
	private EmployeePayrollRepository employeePayrollRepository;
	
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeePayrollRepository.findAll();
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		return employeePayrollRepository
				.findById(empId)
				.orElseThrow(()->new EmployeePayrollException("Employee not found"+empId+"doesn't exits"));
	
	
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empDTO) {
		EmployeePayrollData empData=null;
		empData=new EmployeePayrollData(empDTO);
		
		log.debug("Employee Data"+empData.toString());
		return employeePayrollRepository.save(empData);
		
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO empDTO) {
		EmployeePayrollData empData=this.getEmployeePayrollDataById(empId);
		empData.updateEmployeePayrollData(empDTO);
		
		return employeePayrollRepository.save(empData);
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		EmployeePayrollData empData=this.getEmployeePayrollDataById(empId);
		employeePayrollRepository.delete(empData);
		
	}

	@Override
	public List<EmployeePayrollData> getEmployeesByDepartment(String department) {
		return employeePayrollRepository.findEmployeesByDepartment(department);
		
	}

}
