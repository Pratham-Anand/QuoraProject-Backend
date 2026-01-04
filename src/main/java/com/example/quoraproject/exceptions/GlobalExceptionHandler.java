package com.example.quoraproject.exceptions;

import com.example.quoraproject.dtos.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //to handle the custom exception
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<Object>> handleRuntimeException(RuntimeException ex){
        ApiResponse<Object> response=new ApiResponse<>(false,ex.getMessage(),null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    //to handle generic exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleException(Exception ex){

        ApiResponse<Object> response = new ApiResponse<>(false,"something went wrong",null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

}
