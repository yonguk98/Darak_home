package com.darak.homepage.controller;

import com.darak.homepage.domain.Users;
import com.darak.homepage.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
//@CrossOrigin(origins = "http://localhost:3000/user/join")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){this.memberService = memberService;}

    @GetMapping("/users/join")
    public String createForm(){return "users/createUserForm";}

    @PostMapping("/users/join")
    public String create(MemberForm form){
        Users users = new Users();
        users.setId(form.getId());
        users.setPassword(form.getPassword());
        users.setName(form.getName());

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
            return true;
        }
        return false;
    }
    @ResponseBody
    @PostMapping ("/api")
    public Map<String, String> api(@RequestBody Map<String, String> param){
        System.out.println(param);
        return param;
    }
}
