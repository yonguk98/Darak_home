package com.darak.homepage.controller;

import com.darak.homepage.domain.User;
import com.darak.homepage.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

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
        User user = new User();
        user.setId(form.getId());
        user.setPassword(form.getPassword());
        user.setName(form.getName());

        memberService.join(user);

        return "redirect:/";
    }

    @GetMapping("/users")
    public String list(Model model){
        List<User> users = memberService.findMembers();
        model.addAttribute("users", users);
        return "users/userList";
    }
    @ResponseBody
    @PostMapping("/users/login")
    public boolean login(@RequestBody Map<String,String> param){
        if(memberService.userCheckById(param.get("id"))
                && memberService.userCheckByPassword(param.get("pwd"))){
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