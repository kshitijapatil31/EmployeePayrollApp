package com.example.employeepayrollapp.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.employeepayrollapp.controller.EmployeePayrollController;
import com.example.employeepayrollapp.dto.ResponseDTO;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class EmployeePayrollExceptionHandler {
	
	private final String message="Exception whileprocessing rest request";
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public  ResponseEntity<ResponseDTO> handHttpMessageException(HttpMessageNotReadableException exception){
		log.error("Invalid Date format",exception);
		ResponseDTO responseDto=new ResponseDTO(message,"Should date in format dd-MMM-yyyy");
		return new ResponseEntity<ResponseDTO>(responseDto , HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO>handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
		List<ObjectError>errorList=exception.getBindingResult().getAllErrors();
	List<String>errMsg=errorList.stream().map(objerr ->objerr.getDefaultMessage()).collect(Collectors.toList());
	ResponseDTO responseDto=new ResponseDTO(message,errMsg);
	return new ResponseEntity<ResponseDTO>(responseDto , HttpStatus.BAD_REQUEST);
	
	
	}
	@ExceptionHandler(EmployeePayrollException.class)
	public ResponseEntity<ResponseDTO>handleEmployeePayrollException(EmployeePayrollException exception){
		
	ResponseDTO responseDto=new ResponseDTO(message,exception.getMessage());
	return new ResponseEntity<ResponseDTO>(responseDto , HttpStatus.BAD_REQUEST);
	
	
	}

}
