package com.school.manageschool.controller;
import com.school.manageschool.repository.StudentRepository;
import com.school.manageschool.repository.TeacherRepository;
import com.school.manageschool.repository.SubjectRepository;
import com.school.manageschool.repository.ClassInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private ClassInfoRepository classRepository;
    @GetMapping
    public Map<String, Object> getDashboardData() {
        Map<String, Object> dashboard = new HashMap<>();
        dashboard.put("totalStudents", studentRepository.count());
        dashboard.put("totalTeachers", teacherRepository.count());
        dashboard.put("totalSubjects", subjectRepository.count());
        dashboard.put("totalClasses", classRepository.count());
        return dashboard;
    }
}
