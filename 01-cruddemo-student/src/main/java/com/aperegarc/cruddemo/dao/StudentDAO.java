package com.aperegarc.cruddemo.dao;

import com.aperegarc.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);
    Student findById(Integer id);
    List<Student> findAll();


}
