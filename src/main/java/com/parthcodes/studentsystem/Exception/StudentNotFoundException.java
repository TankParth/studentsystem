package com.parthcodes.studentsystem.Exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(int id){
        super("Student with id:"+id+" is not found");
    }
}
