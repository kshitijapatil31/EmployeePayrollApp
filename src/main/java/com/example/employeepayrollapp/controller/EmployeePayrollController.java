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
import com.example.employeepayrollapp.dto.ResponseDTO;
import com.example.employeepayrollapp.model.EmployeePayrollData;

@RestController
@RequestMapping("/employeepayroll")
public class EmployeePayrollController {

	@RequestMapping(value = { "", "/", "/employee" })
	public ResponseEntity<ResponseDTO> getEmployeePayroll() {
		EmployeePayrollData employeePayrollData = null;

		employeePayrollData = new EmployeePayrollData(1, new EmployeePayrollDTO("kshitija", 40000));
		ResponseDTO resDto = new ResponseDTO("Get Call Success", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(resDto, HttpStatus.OK);
	}

	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
		EmployeePayrollData employeePayrollData = null;

		employeePayrollData = new EmployeePayrollData(1, new EmployeePayrollDTO("kshitija", 40000));
		ResponseDTO resDto = new ResponseDTO("Get Successful for id", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(resDto, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeePayrollData = null;

		employeePayrollData = new EmployeePayrollData(1, employeePayrollDTO);
		ResponseDTO resDto = new ResponseDTO("created employee payroll data:", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(resDto, HttpStatus.OK);

	}

	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,@RequestBody EmployeePayrollDTO employeePayrollDTO){
EmployeePayrollData employeePayrollData=null;
		
		employeePayrollData=new EmployeePayrollData(empId,employeePayrollDTO);
		ResponseDTO resDto=new ResponseDTO("update employee payroll data:",employeePayrollData);
		return new ResponseEntity<ResponseDTO>(resDto,HttpStatus.OK);
		
		

	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId,@RequestBody EmployeePayrollDTO employeePayrollDTO){
     EmployeePayrollData employeePayrollData=null;
		
		employeePayrollData=new EmployeePayrollData(empId,employeePayrollDTO);
		ResponseDTO resDto=new ResponseDTO("delete employee payroll:",employeePayrollData);
		return new ResponseEntity<ResponseDTO>(resDto,HttpStatus.OK);
		
		
		

	}
}
