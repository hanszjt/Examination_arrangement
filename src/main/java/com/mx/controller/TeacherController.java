package com.mx.controller;

import com.github.pagehelper.PageInfo;
import com.mx.bean.Teacher;
import com.mx.service.TeacherService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mx on 2019/2/14.
 */
@Controller
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    /**
     * 进入教师管理界面
     * @param model
     * @return
     */
    @GetMapping("/teachers")
    public String teacherList(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo , @RequestParam(value = "pageSize",defaultValue = "10") int pageSize , Model model){
        PageInfo<Teacher> pageInfo = teacherService.selectTeacher(pageNo,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("teacherCount",teacherService.selectTeacherCount());
        return "teacher/member-list";
    }

    /**
     * 通过教师姓名搜索教师信息
     * @param pageNo
     * @param pageSize
     * @param tname
     * @param model
     * @return
     */
    @PostMapping("/teacher/search")
    public String searchTeacher(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo ,
                                @RequestParam(value = "pageSize",defaultValue = "10") int pageSize ,
                                @RequestParam("tname") String tname,
                                Model model){
        PageInfo<Teacher> pageInfo = teacherService.selectTeacherByName(pageNo,pageSize,tname);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("teacherCount",pageInfo.getList().size());
        return "teacher/member-list";
    }

    /**
     * 进入添加教师页面
     * @return
     */
    @GetMapping("/teacher")
    public String toAddPage(){
        return "teacher/member-add";
    }

    /**
     * 添加教师逻辑
     * @param teacher
     * @return
     */
    @ResponseBody
    @PostMapping("/teacher")
    public String addTeacher(Teacher teacher){
        teacherService.addTeacher(teacher);
        return "success";
    }

    /**
     * 通过教师id删除教师
     * @param id
     * @return
     */
    @ResponseBody
    @DeleteMapping("/teacher/{id}")
    public String deleteTeacher(@PathVariable("id") int id){
        teacherService.removeTeacher(id);
        return "success";
    }

    /**
     * 通过id查询教师
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/teacher/{id}")
    public String toUpdatePage(@PathVariable("id")int id,
                                Model model){
        Teacher teacher = teacherService.selectTeacherById(id);
        model.addAttribute("teacher",teacher);
        return "teacher/member-edit";
    }


    /**
     * 修改教师
     * @param teacher
     * @return
     */
    @ResponseBody
    @PutMapping("/teacher")
    public String UpdateTeacher(Teacher teacher){
        teacherService.updateTeacher(teacher);
        return "success";
    }


    /**
     * 批量删除教师
     * @param data
     * @return
     */
    @ResponseBody
    @PostMapping("/dteachers")
    public Map<String , Object> deleteTeacherByIds(@RequestBody List<Integer> data){
        Map<String,Object> map = new HashMap<>();
        int i = teacherService.deleteTeacherByIds(data);
        map.put("count",i);
        return map;
    }

}
