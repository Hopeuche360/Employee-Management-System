package com.example.week7ems.controller;

import com.example.week7ems.models.Employee;
import com.example.week7ems.models.LoginDto;
import com.example.week7ems.repository.EmployeeRepo;
import com.example.week7ems.repository.LoginRepo;
import com.example.week7ems.service.serviceImpl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LoginController {
   @Autowired
    EmployeeServiceImpl employeeService;
    @GetMapping("/")
    public String home(Model model){
        LoginDto loginDto = new LoginDto();
        model.addAttribute("logindto",loginDto);
        return "admin_login";
    }
    @PostMapping(value = "/login")
    public String login (@ModelAttribute("logindto")LoginDto logindto){
        Optional<Employee> optionalLoginDto = employeeService.findbyemailandpassword(logindto.getEmail(),logindto.getPassword());
        System.err.println(optionalLoginDto.get().getEmail());
        System.err.println(optionalLoginDto.get().getPassword());
        System.err.println("optional thing");
       if (optionalLoginDto.isPresent()){
            System.err.println("something");
            return "redirect:/employee-details";
        }else {
            System.err.println("return something");
            return "employee_details";
        }
    }
}
