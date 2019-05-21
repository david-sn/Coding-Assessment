package com.example.demo.service;

import com.example.demo.service.mapper.UserCourses;
import com.example.demo.utile.GeneralResponse;
import java.util.List;

/**
 *
 * @author david
 */
public interface IRegistration {

    public GeneralResponse<Boolean> registerInCourse(Integer courseId, Integer StudentId);

    public GeneralResponse<Boolean> unRegisterInCourse(Integer courseId, Integer StudentId);

    public GeneralResponse<List<UserCourses>> listAllCoursesStudentRegistered(Integer studentId);

}
