package com.example.demo.service.impl;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.IStudent;
import com.example.demo.utile.EGender;
import com.example.demo.utile.EResponseStatus;
import com.example.demo.utile.GeneralResponse;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author david
 */
@Service
public class StudentService implements IStudent {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public GeneralResponse<List<Student>> getAllStudent() {
        List<Student> allStudents = studentRepository.findAll();
        return new GeneralResponse<>(EResponseStatus.OK, allStudents);
    }

    @Override
    public GeneralResponse<Student> getStudentById(Integer id) {
        Optional<Student> studentDB = studentRepository.findById(id);
        if (studentDB.isPresent()) {
            return new GeneralResponse<>(EResponseStatus.OK, studentDB.get());
        } else {
            return new GeneralResponse<>(EResponseStatus.NOT_FOUND, "the Data you Request not found");
        }
    }

    @Override
    public GeneralResponse<Student> addNewStudent(String name, String email, String username, EGender gender, String password, Date DOB) {
        Student isFoundBefore = studentRepository.findByEmailOrUsername(email, username);
        if (isFoundBefore == null) {
            Student newStudent = new Student(name, email, username, gender.getGender(), password, DOB);
            Student savedStudent = studentRepository.save(newStudent);
            return new GeneralResponse<>(EResponseStatus.OK, savedStudent);
        } else {
            return new GeneralResponse<>(EResponseStatus.DATA_DUBLICATE);
        }

    }

    @Override
    public GeneralResponse deleteStudent(Integer id) {
        Optional<Student> studentDB = studentRepository.findById(id);
        if (studentDB.isPresent()) {
            studentRepository.delete(studentDB.get());
            return new GeneralResponse<>(EResponseStatus.OK);
        } else {
            return new GeneralResponse<>(EResponseStatus.NOT_FOUND, "the Data you Request not found");
        }
    }

}
