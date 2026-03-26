package com.delochi.cruddemo.config;

import com.delochi.cruddemo.dao.StudentDao;
import com.delochi.cruddemo.dao.StudentDaoImpl;
import com.delochi.cruddemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class ConfigBeans {

    final StudentDao studentDao;

    @Autowired
    public ConfigBeans(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return runnerArgs -> {
            System.out.println("Hello World! from CLI.");
            System.out.println("Runner arguments are: " + Arrays.toString(runnerArgs));

            createMultipleStudent(studentDao, 3);

//            readStudent(studentDao);

//            queryStudents();

//            findStudentsWithSimilarLastnames();

//            updateStudent();

//            deleteStudent();

//            deleteAllStudents();
        };
    }

    private void deleteAllStudents() {
        System.out.println("Trying to delete all records.");
        int rowsDeleted = studentDao.deleteAll();
        System.out.println("The number of deleted students is: " + rowsDeleted);
    }

    private void deleteStudent() {
//        Check students availability
        int id = 3;
        Student studentForDeletion = studentDao.findById(id);
        System.out.println("The student about to be deleted is: " + studentForDeletion);
//        delete student
        studentDao.delete(id);
        System.out.println("Deleted successfully without exceptions.");
    }

    private void updateStudent() {
        int id = 1;
//        fetch the student
        System.out.println("Fetching student with the ID of: " + id);
        Student student =  studentDao.findById(id);
        System.out.println("The fetched student is: " + student);
//        Change the student
        student.setFirstName("Jasem");
//        update the student
        studentDao.update(student);
        System.out.println("The updated student is now: " + student);
    }

    private void findStudentsWithSimilarLastnames() {
//        Get students with similar lastnames
        List<Student> studentList = studentDao.findBySimilarLastName("    test  ");
//        Print out the students with similar lastnames
        studentList.stream().map(Student::toString).forEach(System.out::println);
    }

    private void queryStudents() {
        // get a list of all students
        List<Student> students = studentDao.findAll();
        // Print the students in output
        students.forEach(s -> {
            System.out.println(s.toString());
        });
    }

    private void readStudent(StudentDao studentDao) {

        //Create a Student.
        System.out.println("Creating an student instance...");
        Student student = new Student("student", "ToRead", "readbaleStudent@gmail.com");
        //Persist the created student in db.
        System.out.println("Starting to save the the student");
        studentDao.save(student);
        //fetch the student by ID.
        System.out.println("Trying to fetch the student with the ID: " + student.getId());
        Student fetchedStudent = studentDao.findById(Math.toIntExact(student.getId()));
        //Print out the student.
        System.out.println("The fetched student is: " + fetchedStudent);
    }


    private void createMultipleStudent(StudentDao studentDao, int howManyStudents) {
        int numberOfStudents = howManyStudents; // to check to auto increment feature in db.
        Student[] students = new Student[numberOfStudents];
        System.out.println("Starting to persist " + howManyStudents + " number of students.");
        for (int i = 0; i < numberOfStudents; i++) {
            students[i] = new Student("testName" + i, "testLastName" + i, "email" + i + "gmail.com");
            studentDao.save(students[i]);
            System.out.println("The saved student ID is: " + students[i].getId());
        }
    }
}
