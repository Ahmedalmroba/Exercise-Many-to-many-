package com.example.jparelation.Repository;

import com.example.jparelation.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findByCourseId(Integer id);

}
