package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

/**
 *
 * @author david
 */
@Entity
public class Course implements Serializable {
//    Course name, description, publish date, last updated, total hours ,instructor

    @Id
    @SequenceGenerator(name = "c_generator", sequenceName = "c_sequence", initialValue = 1)
    @GeneratedValue(generator = "c_generator")
    private Integer id;
    private String name;
    private String description;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date publishDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastUpdaDate;
    private Integer totalHours;
    private String instructor;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            }, mappedBy = "studentCourses")
    private Set<Student> registeredSudents;

    public Course() {
    }

    public Course(String name, String description, Date publishDate, Integer totalHours, String instructor) {
        this.name = name;
        this.description = description;
        this.publishDate = publishDate;
        this.totalHours = totalHours;
        this.instructor = instructor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Date getLastUpdaDate() {
        return lastUpdaDate;
    }

    public void setLastUpdaDate(Date lastUpdaDate) {
        this.lastUpdaDate = lastUpdaDate;
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

    public Set<Student> getRegisteredSudents() {
        return registeredSudents;
    }

    public void setRegisteredSudents(Set<Student> registeredSudents) {
        this.registeredSudents = registeredSudents;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Course other = (Course) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
