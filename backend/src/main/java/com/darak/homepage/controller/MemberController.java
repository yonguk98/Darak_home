package com.darak.homepage.controller;

import com.darak.homepage.domain.Users;
import com.darak.homepage.service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
//@CrossOrigin(origins = "http://localhost:3000/user/join")
public class MemberController {

    private final MemberService memberService;
    private final HttpServletResponse response;
    private final HttpServletRequest request;

    @Autowired
    public MemberController(MemberService memberService, HttpServletResponse response, HttpServletRequest request){
        this.memberService = memberService;
        this.response = response;
        this.request = request;
    }

    @GetMapping("/users/join")
    public String createForm(){return "users/createUserForm";}

    @ResponseBody
    @PostMapping("/users/join")
    public String create(@RequestBody Map<String,String> param){
        Users users = new Users();
        users.setId(param.get("id"));
        users.setPassword(param.get("pwd"));
        users.setName(param.get("name"));

        memberService.join(users);

        return "redirect:/";
    }

    @GetMapping("/users")
    public String list(Model model){
        List<Users> users = memberService.findMembers();
        model.addAttribute("users", users);
        return "users/userList";
    }
    @ResponseBody
    @PostMapping("/users/login")
    public boolean login(@RequestBody Map<String,String> param){
        if(memberService.login(param.get("id"),param.get("pwd"))){
            Cookie cookie = new Cookie("userId",param.get("id"));
            cookie.setMaxAge(60*60); // 1 hour
            cookie.setPath("/");
            response.addCookie(cookie);
            return true;
        }
        return false;
    }
    @ResponseBody
    @GetMapping("/users/logout")
    public boolean logout(@CookieValue(name = "userId") String cookieValue){
        if(cookieValue == null){return false;}

        Cookie cookie = new Cookie("userId",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return true;
    }
    @ResponseBody
    @PostMapping ("/api")
    public Map<String, String> api(@RequestBody Map<String, String> param){
        System.out.println(param);
        return param;
    }
}
