package com.cydeo.controller;

import com.cydeo.dto.ResponseWrapper;
import com.cydeo.service.ParentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/parent")
public class ParentController {

    private final ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

     /*
           Endpoint: /api/v1/parent
           HTTP Status Code: 200
           Custom Response Header: "Parents", "Returned"

           JSON Response Body:
           "success": true
           "message": "Parents are successfully retrieved."
           "code":200
           "data":<parents data>
     */


    @GetMapping
    public ResponseEntity<ResponseWrapper> getParentList(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Parents","Returned")
                .body(ResponseWrapper.builder()
                        .success(true)
                        .message("Parents are successfully retrieved.")
                        .code(HttpStatus.OK.value())
                        .data(parentService.findAll()).build());
    }

}
