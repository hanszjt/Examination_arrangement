package com.mx.controller;

import com.mx.bean.Teacher;
import com.mx.bean.User;
import com.mx.mapper.TeacherMapper;
import com.mx.mapper.UserMapper;
import com.mx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by zjt on 2019/2/12.
 */
@Controller()
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    TeacherMapper teacherMapper;


    @PostMapping(value = "/checkLogin")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map , HttpSession httpSession){
        User user = userService.checkUser(username, password);
        if(user != null){
            if (user.getRole().equals("1")){
                httpSession.setAttribute("loginUser", username);
                return "redirect:/home.html";
            }
            if (user.getStatus().equals("0")) {
                httpSession.setAttribute("loginUser", username);
                return "redirect:/main.html";
            }else {
                map.put("msg","用户被停用，请联系管理员");
                return "login";
            }
        }else{
            map.put("msg","用户名或密码错误");
            return "login";
        }

    }


    @GetMapping("/exitUser")
    public String exitUser(HttpSession httpSession){
        httpSession.setAttribute("loginUser",null);
        return "login";
    }
}
