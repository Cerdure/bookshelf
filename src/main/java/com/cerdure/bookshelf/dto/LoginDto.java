package com.cerdure.bookshelf.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginDto {
    @NotBlank
    private String phone;
    @NotBlank
    private String pw;
}

