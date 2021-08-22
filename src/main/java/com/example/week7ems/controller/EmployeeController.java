package com.example.week7ems.controller;

import com.example.week7ems.models.Employee;
import com.example.week7ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    // display list of employees
    @GetMapping("/employee-details")
    public String viewEmployeeList(Model model) {
//        Object adminObject = session.getAttribute("admin");
//        if (adminObject == null)
//            return "redirect:/";

//        ModelAndView modelAndView = new ModelAndView("employee_details");
        System.err.println("checking redirect");
        model.addAttribute("employeeList", employeeService.getAllEmployees());
        System.err.println("checking redirect alsoooo");
        return "employee_details";
    }
    @GetMapping("/register_employee")
    public String viewRegister(@ModelAttribute(value = "employee") Employee employee, Model model) {
      model.addAttribute("employee",employee);
        return "register_employee";
    }

    // create model attribute to bind form data
    @GetMapping("/addNewEmployeeForm")
    public String addNewEmployeeForm(Model model) {
//        Object adminObject = session.getAttribute("admin");
//        if (adminObject != null) {
//            return "redirect:/";
//        }

        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "redirect:/register_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute(value = "employee") Employee employee) {
        // save employee to database
        employeeService.saveEmployee(employee);
        return "redirect:/employee-details";
    }

    @GetMapping("/update_details")
    public String viewUpdate(@ModelAttribute(value = "employee") Employee employee, Model model) {
        model.addAttribute("employee", employee);
        return "update_details";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable(value = "id") Long id, Model model) {
        System.out.println(id+"hope is worried ");
        //get employee from the service
        Employee employee = employeeService.getEmployeeById(id);

        //set employee as a model to pre-populate form
        model.addAttribute("employee", employee);
        return "update_details";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Long id) {
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/employee-details";
    }

}
