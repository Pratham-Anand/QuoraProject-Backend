package com.example.quoraproject.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDto {

    private String username;
    private String bio;
    private String email;

}
