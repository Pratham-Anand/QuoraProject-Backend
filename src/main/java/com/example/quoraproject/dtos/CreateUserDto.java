package com.example.quoraproject.dtos;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDto {

    @NotBlank(message="username is required")
    @Size(min=3)
    private String username;

    @Size(max=500)
    private String bio;

    @NotBlank(message="email is required")
    @Email(message="Invalid email format")
    private String email;

}
