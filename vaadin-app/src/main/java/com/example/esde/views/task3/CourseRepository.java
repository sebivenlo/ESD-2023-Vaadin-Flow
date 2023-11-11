package com.example.esde.views.task3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

    @Query("select c from CourseEntity c " +
            "where lower(c.shortName) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(c.longName) like lower(concat('%', :searchTerm, '%'))")
    List<CourseEntity> search(@Param("searchTerm") String searchTerm);

}
