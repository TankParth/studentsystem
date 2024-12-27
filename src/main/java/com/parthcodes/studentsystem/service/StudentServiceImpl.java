package com.parthcodes.studentsystem.service;

import com.parthcodes.studentsystem.model.Student;
import com.parthcodes.studentsystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

//import java.util.List;
@Service
public class StudentServiceImpl implements StudentService  {


//    private StudentRepository studentRepository
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findStudentById(int id) {
        return studentRepository.findById(id);
    }

//    @Override
//    public Student updateStudentdata(int id, Student newStudent) {
//        return null;
//    }

//    @Override
//    public Optional<Student> deleteStudentById(int id) {
//        return studentRepository.deleteById(id);
//    }


    @Override
    public void deleteStudentById(int id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student with ID " + id + " not found");
        }
        studentRepository.deleteById(id);
    }
}
