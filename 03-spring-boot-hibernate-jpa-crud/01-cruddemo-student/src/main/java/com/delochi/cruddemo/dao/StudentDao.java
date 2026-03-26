package com.delochi.cruddemo.dao;

import com.delochi.cruddemo.entity.Student;

import java.util.List;

public interface StudentDao {
    public void save(Student student);

    public Student findById(int id);

    public List<Student> findAll();

    public List<Student> findBySimilarLastName(String lastname);

    public void update(Student student);

    public void delete(int id);

    int deleteAll();
}
