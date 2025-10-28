package com.school.manageschool.controller;

import com.school.manageschool.Student;
import com.school.manageschool.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
/*
   StudentController handles all the API requests
   related to students  fetching, creating, updating, and deleting.
   Header check for 'X-Role: teacher' ensures only teachers can perform some actions.
*/
@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.status(404).body("Student not found");
        }
    }
    @PostMapping
    public ResponseEntity<?> createStudent(@RequestHeader(value = "X-Role", required = false) String role,
                                           @RequestBody Student student) {
        // Only teachers can add students
        if (role == null || !role.equalsIgnoreCase("teacher")) {
            return ResponseEntity.status(403).body("Access denied: Only teachers can add students");
        }
        Student savedStudent = studentService.saveStudent(student);
        return ResponseEntity.ok(savedStudent);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateStudent(@RequestHeader(value = "X-Role", required = false) String role,
                                           @PathVariable Long id,
                                           @RequestBody Student updatedStudent) {
        // Only teachers can update
        if (role == null || !role.equalsIgnoreCase("teacher")) {
            return ResponseEntity.status(403).body("Access denied: Only teachers can update students");
        }
        Student updated = studentService.updateStudent(id, updatedStudent);
        if (updated == null) {
            return ResponseEntity.status(404).body("Student not found");
        }
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@RequestHeader(value = "X-Role", required = false) String role,
                                           @PathVariable Long id) {
        // Only teachers can delete
        if (role == null || !role.equalsIgnoreCase("teacher")) {
            return ResponseEntity.status(403).body("Access denied: Only teachers can delete students");
        }
        boolean deleted = studentService.deleteStudent(id);
        if (deleted) {
            return ResponseEntity.ok("Student deleted successfully");
        } else {
            return ResponseEntity.status(404).body("Student not found");
        }
    }
}
