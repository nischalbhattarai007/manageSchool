package com.school.manageschool;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    @Column(name = "classNumber")
    private String classNumber;
    @NotBlank
    @Column(name = "section")
    private String section;
    @NotBlank
    @Column(name = "rollNumber")
    private String rollNumber;
    @NotBlank
    @Column(name = "contactDetails")
    private String contactDetails;
    public Student() {
    }
    public Student(String name, String classNumber, String section, String rollNumber, String contactDetails) {
        this.name = name;
        this.classNumber = classNumber;
        this.section = section;
        this.rollNumber = rollNumber;
        this.contactDetails = contactDetails;
    }
    // Get amd set method
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getClassNumber()
    {
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
    public String getRollNumber()
    {
        return rollNumber;
    }
    public void setRollNumber(String rollNumber)
    {
        this.rollNumber = rollNumber;
    }
    public String getContactDetails() {
        return contactDetails;
    }
    public void setContactDetails(String contactDetails)
    {
        this.contactDetails = contactDetails;
    }
}
