package com.delochi.springboot.cruddemo.rest;

import com.delochi.springboot.cruddemo.entity.Employee;
import com.delochi.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeesById(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Not found employee with given id - " + employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.insertEmployee(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        employeeService.deleteById(employeeId);
        return "Successfully deleted the employee with ID: " + employeeId;
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee partialUpdateEmployee(@PathVariable int employeeId,@RequestBody Map<String, Object> keyValuePairs) {
        Employee employee = employeeService.partialUpdate(employeeId, keyValuePairs);
        return employee;
    }
}
