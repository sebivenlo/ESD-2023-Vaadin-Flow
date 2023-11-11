package com.example.esde.views.task3;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class StudentEntity {

    // Maybe delete student entity and repository as task? 🤔
    @Id
    @Column(name = "student_id")
    private Long id;

    @NotEmpty
    private String fullName;

    public StudentEntity () {}

    public StudentEntity(Long id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
