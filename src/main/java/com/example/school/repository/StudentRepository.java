package com.example.school.repository;

import com.example.school.model.Student;

import java.util.ArrayList;

public interface StudentRepository {
    ArrayList<Student> getStudents();
    Student getStudentById(int studentId);
    Student addSingleStudent(Student student);
    String addMultipleStudents(ArrayList<Student> studentsList);
    Student updateStudent(int studentId, Student student);
    void deleteStudent(int studentId);
}
