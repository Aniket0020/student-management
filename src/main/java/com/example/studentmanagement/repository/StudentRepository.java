package com.example.studentmanagement.repository;

import com.example.studentmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE LOWER(s.stack) LIKE LOWER(CONCAT('%', :stack, '%'))")
    List<Student> findByStackIgnoreCase(@Param("stack") String stack);

    List<Student> findByNameIgnoreCase(String name);
    List<Student> findByCityIgnoreCase(String city);


}
