package com.example.demo.controller;

import com.example.demo.dto.CourseDTO;
import com.example.demo.model.Course;
import com.example.demo.service.ICourse;
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
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private ICourse iCourse;

    @GetMapping("/")
    public GeneralResponse<List<Course>> getAllAvailableCourses() {
        return iCourse.getAllCourses();
    }

    @GetMapping("/{id}")
    public GeneralResponse<Course> getCourseById(@PathVariable("id") Integer id) {
        return iCourse.getCourseById(id);
    }

    @PostMapping("/")
    public GeneralResponse<Course> addNewCourse(@RequestBody @Valid CourseDTO course) {
        return iCourse.addNewCourse(
                course.getName(),
                course.getDescription(),
                course.getPublishDate(),
                course.getInstructor(),
                course.getTotalHours()
        );
    }

    @DeleteMapping("/{id}")
    public GeneralResponse deleteCourse(@PathVariable("id") Integer id) {
        return iCourse.deleteCourse(id);
    }

}
