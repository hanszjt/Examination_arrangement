package com.mx.controller;

import com.github.pagehelper.PageInfo;
import com.mx.bean.Exam;
import com.mx.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mx on 2019/4/11.
 */
@Controller
public class ExamController {
    @Autowired
    ExamService examService;

    /**
     * 进入考场信息管理界面
     * @param model
     * @return
     */
    @GetMapping("/examInfo")
    public String examList(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo , @RequestParam(value = "pageSize",defaultValue = "10") int pageSize , Model model){
        PageInfo<Exam> pageInfo = examService.selectExam(pageNo,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("examCount",examService.selectExamCount());
        return "exam/list";
    }

    /**
     * 搜索监考教师姓名来查询考场信息
     * @param pageNo
     * @param pageSize
     * @param tname
     * @param model
     * @return
     */
    @PostMapping("/exam/search")
    public String searchExam(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo ,
                                    @RequestParam(value = "pageSize",defaultValue = "10") int pageSize ,
                                    @RequestParam("tname") String tname,
                                    Model model){
        PageInfo<Exam> pageInfo = examService.selectExamByName(pageNo,pageSize,tname);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("examCount",pageInfo.getList().size());
        model.addAttribute("serachname",tname);
        return "exam/searchlist";
    }

    /**
     * 用于分页搜索监考教师姓名来查询考场信息
     * 与上面的区别为一个是post请求一个是get请求
     * @param pageNo
     * @param pageSize
     * @param tname
     * @param model
     * @return
     */
    @GetMapping("/exam/search")
    public String searchExamName(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo ,
                             @RequestParam(value = "pageSize",defaultValue = "10") int pageSize ,
                             @RequestParam("tname") String tname,
                             Model model){
        PageInfo<Exam> pageInfo = examService.selectExamByName(pageNo,pageSize,tname);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("examCount",pageInfo.getList().size());
        model.addAttribute("serachname",tname);
        return "exam/searchlist";
    }

    /**
     * 添加考场
     * @return
     */
    @GetMapping("/exam")
    public String toAddPage(){
        return "exam/add";
    }

    /**
     * 添加考场逻辑
     * @param exam
     * @return
     */
    @ResponseBody
    @PostMapping("/exam")
    public String addExam(Exam exam){
        examService.addExam(exam);
        return "success";
    }

    /**
     * 删除考场信息
     * @param id
     * @return
     */
    @ResponseBody
    @DeleteMapping("/exam/{id}")
    public String deleteExam(@PathVariable("id") int id){
        examService.removeExam(id);
        return "success";
    }

    /**
     * 通过id查询考场信息
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/exam/{id}")
    public String toUpdatePage(@PathVariable("id")int id,
                               Model model){
        Exam exam = examService.selectExamById(id);
        model.addAttribute("exam",exam);
        return "exam/edit";
    }


    /**
     * 修改考场信息
     * @param exam
     * @return
     */
    @ResponseBody
    @PutMapping("/exam")
    public String UpdateExam(Exam exam){
        System.out.println(exam);
        examService.updateExam(exam);
        return "success";
    }


    /**
     * 批量删除考场信息
     * @param data
     * @return
     */
    @ResponseBody
    @PostMapping("/dexams")
    public Map<String , Object> deleteExamByIds(@RequestBody List<Integer> data){
        Map<String,Object> map = new HashMap<>();
        int i = examService.deleteExamByIds(data);
        map.put("count",i);
        return map;
    }


}
