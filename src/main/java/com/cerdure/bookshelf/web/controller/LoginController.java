package com.cerdure.bookshelf.web.controller;

import com.cerdure.bookshelf.service.LoginServiceImpl;
import com.cerdure.bookshelf.dto.LoginDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginServiceImpl loginService;

    @GetMapping("/login")
    public String login(@Valid @ModelAttribute("loginDto") LoginDto loginDto, BindingResult bindingResult){
        return "login";
    }

}
