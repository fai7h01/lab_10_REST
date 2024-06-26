package com.cydeo.service;

import com.cydeo.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    List<StudentDTO> findAll();

    StudentDTO createStudent(StudentDTO studentDTO);

}