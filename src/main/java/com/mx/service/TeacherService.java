package com.mx.service;


import com.github.pagehelper.PageInfo;
import com.mx.bean.Teacher;

import java.util.List;

/**
 * Created by mx on 2019/2/14.
 */
public interface TeacherService {

    int addTeacher(Teacher teacher);

    int removeTeacher(int id);

    int updateTeacher(Teacher teacher);

    PageInfo<Teacher> selectTeacher(int pageNo , int pageSize);

    Teacher selectTeacherById(int id);

    Teacher selectTeacherByTid(String tid);

    int deleteTeacherByIds(List<Integer> ids);

    int selectTeacherCount();

    PageInfo<Teacher> selectTeacherByName(int pageNo,int pageSize,String tname);
}
