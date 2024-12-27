package com.parthcodes.studentsystem.controller;

import com.parthcodes.studentsystem.Exception.StudentNotFoundException;
import com.parthcodes.studentsystem.model.Student;
import com.parthcodes.studentsystem.service.StudentService;
import org.hibernate.jdbc.Expectation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.Map;

import java.awt.*;
import java.util.List;


//here we are going to provide the API path for our project

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String add(@RequestBody Student student){
        studentService.saveStudent(student);
        return "New Student is Added";
    }
    @PostMapping("/getAll")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/get/{id}")
    public Student getstudent(@PathVariable int id){
            if ((studentService.getAllStudents().get(id+1))==null) {
            throw new StudentNotFoundException(id);
        }
        return studentService.getAllStudents().get(id+1);
//                .orElseThrow(()-> new StudentNotFoundException(id));
    }

//    @PutMapping("/student/update/{id}")
//    public Student updateStudent(@RequestBody Student newstudent, @PathVariable int id){
//        Student student;
//        studentService.getAllStudents().get(id+1).map(student -> {
//                    student.setName(newstudent.getName());
//                    student.setAddress(newstudent.getAddress());
//                });
//    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@RequestBody Student newStudent, @PathVariable int id) {
        id=id+1;
        Optional<Student> optionalStudent = studentService.findStudentById(id);

        if (optionalStudent.isEmpty()) {
            throw new StudentNotFoundException(id);
        }

        // Update the student details
        Student existingStudent = optionalStudent.get();
        existingStudent.setName(newStudent.getName());
        existingStudent.setAddress(newStudent.getAddress());

        // Save the updated student back to the database
        studentService.saveStudent(existingStudent);

        return existingStudent;
    }


//    @PutMapping("/dataupdate/{id}")
//    public Student updateStudent(int id, Student newStudent) {
//        return studentService.findStudentById(id).map(student -> {
//            student.setName(newStudent.getName());
//            student.setAddress(newStudent.getAddress());
//            return studentService.saveStudent(student); // Save updated entity
//        }).orElseThrow(() -> new RuntimeException("Student with ID " + id + " not found"));
//    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudentById(id);
        return "Student with ID " + id + " has been deleted successfully";
    }
}
