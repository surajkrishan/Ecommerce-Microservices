package com.meru.productservice.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CustomErrorDetails {

    private Date timestamp;
    private String message;
    private String errorDetails;
}
