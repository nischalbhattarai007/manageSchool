package com.school.manageschool;
import jakarta.persistence.*;

@Entity
@Table(name = "subjects")
public class subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Constructors
    public subject() {
    }

    public subject(String name) {
        this.name = name;
    }

    // Getters and Setters
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
