package com.example.demo.service.mapper;

import com.example.demo.model.Course;
import java.util.Date;

/**
 *
 * @author david
 */
public class UserCourses {

    private String name;
    private String description;
    private Date publishDate;
    private Integer totalHours;
    private String instructor;

    public UserCourses(Course studentCourses) {
        if (studentCourses != null) {
            this.name = studentCourses.getName();
            this.description = studentCourses.getDescription();
            this.publishDate = studentCourses.getPublishDate();
            this.totalHours = studentCourses.getTotalHours();
            this.instructor = studentCourses.getInstructor();
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public Integer getTotalHours() {
        return totalHours;
    }

    public String getInstructor() {
        return instructor;
    }

}
