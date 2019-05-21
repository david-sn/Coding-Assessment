package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author david
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByEmailOrUsername(String email, String username);

}
