package com.mx.controller;

import com.github.pagehelper.PageInfo;
import com.mx.bean.ClassRoom;
import com.mx.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mx on 2019/4/24.
 */
@Controller
public class ClassRoomController {
    
    @Autowired
    ClassRoomService classRoomService;

    /**
     * 进入教室管理界面
     * @param model
     * @return
     */
    @GetMapping("/classRoom")
    public String classRoomList(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo , @RequestParam(value = "pageSize",defaultValue = "10") int pageSize , Model model){
        PageInfo<ClassRoom> pageInfo = classRoomService.selectClassRoom(pageNo,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("classRoomCount",classRoomService.selectClassRoomCount());
        return "classRoom/list";
    }

    /**
     * 通过教室编号来查询教室信息
     * @param pageNo
     * @param pageSize
     * @param classroomnum
     * @param model
     * @return
     */
    @PostMapping("/classRoom/search")
    public String searchClassRoom(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo ,
                             @RequestParam(value = "pageSize",defaultValue = "10") int pageSize ,
                             @RequestParam("classroomnum") String classroomnum,
                             Model model){
        PageInfo<ClassRoom> pageInfo = classRoomService.selectClassRoomByName(pageNo,pageSize,classroomnum);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("classRoomCount",pageInfo.getList().size());
        return "classRoom/list";
    }


    /**
     * 添加教室页面
     * @return
     */
    @GetMapping("/classRoomAdd")
    public String toAddPage(){
        return "classRoom/add";
    }

    /**
     * 添加教室信息逻辑
     * @param classRoom
     * @return
     */
    @ResponseBody
    @PostMapping("/classRoom")
    public String addClassRoom(ClassRoom classRoom){
        System.out.println(classRoom);
        classRoomService.addClassRoom(classRoom);
        return "success";
    }

    /**
     * 删除教室信息
     * @param id
     * @return
     */
    @ResponseBody
    @DeleteMapping("/classRoom/{id}")
    public String deleteClassRoom(@PathVariable("id") int id){
        classRoomService.removeClassRoom(id);
        return "success";
    }

    /**
     * 通过id查询教室
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/classRoom/{id}")
    public String toUpdatePage(@PathVariable("id")int id,
                               Model model){
        ClassRoom classRoom = classRoomService.selectClassRoomById(id);
        model.addAttribute("classRoom",classRoom);
        return "classRoom/edit";
    }


    /**
     * 修改教室信息
     * @param classRoom
     * @return
     */
    @ResponseBody
    @PutMapping("/classRoom")
    public String UpdateClassRoom(ClassRoom classRoom){
        classRoomService.updateClassRoom(classRoom);
        return "success";
    }


    /**
     * 批量删除教室信息
     * @param data
     * @return
     */
    @ResponseBody
    @PostMapping("/dclassRooms")
    public Map<String , Object> deleteClassRoomByIds(@RequestBody List<Integer> data){
        Map<String,Object> map = new HashMap<>();
        int i = classRoomService.deleteClassRoomByIds(data);
        map.put("count",i);
        return map;
    }

}
