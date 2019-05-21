package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.utile.EGender;
import com.example.demo.utile.GeneralResponse;
import java.util.Date;
import java.util.List;

/**
 *
 * @author david
 */
public interface IStudent {

    public GeneralResponse<List<Student>> getAllStudent();

    public GeneralResponse<Student> getStudentById(Integer id);

    public GeneralResponse<Student> addNewStudent(String name, String email, String username, EGender gender, String password, Date DOB);

    public GeneralResponse deleteStudent(Integer id);

}
