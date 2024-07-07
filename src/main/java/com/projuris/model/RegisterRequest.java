package com.projuris.model;



import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    @NotBlank
    private String userName;

    @NotBlank
    private String email;

    @NotBlank
    private String password;
}