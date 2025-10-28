package com.school.manageschool;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import com.school.manageschool.subject;
/*
   Teacher entity:
   Each teacher can handle multiple subjects and classes.
   I used two mapping tables (teacher_subject, teacher_class)
   instead of JSON arrays this keep the database  easier to query later for dashboard.
*/

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contactDetails;

    @ManyToMany
    @JoinTable(
            name = "teacher_sub",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<subject> subjects = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "teacher_class",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "class_id")
    )
    private Set<ClassInfo> classes = new HashSet<>();

    // Constructors
    public Teacher() {
    }

    public Teacher(String name, String contactDetails) {
        this.name = name;
        this.contactDetails = contactDetails;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public Set<subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<subject> subjects) {
        this.subjects = subjects;
    }

    public Set<ClassInfo> getClasses() {
        return classes;
    }

    public void setClasses(Set<ClassInfo> classes) {
        this.classes = classes;
    }
}
