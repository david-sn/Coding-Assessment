package com.example.demo.dto;

import javax.validation.constraints.NotNull;

/**
 *
 * @author david
 */
public class RegisterDTO {

    @NotNull
    private Integer courseId;
    @NotNull
    private Integer studentId;

    public RegisterDTO() {
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

}
