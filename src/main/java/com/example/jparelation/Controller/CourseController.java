package com.example.jparelation.Controller;

import com.example.jparelation.Model.Course;
import com.example.jparelation.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/coures")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getCourse() {
        return ResponseEntity.status(200).body(courseService.getAllCourses());

    }

    @PutMapping("/assing/{courseId}/{teacherId}")
    public ResponseEntity assingCourse(@PathVariable Integer courseId, @PathVariable Integer teacherId) {
        courseService.assingTeacherToCourse(courseId, teacherId);
        return ResponseEntity.status(200).body("assing teacher to course");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @RequestBody @Valid Course course) {
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body("update teacher");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("delete teacher");
    }
}
