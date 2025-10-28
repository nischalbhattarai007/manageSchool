package com.school.manageschool.controller;

import com.school.manageschool.Teacher;
import com.school.manageschool.repository.TeacherRepository;
import com.school.manageschool.repository.SubjectRepository;
import com.school.manageschool.repository.ClassInfoRepository;
import com.school.manageschool.subject;
import com.school.manageschool.ClassInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private ClassInfoRepository classInfoRepository;
    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return ResponseEntity.ok(teachers);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getTeacherById(@PathVariable Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (teacher.isPresent()) {
            return ResponseEntity.ok(teacher.get());
        }
        return ResponseEntity.status(404).body("Teacher not found");
    }
    @PostMapping
    public ResponseEntity<?> createTeacher(@RequestHeader(value = "X-Role", required = false) String role,
                                           @RequestBody Teacher teacher) {
        if (role == null || !role.equalsIgnoreCase("teacher")) {
            return ResponseEntity.status(403).body("Access denied: Only teachers can add new teacher records");
        }
        Teacher saved = teacherRepository.save(teacher);
        return ResponseEntity.ok(saved);
    }
    @PostMapping("/{id}/assign")
    public ResponseEntity<?> assignSubjectAndClass(@PathVariable Long id,
                                                   @RequestParam Long subjectId,
                                                   @RequestParam Long classId) {
        Optional<Teacher> teacherOpt = teacherRepository.findById(id);
        Optional<subject> subjectOpt = subjectRepository.findById(subjectId);
        Optional<ClassInfo> classOpt = classInfoRepository.findById(classId);
        if (teacherOpt.isEmpty() || subjectOpt.isEmpty() || classOpt.isEmpty()) {
            return ResponseEntity.status(404).body("Teacher, Subject, or Class not found");
        }
        Teacher teacher = teacherOpt.get();
        teacher.getSubjects().add(subjectOpt.get());
        teacher.getClasses().add(classOpt.get());
        teacherRepository.save(teacher);
        return ResponseEntity.ok("Subject and class assigned successfully");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeacher(@RequestHeader(value = "X-Role", required = false) String role,
                                           @PathVariable Long id) {
        if (role == null || !role.equalsIgnoreCase("teacher")) {
            return ResponseEntity.status(403).body("Access denied: Only teachers can delete");
        }
        if (teacherRepository.existsById(id)) {
            teacherRepository.deleteById(id);
            return ResponseEntity.ok("Teacher deleted successfully");
        } else {
            return ResponseEntity.status(404).body("Teacher not found");
        }
    }
}
