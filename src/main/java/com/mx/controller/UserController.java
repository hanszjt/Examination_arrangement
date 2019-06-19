package com.mx.controller;

import com.github.pagehelper.PageInfo;
import com.mx.bean.User;
import com.mx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mx on 2019/2/21.
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 分页显示用户数据
     * @param pageNo
     * @param pageSize
     * @param model
     * @return
     */
    @GetMapping("/userlist")
    public String toUserList(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo,
                             @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                             Model model){
        PageInfo<User> pageInfo = userService.findAllUser(pageNo,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("userCount",userService.selectCountUser());
        return "user/admin-list";

    }


    /**
     * 通过用户名搜索用户
     * @param pageNo
     * @param pageSize
     * @param username
     * @param model
     * @return
     */
    @PostMapping("/user/search")
    public String searchTeacher(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo ,
                                @RequestParam(value = "pageSize",defaultValue = "10") int pageSize ,
                                @RequestParam("username") String username,
                                Model model){
        PageInfo<User> pageInfo = userService.selectUserByName(pageNo,pageSize,username);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("userCount",pageInfo.getList().size());
        return "user/admin-list";
    }

    /**
     * 进入添加用户页面
     * @return
     */
    @GetMapping("/user")
    public String toAddPage(){
        return "user/admin-add";
    }

    /**
     * 添加用户逻辑
     * @param user
     * @return
     */
    @ResponseBody
    @PostMapping("/user")
    public String addTeacher(User user){
        userService.addUser(user);
        return "success";
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @ResponseBody
    @DeleteMapping("/user/{id}")
    public String deleteTeacher(@PathVariable("id") int id){
        userService.removeUser(id);
        return "success";
    }

    /**
     * 通过id查询用户
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/user/{id}")
    public String toUpdatePage(@PathVariable("id")int id,
                               Model model){
        User user = userService.findUserById(id);
        model.addAttribute("user",user);
        return "user/admin-edit";
    }

    /**
     * 修改账户停用或启用
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping("/userstatus/{id}")
    public String updateUserStatus(@PathVariable("id") int id){
        userService.updateStatus(id);
        return "success";
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @ResponseBody
    @PutMapping("/user")
    public String UpdateTeacher(User user){
        userService.updateUser(user);
        return "success";
    }

    /**
     * 批量删除用户
     * @param data
     * @return
     */
    @ResponseBody
    @PostMapping("/dusers")
    public Map<String , Object> deleteTeacherByIds(@RequestBody List<Integer> data){
        Map<String,Object> map = new HashMap<>();
        int i = userService.deleteUserByIds(data);
        map.put("count",i);
        return map;
    }
}
