package com.mx.service;

import com.github.pagehelper.PageInfo;
import com.mx.bean.User;

import java.util.List;

/**
 * Created by zjt on 2019/2/13.
 */
public interface UserService {

    /**
     * 登录检查
     * @param username
     * @param password
     * @return
     */
    User checkUser(String username , String password);

    /**
     * 分页用户列表
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<User> findAllUser(int pageNo,int pageSize);

    int addUser(User user);

    int removeUser(int id);

    int updateUser(User user);

    User findUserById(int id);

    int deleteUserByIds(List<Integer> ids);

    int selectCountUser();

    PageInfo<User> selectUserByName(int pageNo,int pageSize,String username);

    int updateStatus(int id);
}
