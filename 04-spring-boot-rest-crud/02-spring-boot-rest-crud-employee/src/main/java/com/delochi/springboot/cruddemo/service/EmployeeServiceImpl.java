package com.delochi.springboot.cruddemo.service;

import com.delochi.springboot.cruddemo.dao.EmployeeDao;
import com.delochi.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    EmployeeDao employeeDao;

    JsonMapper jsonMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao, JsonMapper jsonMapper) {
        this.employeeDao = employeeDao;
        this.jsonMapper = jsonMapper;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(int employeeId) {
        return employeeDao.findById(employeeId);
    }

    @Override
    @Transactional
    public Employee insertEmployee(Employee employee) {
        employee.setId(0); //Just to sasaveve a new record in the database instead of updating it
        return employeeDao.save(employee);
    }

    @Override
    @Transactional
    public Employee updateEmployee(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDao.deleteById(id);
    }

    @Override
    @Transactional
    public Employee partialUpdate(int employeeId, Map<String, Object> keyValuePairs) {
        Employee targetEmployee = employeeDao.findById(employeeId);
        if (targetEmployee == null) {
            throw  new RuntimeException("There is no current employee with the id: " + employeeId);
        }
        if (keyValuePairs.containsKey("id")) {
            throw new RuntimeException("You are not allowed to edit or update any employee id.");
        }
//        Instead of injecting a jsonMapper as a helper object, I could define a method in a new util class which merges the partial update through reflection.
        Employee mergedEmployee = jsonMapper.updateValue(targetEmployee, keyValuePairs);
//        todo: apply exception handling for unability to merge because of passing wrong keyValuePairs.
        return employeeDao.save(mergedEmployee);
    }
}
