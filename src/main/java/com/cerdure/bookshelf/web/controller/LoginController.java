package com.cerdure.bookshelf.web.controller;

import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.service.LoginServiceImpl;
import com.cerdure.bookshelf.web.form.LoginForm;
import com.cerdure.bookshelf.web.session.SessionConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginServiceImpl loginService;

    @GetMapping("/login")
    public String login(@Valid @ModelAttribute("loginForm") LoginForm form, BindingResult bindingResult){
        return "login";
    }

//    @PostMapping("/login")
//    public String loginV4(@Valid @ModelAttribute("loginForm") LoginForm form, BindingResult bindingResult,
//                          @RequestParam(defaultValue = "/") String redirectURL,
//                          HttpServletRequest request) {
//
//        if (bindingResult.hasErrors()) {
//            return "login";
//        }
//
//        Member loginMember = loginService.login(form.getPhone(), form.getPw());
//
//        if (loginMember == null) {
//            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
//            return "login";
//        }
//
//        //로그인 성공 처리
//        //세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성
//        HttpSession session = request.getSession();
//        //세션에 로그인 회원 정보 보관
//        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
//
//        return "redirect:" + redirectURL;
//
//    }
}
