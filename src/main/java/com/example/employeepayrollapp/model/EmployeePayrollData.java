package com.example.employeepayrollapp.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.employeepayrollapp.dto.EmployeePayrollDTO;

import lombok.Data;

public @Data class EmployeePayrollData {

	
	private int employeeId;
	private String name;
	private long salary;
	public String gender;
	public LocalDate startDate;
	public String role;
	public String profilePic;
	@Column(name="department")
	public List<String> departments;
	
	
	public  EmployeePayrollData() {}

	public EmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO) {

		this.employeeId = employeeId;
		
		this.updateEmployeePayrollData (employeePayrollDTO);
		
	}

	public void updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		this.name = employeePayrollDTO.name;
		this.salary = employeePayrollDTO.salary;
		this.gender=employeePayrollDTO.gender;
		this.startDate=employeePayrollDTO.startDate;
		this.role=employeePayrollDTO.role;
		this.profilePic=employeePayrollDTO.profilePic;
		this.departments=employeePayrollDTO.departments;
	}
	
	
}
