package com.example.springbootcruddemo.controller;

import com.example.springbootcruddemo.model.Employee;
import com.example.springbootcruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

@RestController     // for rest response
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // to add new employee
    @RequestMapping(value = "save",method = RequestMethod.POST)     // or user @GetMapping
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    // list of all employee
    @RequestMapping(value = "listEmployee",method = RequestMethod.GET)   // or use @GetMapping
    public java.util.List<Employee> listEmployee(String salary) {
        if(salary!=null){
           return employeeService.findEmployeesBySalary(salary);
        }else {
            return employeeService.findAll();
        }
    }

    // delete specific employee using employee id
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)        // or use @DeleteMapping
    public String delete(@RequestParam("id")long id){
        try{
            employeeService.delete((int) id);
            return "Successfully data deleted";
        }catch (EmptyResultDataAccessException e){
            return "No data found in table for :" + id;
        }


    }

    // search employee start with name
    @RequestMapping(value = "startWithName")
    public java.util.List<Employee> findByName(@RequestParam("name")String name){
        return employeeService.findEmployeeByEmployeeNameStartingWith(name);
    }

    // search employee by role
    /* @RequestMapping(value = "findByRole/{role}")
    public java.util.List<Employee> findByRole(@PathVariable("role")String role){
        return employeeService.findEmployeeByEmployeeRole(role);
    }*/

    @RequestMapping(value = "updateEmployee", method = RequestMethod.PUT)
    public String updateEmployee(@RequestBody Employee employee){
        if(employeeService.findEmployeeId(employee.getEmployeeId()) != null){
            employeeService.update(employee);
            return "Employee updated successfully";
        }else{
            return "Employee is not found in the table";
        }

    }
}
