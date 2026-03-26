package com.delochi.cruddemo.dao;

import com.delochi.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{

    EntityManager entityManager;

    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("FROM student order by lastName desc", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findBySimilarLastName(String lastname) {
        lastname = lastname.trim();
        TypedQuery<Student> studentTypedQuery = entityManager.createQuery(
                "from student where lastName like concat('%', :inputLastName, '%')", Student.class);
        studentTypedQuery.setParameter("inputLastName", lastname);
        List<Student> studentList = studentTypedQuery.getResultList();
        return studentList;
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        Query deleteQuery = entityManager.createQuery("delete from student");
        int rowsDeleted = deleteQuery.executeUpdate();
        return rowsDeleted;
    }
}
