package com.example.jparelation.Controller;

import com.example.jparelation.Model.Teacher;
import com.example.jparelation.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getTeachers() {
        return ResponseEntity.status(200).body(teacherService.getAllTeachers());
    }
    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("teacher added successfully");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @Valid @RequestBody Teacher teacher){
        teacherService.updateTeacher(teacher, id);
        return ResponseEntity.status(200).body("teacher updated successfully");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("teacher deleted successfully");
    }

    @GetMapping("/get-teacher-details/{id}")
    public ResponseEntity getTeacherById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(teacherService.getTeacherDetails(id));
}

    @GetMapping("/get-teacher-name/{id}")
    public ResponseEntity  getTeacherByName(@PathVariable Integer id){
        return ResponseEntity.status(200).body(teacherService.getTeacherNameByCourseId(id));
    }}





