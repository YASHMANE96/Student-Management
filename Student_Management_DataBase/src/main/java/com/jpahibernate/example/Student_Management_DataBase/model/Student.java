package com.jpahibernate.example.Student_Management_DataBase.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //@Entity :- It represents that this class is Entity Or Model Class Which is Directly Creating the Batabase Table Or Schema
@Table(name="student") // it will create a table inside database

public class Student {
    
    @Id //It is the Primary Key of the Table (It will be unique and it is not Null)  
    @Column(name="id") //It Will Create a Column Inside Database Table
    private int Id;

    @Column(name="student_name", nullable = false) // Nullable = false :- It cannot contain null value
    private String Name;

    @Column(name="email", nullable = false, unique = true) // Unique = true :- It cannot contain duplicated value
    private String Email;

    @Column(name="dob", nullable = false)
    private String DOB;

    @Column(name="gender", nullable = false)
    private String Gender;

    @Column(name="grade", nullable = false)
    private String Grade;

    @Column(name ="mobile_No", nullable = false)
    private String MobileNO;

    //Getter And Setter Created
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String dOB) {
        DOB = dOB;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public String getMobileNO() {
        return MobileNO;
    }

    public void setMobileNO(String mobileNO) {
        MobileNO = mobileNO;
    }

    
}
