package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.utile.GeneralResponse;
import java.util.Date;
import java.util.List;

/**
 *
 * @author david
 */
public interface ICourse {

    public GeneralResponse<List<Course>> getAllCourses();

    public GeneralResponse<Course> getCourseById(Integer id);
    
    public GeneralResponse<Course> addNewCourse(String name, String description, Date publishDate, String instructor, Integer totalHours);

    public GeneralResponse deleteCourse(Integer id);

}
