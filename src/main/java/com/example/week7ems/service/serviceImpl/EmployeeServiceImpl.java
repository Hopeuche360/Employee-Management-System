package com.example.week7ems.service.serviceImpl;

import com.example.week7ems.models.Employee;
import com.example.week7ems.repository.EmployeeRepo;
import com.example.week7ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepo.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
         employeeRepo.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> optional = employeeRepo.findById(id);
        Employee employee = optional.get();
   return employee;
    }

    @Override
    public void deleteEmployeeById(Long id) {
        this.employeeRepo.deleteById(id);
    }

    @Override
    public Optional<Employee> findbyemailandpassword(String email, String password) {
        return  employeeRepo.findByEmailAndPassword(email,password);
    }


}
