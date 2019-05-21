package com.example.demo.service.impl;

import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.IRegistration;
import com.example.demo.service.mapper.UserCourses;
import com.example.demo.utile.EResponseStatus;
import com.example.demo.utile.GeneralResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author david
 */
@Service
public class RegistrationService implements IRegistration {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public GeneralResponse<Boolean> registerInCourse(Integer courseId, Integer studentId) {
        Optional<Course> courseToRegisterd = courseRepository.findById(courseId);
        Optional<Student> userToJoin = studentRepository.findById(studentId);

        if (courseToRegisterd.isPresent() && userToJoin.isPresent()) {
            Course courseDB = courseToRegisterd.get();
            Student studentDB = userToJoin.get();

            boolean isAddedStudent = courseDB.getRegisteredSudents().add(studentDB);
            boolean isAddedCourse = studentDB.getStudentCourses().add(courseDB);
            if (isAddedStudent && isAddedCourse) {
                Course saveAndFlush = courseRepository.saveAndFlush(courseDB);
                Student saveAndFlush1 = studentRepository.saveAndFlush(studentDB);
                return new GeneralResponse<>(EResponseStatus.OK, isAddedStudent && isAddedCourse);
            } else {
                return new GeneralResponse<>(EResponseStatus.DATA_DUBLICATE, "user Joined Before");
            }

        } else {
            return new GeneralResponse<>(EResponseStatus.NOT_FOUND, "user/course not found");
        }

    }

    @Override
    public GeneralResponse<Boolean> unRegisterInCourse(Integer courseId, Integer StudentId) {
        Optional<Course> courseToRegisterd = courseRepository.findById(courseId);
        Optional<Student> userToJoin = studentRepository.findById(StudentId);

        if (courseToRegisterd.isPresent() && userToJoin.isPresent()) {
            Course courseDB = courseToRegisterd.get();
            Student studentDB = userToJoin.get();

            boolean isRemovedStudent = courseDB.getRegisteredSudents().remove(studentDB);
            boolean isRemovedCourse = studentDB.getStudentCourses().remove(courseDB);

            if (isRemovedStudent && isRemovedCourse) {
                courseRepository.save(courseDB);
                studentRepository.save(studentDB);
                return new GeneralResponse<>(EResponseStatus.OK, isRemovedStudent && isRemovedCourse);
            } else {
                return new GeneralResponse<>(EResponseStatus.DATA_DUBLICATE, "user Joined Before");
            }

        } else {
            return new GeneralResponse<>(EResponseStatus.NOT_FOUND, "user/course not found");
        }
    }

    @Override
    public GeneralResponse<List<UserCourses>> listAllCoursesStudentRegistered(Integer studentId) {
        Optional<Student> studentDB = studentRepository.findById(studentId);
        if (studentDB.isPresent()) {
            Set<Course> studentCourses = studentDB.get().getStudentCourses();

            List<UserCourses> response = new ArrayList<>();
            studentCourses.forEach(c -> {
                UserCourses courseTemplate = new UserCourses(c);
                response.add(courseTemplate);
            });

            return new GeneralResponse<>(EResponseStatus.OK, response);
        } else {
            return new GeneralResponse<>(EResponseStatus.NOT_FOUND);
        }
    }

}
