package com.example.employeepayrollapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeepayrollapp.dto.EmployeePayrollDTO;

@RestController
@RequestMapping("/employeepayroll")
public class EmployeePayrollController {

	@RequestMapping(value= {"","/","/employee"})
	public ResponseEntity<String> getEmployeePayroll(){
		return new ResponseEntity<String>("Get Call Success",HttpStatus.OK);
	}
	@GetMapping("/get/{empId}")
	public ResponseEntity<String> getEmployeePayrollData(@PathVariable("empId") int empId){
		return new ResponseEntity<String>("Get Call Success for id"+empId,HttpStatus.OK);

	}
	@PostMapping("/create")
	public ResponseEntity<String> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO){
		return new ResponseEntity<String>("created employee payroll data:"+employeePayrollDTO,HttpStatus.OK);

	}
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO){
		return new ResponseEntity<String>("update employee payroll data:"+employeePayrollDTO,HttpStatus.OK);

	}
	@DeleteMapping
	public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId") int empId){
		return new ResponseEntity<String>("delete employee payroll:"+empId,HttpStatus.OK);

	}
}
