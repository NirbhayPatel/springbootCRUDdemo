package com.example.springbootcruddemo.dao;

import com.example.springbootcruddemo.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface EmployeeDAO extends CrudRepository<Employee,Long> {

    List<Employee> findEmployeeByEmployeeNameStartingWith(String name); // fetch list of Employee which start with
    /*List<Employee> findEmployeeByEmployeeRole(String role);*/         // fetch Employee by role
    List<Employee> findAll();// fetch all Employee
    @Query("select e from Employee e where e.salary = :salary")
    List<Employee> findEmployeesBySalary(@Param("salary") String salary);
    Employee findEmployeesByEmployeeId(long id);
}
