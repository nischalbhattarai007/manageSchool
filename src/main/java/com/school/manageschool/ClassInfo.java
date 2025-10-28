package com.school.manageschool;
import jakarta.persistence.*;
@Entity
@Table(name = "classes")
public class ClassInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String classNumber;
    private String section;

    // Constructors
    public ClassInfo() {
    }

    public ClassInfo(String classNumber, String section) {
        this.classNumber = classNumber;
        this.section = section;
    }
    // Get and set methjod
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public String getClassNumber() {
        return classNumber;
    }
    public void setClassNumber(String classNumber)
    {
        this.classNumber = classNumber;
    }
    public String getSection()
    {
        return section;
    }
    public void setSection(String section)
    {
        this.section = section;
    }
}
