package com.example.week7ems.service;

import com.example.week7ems.models.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    void deleteEmployeeById(Long id);
    Optional<Employee>findbyemailandpassword(String email,String password);
}
