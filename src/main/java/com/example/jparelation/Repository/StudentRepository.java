package com.example.jparelation.Repository;

import com.example.jparelation.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByStudentId(Integer studentId);

}
