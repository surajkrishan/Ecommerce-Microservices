package com.meru.offerservice.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CustomErrorDetails {

    private Date timestamp;
    private String message;
    private String errordetails;

}
