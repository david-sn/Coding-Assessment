package com.example.demo.controller;

import com.example.demo.dto.RegisterDTO;
import com.example.demo.service.impl.RegistrationService;
import com.example.demo.service.mapper.UserCourses;
import com.example.demo.utile.GeneralResponse;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/action")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/registerInCourse")
    public GeneralResponse<Boolean> registerInCourse(@RequestBody @Valid RegisterDTO registerDTO) {
        return registrationService.registerInCourse(registerDTO.getCourseId(), registerDTO.getStudentId());
    }

    @PostMapping("/unRegisterFromCourse")
    public GeneralResponse<Boolean> unRegisterInCourse(@RequestBody @Valid RegisterDTO registerDTO) {
        return registrationService.unRegisterInCourse(registerDTO.getCourseId(), registerDTO.getStudentId());
    }

    @GetMapping("/getUserCourses/{id}")
    public GeneralResponse<List<UserCourses>> listAllCoursesStudentRegistered(@PathVariable(required = true, value = "id") Integer studentId) {
        return registrationService.listAllCoursesStudentRegistered(studentId);
    }

}
