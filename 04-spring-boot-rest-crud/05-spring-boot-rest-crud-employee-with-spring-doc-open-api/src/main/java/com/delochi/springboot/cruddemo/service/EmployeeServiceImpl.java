package com.delochi.springboot.cruddemo.service;

import com.delochi.springboot.cruddemo.dao.EmployeeRepository;
import com.delochi.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    EmployeeRepository employeeRepository;

    JsonMapper jsonMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, JsonMapper jsonMapper) {
        this.employeeRepository = employeeRepository;
        this.jsonMapper = jsonMapper;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int employeeId) {
        Employee employee = null;
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isPresent()) {
            employee = optionalEmployee.get();
        } else {
            throw new RuntimeException("No employee with the following ID: " + employeeId);
        }
        return employee;
    }

    @Override
    @Transactional
    public Employee insertEmployee(Employee employee) {
        employee.setId(0); //Just to sasaveve a new record in the database instead of updating it
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Employee partialUpdate(int employeeId, Map<String, Object> keyValuePairs) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isEmpty()) {
            throw  new RuntimeException("There is no current employee with the id: " + employeeId);
        }
        Employee targetEmployee = optionalEmployee.get();
        if (keyValuePairs.containsKey("id")) {
            throw new RuntimeException("You are not allowed to edit or update any employee id.");
        }
//        Instead of injecting a jsonMapper as a helper object, I could define a method in a new util class which merges the partial update through reflection.
        Employee mergedEmployee = jsonMapper.updateValue(targetEmployee, keyValuePairs);
//        todo: apply exception handling for unability to merge because of passing wrong keyValuePairs.
        return employeeRepository.save(mergedEmployee);
    }
}
