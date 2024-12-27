package com.parthcodes.studentsystem.repository;

import com.parthcodes.studentsystem.model.Student;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    
//    here the Jpa repository will provide us all the available methods for this project that we can access
//    and can create REST API for them

//    and the <Student ,Integer> : here student defines  about the student class in the "Model" package and
//    the Integer defines the Integer data type of the Id which is given the same model.student class.
}
