package com.mx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mx.bean.Teacher;
import com.mx.mapper.TeacherMapper;
import com.mx.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mx on 2019/2/14.
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public int addTeacher(Teacher teacher) {
        int i = teacherMapper.addTeacher(teacher);
        return i;
    }

    @Override
    public int removeTeacher(String tid) {
        int i = teacherMapper.deleteTeacher(tid);
        return i;
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        int i = teacherMapper.updateTeacher(teacher);
        return i;
    }

    @Override
    public PageInfo<Teacher> selectTeacher(int pageNo , int pageSize) {
        PageHelper.startPage(pageNo,pageSize);

        List<Teacher> allTeacher = teacherMapper.findAllTeacher();

        PageInfo<Teacher> pageInfo = new PageInfo<>(allTeacher);
        return pageInfo;
    }

    @Override
    public Teacher selectTeacherById(int id) {
        Teacher teacher = teacherMapper.querryTeacherById(id);
        return teacher;
    }

    @Override
    public int deleteTeacherByIds(List<String> tids) {
        int i = teacherMapper.deleteTeacherByIds(tids);
        return i;
    }

    @Override
    public int selectTeacherCount() {
        return teacherMapper.selectTeacherCount();
    }

    @Override
    public PageInfo<Teacher> selectTeacherByName(int pageNo, int pageSize, String tname) {
        PageHelper.startPage(pageNo,pageSize);
        List<Teacher> teachers = teacherMapper.selectTeacherByName(tname);
        PageInfo<Teacher> pageInfo = new PageInfo<>(teachers);
        return pageInfo;
    }
}
