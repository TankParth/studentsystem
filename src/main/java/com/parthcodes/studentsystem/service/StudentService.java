package com.parthcodes.studentsystem.service;
import java.util.List;
import java.util.Optional;

import com.parthcodes.studentsystem.model.Student;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public Optional<Student> findStudentById(int id);
//    public Student updateStudentdata(int id, Student newStudent);
    public void deleteStudentById(int id);
    
}