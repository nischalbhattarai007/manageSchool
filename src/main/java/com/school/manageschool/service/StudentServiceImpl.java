package com.school.manageschool.service;

import com.school.manageschool.Student;
import com.school.manageschool.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student updatedStudent) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            if (updatedStudent.getName() != null)
                student.setName(updatedStudent.getName());
            if (updatedStudent.getClassNumber() != null)
                student.setClassNumber(updatedStudent.getClassNumber());
            if (updatedStudent.getSection() != null)
                student.setSection(updatedStudent.getSection());
            if (updatedStudent.getRollNumber() != null)
                student.setRollNumber(updatedStudent.getRollNumber());
            if (updatedStudent.getContactDetails() != null)
                student.setContactDetails(updatedStudent.getContactDetails());

            return studentRepository.save(student);
        } else {
            return null; // Student not found
        }
    }
    @Override
    public boolean deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
