package com.example.employeepayrollapp.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class EmployeePayrollDTO {

	@NotEmpty
	@Pattern(regexp ="^[A-Z]{1}[a-zA-z\\s]{2,}$",message="Employee name Invalid")
	public String name;
	@Min(value=500,message="salary is invalid")
	public long salary;
	public EmployeePayrollDTO(String name, long salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	
	
	
	
}
