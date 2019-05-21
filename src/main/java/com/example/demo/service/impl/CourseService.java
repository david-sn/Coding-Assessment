/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service.impl;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.ICourse;
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
public class CourseService implements ICourse {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public GeneralResponse<List<Course>> getAllCourses() {
        List<Course> allAvailabelCourses = courseRepository.findAll();
        return new GeneralResponse<>(EResponseStatus.OK, allAvailabelCourses);
    }

    @Override
    public GeneralResponse<Course> getCourseById(Integer id) {
        Optional<Course> courseDB = courseRepository.findById(id);
        if (courseDB.isPresent()) {
            return new GeneralResponse<>(EResponseStatus.OK, courseDB.get());
        } else {
            return new GeneralResponse<>(EResponseStatus.NOT_FOUND, "the Data you Request not found");
        }
    }

    @Override
    public GeneralResponse<Course> addNewCourse(String name, String description, Date publishDate, String instructor, Integer totalHours) {
        Course newCourse = new Course(name, description, publishDate, totalHours, instructor);
        Course savedCourse = courseRepository.save(newCourse);
        return new GeneralResponse<>(EResponseStatus.OK, savedCourse);
    }

    @Override
    public GeneralResponse deleteCourse(Integer id) {
        Optional<Course> courseDB = courseRepository.findById(id);
        if (courseDB.isPresent()) {
            courseRepository.delete(courseDB.get());
            return new GeneralResponse<>(EResponseStatus.OK);
        } else {
            return new GeneralResponse<>(EResponseStatus.NOT_FOUND, "the Data you Request not found");
        }
    }

}
