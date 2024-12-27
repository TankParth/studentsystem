package com.parthcodes.studentsystem.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@ControllerAdvice
public class StudentNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(StudentNotFoundException.class)
    public Map<String,String> exeptionhandler(StudentNotFoundException exception){
        Map<String,String> errorMap= new HashMap<>();
        errorMap.put("Error Message", exception.getMessage());
        return errorMap;
    }
}
