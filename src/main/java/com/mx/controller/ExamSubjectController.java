package com.mx.controller;

import com.github.pagehelper.PageInfo;
import com.mx.bean.Examsubject;
import com.mx.service.ExamSubjectService;
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
public class ExamSubjectController {

    @Autowired
    ExamSubjectService examSubjectService;
    
    /**
     * 进入考试科目管理界面
     * @param model
     * @return
     */
    @GetMapping("/examsubjects")
    public String examsubjectList(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo , @RequestParam(value = "pageSize",defaultValue = "10") int pageSize , Model model){
        PageInfo<Examsubject> pageInfo = examSubjectService.selectExamsubject(pageNo,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("examsubjectCount",examSubjectService.selectExamsubjectCount());
        return "examsubject/list";
    }

    @PostMapping("/examsubject/search")
    public String searchExamsubject(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo ,
                                @RequestParam(value = "pageSize",defaultValue = "10") int pageSize ,
                                @RequestParam("tname") String tname,
                                Model model){
        PageInfo<Examsubject> pageInfo = examSubjectService.selectExamsubjectByName(pageNo,pageSize,tname);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("examsubjectCount",pageInfo.getList().size());
        return "examsubject/list";
    }

    /**
     * 添加考试科目页面
     * @return
     */
    @GetMapping("/examsubject")
    public String toAddPage(){
        return "examsubject/add";
    }

    /**
     * 添加考试科目逻辑
     * @param examsubject
     * @return
     */
    @ResponseBody
    @PostMapping("/examsubject")
    public String addExamsubject(Examsubject examsubject){
        examSubjectService.addExamsubject(examsubject);
        return "success";
    }

    /**
     * 删除考试科目
     * @param id
     * @return
     */
    @ResponseBody
    @DeleteMapping("/examsubject/{id}")
    public String deleteExamsubject(@PathVariable("id") int id){
        examSubjectService.removeExamsubject(id);
        return "success";
    }

    /**
     * 通过id查询考试科目
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/examsubject/{id}")
    public String toUpdatePage(@PathVariable("id")int id,
                               Model model){
        Examsubject examsubject = examSubjectService.selectExamsubjectById(id);
        model.addAttribute("examsubject",examsubject);
        return "examsubject/edit";
    }


    /**
     * 修改考试科目
     * @param examsubject
     * @return
     */
    @ResponseBody
    @PutMapping("/examsubject")
    public String UpdateExamsubject(Examsubject examsubject){
        examSubjectService.updateExamsubject(examsubject);
        return "success";
    }


    /**
     * 批量删除考试科目
     * @param data
     * @return
     */
    @ResponseBody
    @PostMapping("/dexamsubjects")
    public Map<String , Object> deleteExamsubjectByIds(@RequestBody List<Integer> data){
        Map<String,Object> map = new HashMap<>();
        int i = examSubjectService.deleteExamsubjectByIds(data);
        map.put("count",i);
        return map;
    }

}
