package com.delochi.springboot.cruddemo.dao;

import com.delochi.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> findAll();
    public Employee findById(int id);
    public Employee save(Employee employee);
    public void deleteById(int id);
}
