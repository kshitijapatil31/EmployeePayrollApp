package com.example.employeepayrollapp.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import lombok.ToString;



public @ToString class EmployeePayrollDTO {

	
	@Pattern(regexp ="^[A-Z]{1}[a-zA-z\\s]{2,}$",message="Employee name Invalid")
	public String name;
	
	@Min(value=500,message="salary is invalid")
	public long salary;
	
	@Pattern(regexp ="male|femal",message="Gender needs to be male or female")
	public String gender;
	
	
	@JsonFormat(pattern="dd MMM yyyy")
	@NotNull(message="startDate should not be empty")
	@PastOrPresent(message="startDate should be past or present")
	public LocalDate startDate;
	
	@NotBlank(message="role cannot be blank")
	public String role;
	
	@NotBlank(message="profilePic cannot be blank")
	public String profilePic;
	
	@NotNull(message="departments should not be empty")
	public List<String> departments;
	
	
	

	
}
