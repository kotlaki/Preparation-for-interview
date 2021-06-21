package com.kurganov.lesson7.services;

import com.kurganov.lesson7.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    void save(Student student);

    void delete(Student student);

    Student findById(Long id);
}
