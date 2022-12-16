package com.cerdure.bookshelf.web.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginForm {

    @NotBlank
    private String phone;

    @NotBlank
    private String pw;
}

