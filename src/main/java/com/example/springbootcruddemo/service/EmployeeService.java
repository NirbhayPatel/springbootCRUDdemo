package com.example.springbootcruddemo.service;

import com.example.springbootcruddemo.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findEmployeeByEmployeeNameStartingWith(String name); // fetch list of Employee which start with
    /*List<Employee> findEmployeeByEmployeeRole(String role);  */       // fetch Employee by role
    List<Employee> findAll();
    Employee save(Employee employee);
    void delete(long employeeId);
    List<Employee> findEmployeesBySalary(String salary);
    Employee update(Employee employee);
    Employee findEmployeeId(long employeeID);
}