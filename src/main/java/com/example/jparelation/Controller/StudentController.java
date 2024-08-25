package com.example.jparelation.Controller;

import com.example.jparelation.Model.Student;
import com.example.jparelation.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity GetStudent() {
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody@Valid Student student) {
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("Student added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id,@Valid @RequestBody Student student) {
        studentService.updateStudent(id, student);
        return ResponseEntity.status(200).body("Student updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("Student deleted");
    }
    @GetMapping("/stude-assign/{studentId}/{courseId}")
    public ResponseEntity assignMerchant(@PathVariable Integer studentId,@PathVariable Integer courseId ) {
        studentService.assignStudent(studentId,courseId);
        return ResponseEntity.status(200).body("assigned merchant");
    }
    @PutMapping("/{id}/change-major")
    public ResponseEntity changeStudentMajor(@PathVariable Integer id, @RequestBody String major) {
         studentService.changeStudentMajor(id, major);
         return ResponseEntity.status(200).body("student major changed");

}}
