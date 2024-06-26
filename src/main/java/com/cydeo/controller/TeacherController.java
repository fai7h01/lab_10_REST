package com.cydeo.controller;

import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

         /*
           Endpoint: /api/v1/teacher

           JSON Response Body:
           <teachers data>
        */

    @GetMapping
    public List<TeacherDTO> getAllTeachers(){
        return teacherService.findAll();
    }

        /*
           Endpoint: /api/v1/teacher/{username}
           HTTP Status Code: 200

           JSON Response Body:
           "success": true
           "message": "Teacher is successfully retrieved."
           "code":200
           "data":<teacher data>
        */

    @GetMapping("/{username}")
    public ResponseEntity<ResponseWrapper> getTeacher(@PathVariable("username") String username){
        return ResponseEntity.ok(ResponseWrapper.builder()
                .success(true)
                .message("Teacher is successfully retrieved.")
                .code(HttpStatus.OK.value())
                .data(teacherService.findByUsername(username)).build());
    }

       /*
           Endpoint: /api/v1/teacher
           HTTP Status Code: 201
           Custom Response Header: "teacherUsername", <created username>

           JSON Response Body:
           "success": true
           "message": "Teacher is successfully created."
           "code":201
           "data":<created teacher data>
     */

    @PostMapping
    public ResponseEntity<ResponseWrapper> createTeacher(@RequestBody TeacherDTO teacherDTO){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("teacherUsername", teacherDTO.getUsername())
                .body(ResponseWrapper.builder()
                        .success(true)
                        .message("")
                        .code(HttpStatus.CREATED.value())
                        .data(teacherService.createTeacher(teacherDTO)).build());
    }

}
