package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.model.Student;
import com.example.demo.service.IStudent;
import com.example.demo.utile.GeneralResponse;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author david
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudent iStudentService;

    @GetMapping("/listAll")
    public GeneralResponse<List<Student>> getAllStudent() {
        return iStudentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public GeneralResponse<Student> getStudentById(@PathVariable(required = true, value = "id") Integer id) {
        return iStudentService.getStudentById(id);
    }

    @PostMapping("/")
    public GeneralResponse<Student> addNewStudent(@RequestBody @Valid StudentDTO student) {
        return iStudentService.addNewStudent(
                student.getName(),
                student.getEmail(),
                student.getUsername(),
                student.getGender(),
                student.getPassword(),
                student.getDOB()
        );
    }

    @DeleteMapping("/{id}")
    public GeneralResponse deleteStudent(@PathVariable(required = true, value = "id") Integer id) {
        return iStudentService.deleteStudent(id);
    }

}
