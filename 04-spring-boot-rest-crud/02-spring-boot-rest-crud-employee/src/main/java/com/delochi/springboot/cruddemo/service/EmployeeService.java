package com.delochi.springboot.cruddemo.service;

import com.delochi.springboot.cruddemo.entity.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    public List<Employee> findAll();

    Employee findById(int employeeId);

    Employee insertEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteById(int id);

    Employee partialUpdate(int employeeId, Map<String, Object> keyValuePairs);
}
