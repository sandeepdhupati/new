package com.example.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.school.model.Student;
import com.example.school.service.StudentH2Service;




@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.addStudent(student);
    }

    @PostMapping("/bulk")
    public String addMultipleStudents(@RequestBody List<Student> students) {
        int addedCount = studentRepository.addMultipleStudents(students);
        return addedCount + " students added.";
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        Student student = studentRepository.getStudentById(studentId);
        if (student == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
        }
        return student;
    }

    @PutMapping("/{studentId}")
    public Student updateStudent(@PathVariable int studentId, @RequestBody Student student) {
        student.setStudentId(studentId);
        return studentRepository.updateStudent(student);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable int studentId) {
        studentRepository.deleteStudent(studentId);
    }
}
