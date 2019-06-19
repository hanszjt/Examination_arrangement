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

    /**
     * 登录判断逻辑，检查用户名密码以及用户的权限
     * @param username
     * @param password
     * @param map
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/checkLogin")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map , HttpSession httpSession){
        //判断用户名以及密码是否正确
        User user = userService.checkUser(username, password);
        if(user != null){
            //先判断是否被停用账户，0为启用，1为停用
            if (user.getStatus().equals("0")) {
                httpSession.setAttribute("loginUser", username);
                //判断是否为管理员权限 1为老师，0为管理员
                if (user.getRole().equals("1")){
                    return "redirect:/home.html";
                }
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

    /**
     * 退出当前用户，切换账户
     * @param httpSession
     * @return
     */
    @GetMapping("/exitUser")
    public String exitUser(HttpSession httpSession){
        httpSession.setAttribute("loginUser",null);
        return "login";
    }
}
