package com.example.school.model;1
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setStudentId(rs.getInt("studentId"));
        student.setStudentName(rs.getString("studentName"));
        student.setGender(rs.getString("gender"));
        student.setStandard(rs.getInt("standard"));
        return student;
    }
}
