package com.cydeo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResponseWrapper {

    private String message;
    private boolean success;
    private Integer code;
    private Object data;

}
