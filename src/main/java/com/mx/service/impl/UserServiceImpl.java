package com.mx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mx.bean.User;
import com.mx.mapper.UserMapper;
import com.mx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mx on 2019/2/13.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 通过用户名密码判断是否正确
     * @param username
     * @param password
     * @return
     */
    @Override
    public User checkUser(String username, String password) {
        User userByName = userMapper.findUserByName(username);
        if(userByName.getPassword().equals(password)){
            return userByName;
        }else{
            return null;
        }
    }

    /**
     * 查询用户信息
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<User> findAllUser(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<User> users = userMapper.querryAllUser();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    @Override
    public int addUser(User user) {
        int i = userMapper.addUser(user);
        return i;
    }

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    @Override
    public int removeUser(int id) {
        int i = userMapper.deleteUser(id);
        return i;
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @Override
    public int updateUser(User user) {
        int i = userMapper.updateUser(user);
        return i;
    }

    /**
     * 通过id查询用户信息
     * @param id
     * @return
     */
    @Override
    public User findUserById(int id) {
        User user = userMapper.queryUserById(id);
        return user;
    }

    /**
     * 通过id删除用户
     * @param ids
     * @return
     */
    @Override
    public int deleteUserByIds(List<Integer> ids) {
        int i = userMapper.deleteUserByIds(ids);
        return i;
    }

    /**
     * 查询用户数量
     * @return
     */
    @Override
    public int selectCountUser() {
        int i = userMapper.selectUserCount();
        return i;
    }

    /**
     * 通过用户名查询用户信息
     * @param pageNo
     * @param pageSize
     * @param username
     * @return
     */
    @Override
    public PageInfo<User> selectUserByName(int pageNo, int pageSize, String username) {
        PageHelper.startPage(pageNo,pageSize);
        List<User> users = userMapper.querryUserByUserName(username);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

    /**
     * 修改用户启用或停用
     * @param id
     * @return
     */
    @Override
    public int updateStatus(int id) {
        User user = userMapper.queryUserById(id);
        String status = user.getStatus();
        if (status.equals("0")) {
            userMapper.updateUserStatus(id,"1");
        }else{
            userMapper.updateUserStatus(id,"0");
        }
        return 0;
    }


}
