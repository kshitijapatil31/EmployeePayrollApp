package com.example.employeepayrollapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeepayrollapp.model.EmployeePayrollData;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData ,Integer> {

}
