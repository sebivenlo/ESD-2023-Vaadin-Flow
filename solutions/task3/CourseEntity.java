package com.example.esde.views.task3;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Entity
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private long id;

    @NotEmpty
    private String shortName;

    @NotEmpty
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
