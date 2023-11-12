package com.example.esde.views.task3;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // TODO: Add some validation annotations here that make sense for this property
    // You can take a look at https://www.baeldung.com/java-validation for some inspiration
    private String shortName;

    // TODO: Add some validation annotations here that make sense for this property
    // You can take a look at https://www.baeldung.com/java-validation for some inspiration
    private String longName;

    @OneToMany
    private Set<StudentEntity> students;

    public CourseEntity() {}

    public CourseEntity(String shortName, String longName) {
        this.shortName = shortName;
        this.longName = longName;
    }

    public long getId() {
        return id;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public Set<StudentEntity> getStudents() {
        return students;
    }

    public void addStudent(StudentEntity student) {
        this.students.add(student);
    }

    public void setStudents(Set<StudentEntity> students) {
        this.students = students;
    }

}
