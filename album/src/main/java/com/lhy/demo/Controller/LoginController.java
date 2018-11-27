package com.lhy.demo.Controller;

import com.lhy.demo.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by pc on 2018/9/4.
 */
@Controller
@RequestMapping(value = "/album")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping(value = "/")
    public String ToLogin(){
        return "login";
    }

    @PostMapping(value = "/login")
    public String DoLogin(HttpServletRequest request, HttpSession session){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(loginService.checkPass(username, password) == true) {
            session.setAttribute("user", loginService.getUserId(username));
            return "redirect:/album/home";
        }
        else {
            session.setAttribute("fail", "用户名或密码错误!");
            return "redirect:/album/";
        }
    }

    @GetMapping(value = "/register")
    public String ToRegister(){
        return "register";
    }

    @PostMapping(value = "/doregister")
    public String DoRegister(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (loginService.addUser(username, password) == true)
            return "login";
        return "register";
    }
}
