package com.example.esde.views.task3;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public SchoolService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public void addCourse(CourseEntity course) {
        courseRepository.save(course);
    }

    public List<CourseEntity> getAllCourses() {
        return courseRepository.findAll();
    }

    public void addStudent(StudentEntity student) {
        studentRepository.save(student);
    }

    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    public CourseEntity getCourseById(Long id) {
        return this.courseRepository.getReferenceById(id);
    }

    public void updateCourse(CourseEntity course) {
        CourseEntity entity = this.courseRepository.getReferenceById(course.getId());
        entity.setLongName(course.getLongName());
        entity.setShortName(course.getShortName());
        entity.setStudents(course.getStudents());

        this.courseRepository.saveAndFlush(entity);
    }

}
