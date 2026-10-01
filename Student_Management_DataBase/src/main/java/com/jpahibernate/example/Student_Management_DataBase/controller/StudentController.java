package com.jpahibernate.example.Student_Management_DataBase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpahibernate.example.Student_Management_DataBase.model.Student;
import com.jpahibernate.example.Student_Management_DataBase.service.StudentService;



@RestController
@RequestMapping("/student/apis")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/save")
    public String SaveStudent(@RequestBody Student studentRequest) {
        String Response = studentService.AddStudent(studentRequest);
        return Response;
    }

    @GetMapping("/find/{id}")
    public Student FindStudentById(@PathVariable int id) {
        Student student = studentService.GetStudentByID(id);
        return student;
    }

    @GetMapping("/findAll")
    public List<Student> FindAllStudents() {
        List<Student> studentList = studentService.GetAllStudents();
        return studentList;
    }

    @GetMapping("/count")
    public String countStudents(){
        String Response = studentService.CountStudents();
        return Response;
    }

    @PutMapping("/updatePut/{id}")
    public String updateStudentUsingPut(@PathVariable int id, @RequestBody Student newStudentRequest){
        String Response = studentService.updateStudentUsingPut(id,newStudentRequest);
        return Response;
    }


    //@RequestParam :- only requesting that particular parameter(takes in the form of request parameter query)
    @PatchMapping("/updatePatch/{id}")
    public String updateStudentEmailUsingPatch(@PathVariable int id, @RequestParam String newEmail) {
        String Response = studentService.updateStudentEmailUsingPatch(id, newEmail);
        return Response;
    }

    @DeleteMapping("/delete/{id}")
    public String DeleteStudentByID(@PathVariable int id){
        String Response = studentService.DeleteStudentByID(id);
        return Response;
    }
}