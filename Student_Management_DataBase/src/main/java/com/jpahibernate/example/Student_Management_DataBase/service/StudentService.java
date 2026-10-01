package com.jpahibernate.example.Student_Management_DataBase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpahibernate.example.Student_Management_DataBase.model.Student;
import com.jpahibernate.example.Student_Management_DataBase.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String AddStudent(Student studentRequest) {

        studentRepository.save(studentRequest);

        return "Student Saved Successfully!";
    }

    public Student GetStudentByID(int id) {

        Optional<Student> StudentOptional = studentRepository.findById(id);

        if (StudentOptional.isPresent()) {
            return StudentOptional.get();
        } else {
            return null;
        }
    }

    public List<Student> GetAllStudents() {

        List<Student> StudentList =studentRepository.findAll();
        return StudentList;
    }
}
