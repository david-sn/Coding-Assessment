package com.example.demo.dto;

import java.util.Date;
import javax.validation.constraints.NotNull;

/**
 *
 * @author david
 */
public class CourseDTO {

    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private Date publishDate;
    @NotNull
    private Integer totalHours;
    @NotNull
    private String instructor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(Integer totalHours) {
        this.totalHours = totalHours;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

}
