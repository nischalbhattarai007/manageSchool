package com.school.manageschool.service;
import com.school.manageschool.Student;
import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getAllStudents();

    Optional<Student> getStudentById(Long id);

    Student saveStudent(Student student);

    Student updateStudent(Long id, Student student);

    boolean deleteStudent(Long id);
}
