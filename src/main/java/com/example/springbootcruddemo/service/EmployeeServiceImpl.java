package com.example.springbootcruddemo.service;

import com.example.springbootcruddemo.dao.EmployeeDAO;
import com.example.springbootcruddemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public List<Employee> findEmployeeByEmployeeNameStartingWith(String name) {
        return employeeDAO.findEmployeeByEmployeeNameStartingWith(name);
    }

    @Override
    public Employee update(Employee employee) {
        /*if (employee.getEmployeeId() != null && !employeeDAO.exists(employee.getId())) {
            throw new EntityNotFoundException("There is no entity with such ID in the database.");
        }*/
        return employeeDAO.save(employee);
    }


    /*@Override
    public List<Employee> findEmployeeByEmployeeRole(String role) {
        return employeeDAO.findEmployeeByEmployeeRole(role);
    }*/

    @Override
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    public void delete(long employeeId) {
        employeeDAO.deleteById(employeeId);
    }

    @Override
    public List<Employee> findEmployeesBySalary(String salary) {
        return employeeDAO.findEmployeesBySalary(salary);
    }

    @Override
    public Employee findEmployeeId(long employeeID) {
        return employeeDAO.findEmployeesByEmployeeId(employeeID);
    }

    @Override
    public List<Employee> findEmployeesBySalaryBetween(String minSalary, String maxSalary) {
        return employeeDAO.findEmployeesBySalaryBetween(minSalary,maxSalary);
    }
}
