package com.example.esde.views.task3;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StudentEntity {

    @Id
    private Long id;

    // TODO: Add some validation annotations here that make sense for this property
    // You can take a look at https://www.baeldung.com/java-validation for some inspiration
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
