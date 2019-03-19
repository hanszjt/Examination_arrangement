package com.mx.mapper;

import com.github.pagehelper.PageInfo;
import com.mx.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by zjt on 2019/2/12.
 */

public interface UserMapper {

    //@Select("select * from user_info where username=#{username}")
    User findUserByName(@Param("username") String username);

    /**
     * 查询所有用户
     * @return
     */
    List<User> querryAllUser();

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int deleteUser(int id);

    /**
     * 修改用户
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User queryUserById(int id);

    /**
     * 批量删除用户
     * @param ids
     * @return
     */
    int deleteUserByIds(List<Integer> ids);

    /**
     * 查询用户数量
     * @return
     */
    @Select("select count(*) from user_info")
    int selectUserCount();

    /**
     * 根据用户名搜索用户
     * @param username
     * @return
     */
    List<User> querryUserByUserName(String username);

    int updateUserStatus(@Param("id") int id,@Param("status") String status);

}
