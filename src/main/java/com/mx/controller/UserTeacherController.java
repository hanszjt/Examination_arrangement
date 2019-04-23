package com.mx.controller;

import com.github.pagehelper.PageInfo;
import com.mx.bean.Exam;
import com.mx.bean.Examsubject;
import com.mx.bean.Teacher;
import com.mx.service.ExamService;
import com.mx.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by mx on 2019/4/24.
 */
@Controller
public class UserTeacherController {

    @Autowired
    ExamService examService;

    @Autowired
    TeacherService teacherService;

    @GetMapping("/teachersearch")
    public String searchExamName(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo ,
                                 @RequestParam(value = "pageSize",defaultValue = "10") int pageSize ,
                                 @RequestParam("tname") String tname,
                                 Model model){

        PageInfo<Exam> pageInfo = examService.selectExamByName(pageNo,pageSize,teacherService.selectTeacherByTid(tname).getTname());
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("examCount",pageInfo.getTotal());
        model.addAttribute("serachname",tname);
        if (pageInfo.getList().size()==0){
            model.addAttribute("msg","您暂时无监考任务");
        }
        return "teacher";
    }
}
