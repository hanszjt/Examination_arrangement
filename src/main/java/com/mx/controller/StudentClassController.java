package com.mx.controller;

import com.github.pagehelper.PageInfo;
import com.mx.bean.StudentClass;
import com.mx.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mx on 2019/2/28.
 */
@Controller
public class StudentClassController {
    
    @Autowired
    StudentClassService studentClassService;
    /**
     * 进入班级管理界面
     * @param model
     * @return
     */
    @GetMapping("/studentClasss")
    public String studentClassList(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo , @RequestParam(value = "pageSize",defaultValue = "10") int pageSize , Model model){
        PageInfo<StudentClass> pageInfo = studentClassService.selectStudentClass(pageNo,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("studentClassCount",studentClassService.selectStudentClassCount());
        return "studentClass/list";
    }

    /**
     * 通过班级名字搜索班级
     * @param pageNo
     * @param pageSize
     * @param classname
     * @param model
     * @return
     */
    @PostMapping("/studentClass/search")
    public String searchStudentClass(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo ,
                                    @RequestParam(value = "pageSize",defaultValue = "10") int pageSize ,
                                    @RequestParam("classname") String classname,
                                    Model model){
        PageInfo<StudentClass> pageInfo = studentClassService.selectStudentClassByName(pageNo,pageSize,classname);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("studentClassCount",pageInfo.getList().size());
        return "studentClass/list";
    }

    /**
     * 进入添加班级信息页面
     * @return
     */
    @GetMapping("/studentClass")
    public String toAddPage(){
        return "studentClass/add";
    }

    /**
     * 添加班级信息逻辑
     * @param studentClass
     * @return
     */
    @ResponseBody
    @PostMapping("/studentClass")
    public String addStudentClass(StudentClass studentClass){
        studentClassService.addStudentClass(studentClass);
        return "success";
    }

    /**
     * 删除班级信息
     * @param id
     * @return
     */
    @ResponseBody
    @DeleteMapping("/studentClass/{id}")
    public String deleteStudentClass(@PathVariable("id") int id){
        studentClassService.removeStudentClass(id);
        return "success";
    }

    /**
     * 通过id查询班级信息
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/studentClass/{id}")
    public String toUpdatePage(@PathVariable("id")int id,
                               Model model){
        StudentClass studentClass = studentClassService.selectStudentClassById(id);
        model.addAttribute("studentClass",studentClass);
        return "studentClass/edit";
    }


    /**
     * 修改班级信息
     * @param studentClass
     * @return
     */
    @ResponseBody
    @PutMapping("/studentClass")
    public String UpdateStudentClass(StudentClass studentClass){
        studentClassService.updateStudentClass(studentClass);
        return "success";
    }


    /**
     * 批量删除班级信息
     * @param data
     * @return
     */
    @ResponseBody
    @PostMapping("/dstudentClasss")
    public Map<String , Object> deleteStudentClassByIds(@RequestBody List<Integer> data){
        Map<String,Object> map = new HashMap<>();
        int i = studentClassService.deleteStudentClassByIds(data);
        map.put("count",i);
        return map;
    }
}
