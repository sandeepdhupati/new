package com.example.school.repository;
import java.util.*;
import com.example.student.model.Student;

public interface StudentRepository{
    
    ArrayList<Student> getStudents();
    Student addStudent(Student student);
    int addMultipleStudents(List<Student> students);
    Student getStudentById(int studentId);
    Student updateStudent(Student student);
    void deleteStudent(int studentId);
}
