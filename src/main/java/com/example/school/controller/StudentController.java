package com.example.school.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentH2Service studentService;
    
    @Autowired
    public StudentController(StudentH2Service studentService) {
        this.studentService = studentService;
    }
    
    @GetMapping
    public ArrayList<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student addedStudent = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedStudent);
    }
    
    @PostMapping("/bulk")
    public String addStudents(@RequestBody ArrayList<Student> students) {
        int numAdded = studentService.addStudents(students);
        return "Added " + numAdded + " students.";
    }
    
    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable int studentId) {
        Student student = studentService.getStudentById(studentId);
        if (student == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
        }
        return ResponseEntity.ok(student);
    }
    
    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable int studentId, @RequestBody Student student) {
        student.setStudentId(studentId);
        studentService.updateStudent(student);
        return ResponseEntity.ok(student);
    }
    
    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.noContent().build();
    }
}