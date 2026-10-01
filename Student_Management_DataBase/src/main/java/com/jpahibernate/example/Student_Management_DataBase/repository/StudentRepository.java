package com.jpahibernate.example.Student_Management_DataBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jpahibernate.example.Student_Management_DataBase.model.Student;


@Repository //It Performs the Database Operations And It is the Data Layer
public interface StudentRepository extends JpaRepository<Student, Integer> {
    
}
