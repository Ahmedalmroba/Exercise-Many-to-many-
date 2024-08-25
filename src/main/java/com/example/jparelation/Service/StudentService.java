package com.example.jparelation.Service;

import com.example.jparelation.ApiException.ApiException;
import com.example.jparelation.Model.Course;
import com.example.jparelation.Model.Student;
import com.example.jparelation.Repository.CourseRepository;
import com.example.jparelation.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
final StudentRepository studentRepository;
final CourseRepository courseRepository;

public List<Student> getAllStudents() {
    return studentRepository.findAll();
}

public void addStudent(Student student) {
    studentRepository.save(student);
}
public void updateStudent(Integer id,Student student) {
    Student stud = studentRepository.findByStudentId(id);
    if (stud == null) {
        throw new ApiException("student not found");

    }
    stud.setName(student.getName());
    stud.setAge(student.getAge());
    stud.setMajor(student.getMajor());
    studentRepository.save(stud);
}
public void deleteStudent(Integer id) {
    Student stud = studentRepository.findByStudentId(id);
    if (stud == null) {
        throw new ApiException("student not found");
    }
    studentRepository.delete(stud);
}

public void assignStudent(Integer studentId, Integer courseId) {
    Student stud = studentRepository.findByStudentId(studentId);
    Course course = courseRepository.findByCourseId(courseId);
    if (stud == null || course == null) {
        throw new ApiException("student not found");
    }
    course.getStudents().add(stud);
    stud.getCourses().add(course);
    studentRepository.save(stud);
    courseRepository.save(course);
}

   public void changeStudentMajor(Integer id, String major) {
       Student stud = studentRepository.findByStudentId(id);
       if (stud == null) {
           throw new ApiException("student not found");
       }
       stud.setMajor(major);
       for (Course course : stud.getCourses()) {
           course.getStudents().remove(stud);
       }
       stud.getCourses().removeAll(stud.getCourses());
       studentRepository.save(stud);

   }}




