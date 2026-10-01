package com.jpahibernate.example.Student_Management_DataBase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpahibernate.example.Student_Management_DataBase.model.Student;
import com.jpahibernate.example.Student_Management_DataBase.repository.StudentRepository;

//In Service We Write Business Logics

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

    public String CountStudents(){
        long TotalCount = studentRepository.count();
        return "Total Students Present Are :- " + TotalCount;
    }

    public String updateStudentUsingPut(int id, Student newStudentRequest){
        // find student with id
        // if student is present, update it
        // else we cannot update

        Student exisitingStudent = GetStudentByID(id);

        if(exisitingStudent!=null){
            // proceed to update
            studentRepository.save(newStudentRequest);
            return "Student updated successfully!";
        }else{
            // cannot update
            return "Student not found, hence cannot update!";
        }
    }

    public String updateStudentEmailUsingPatch(int id, String newEmail){
        // find student with id
        // if student is present, update it
        // else we cannot update

        Student exisitingStudent = GetStudentByID(id);

        if (exisitingStudent != null) {

            exisitingStudent.setEmail(newEmail);

            studentRepository.save(exisitingStudent);

            return "Student updated successfully!";

        } else {

            return "Student not found, hence cannot update!";
        }
    }

    public String DeleteStudentByID(int id){
        studentRepository.deleteById(id);
        return "Student With Id :- " + id + " Got Deleted Successfully!";
    }
}
