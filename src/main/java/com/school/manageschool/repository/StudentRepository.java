package com.school.manageschool.repository;
import com.school.manageschool.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByClassNumberAndSection(String classNumber, String section);
    long countByClassNumberAndSection(String classNumber, String section);
}

