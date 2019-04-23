package com.mx.controller;

import com.mx.bean.User;
import com.mx.mapper.TeacherMapper;
import com.mx.mapper.UserMapper;
import com.mx.service.ExamService;
import com.mx.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by zjt on 2019/2/12.
 */
@Controller
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.mx.mapper"})
public class JumpController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    ExamService examService;

    //@ResponseBody
    @RequestMapping("/test")
    public String test(){
        User admin = userMapper.findUserByName("admin");

        return "dashboard";
    }


    @RequestMapping("/")
    public String test1(){
        return "login";
    }

    @RequestMapping("/welcome")
    public String welcome(Model model) {
        int i = teacherService.selectTeacherCount();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(new Date());
        int examCount = examService.selectExamByDate(date);
        model.addAttribute("examCount",examCount);
        model.addAttribute("tc",i);
        return "welcome";
    }

    @GetMapping("/userrole")
    public String userRole(){
        return "user/admin-role";
    }
}
