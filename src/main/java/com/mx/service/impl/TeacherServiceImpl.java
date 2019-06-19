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

    /**
     * 添加教师
     * @param teacher
     * @return
     */
    @Override
    public int addTeacher(Teacher teacher) {
        int i = teacherMapper.addTeacher(teacher);
        return i;
    }

    /**
     * 删除教师
     * @param id
     * @return
     */
    @Override
    public int removeTeacher(int id) {
        int i = teacherMapper.deleteTeacher(id);
        return i;
    }

    /**
     * 修改教师
     * @param teacher
     * @return
     */
    @Override
    public int updateTeacher(Teacher teacher) {
        int i = teacherMapper.updateTeacher(teacher);
        return i;
    }

    /**
     * 查询教师
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Teacher> selectTeacher(int pageNo , int pageSize) {
        PageHelper.startPage(pageNo,pageSize);

        List<Teacher> allTeacher = teacherMapper.findAllTeacher();

        PageInfo<Teacher> pageInfo = new PageInfo<>(allTeacher);
        return pageInfo;
    }

    /**
     * 通过id查询教师信息
     * @param id
     * @return
     */
    @Override
    public Teacher selectTeacherById(int id) {
        Teacher teacher = teacherMapper.querryTeacherById(id);
        return teacher;
    }

    /**
     * 通过教师编号查询教师
     * @param tid
     * @return
     */
    @Override
    public Teacher selectTeacherByTid(String tid) {
        Teacher teacher = teacherMapper.querryTeacherByTid(tid);
        return teacher;
    }

    /**
     * 通过id批量删除教师信息
     * @param ids
     * @return
     */
    @Override
    public int deleteTeacherByIds(List<Integer> ids) {
        int i = teacherMapper.deleteTeacherByIds(ids);
        return i;
    }

    /**
     * 查询教师数量
     * @return
     */
    @Override
    public int selectTeacherCount() {
        return teacherMapper.selectTeacherCount();
    }

    /**
     * 通过姓名查询教师信息
     * @param pageNo
     * @param pageSize
     * @param tname
     * @return
     */
    @Override
    public PageInfo<Teacher> selectTeacherByName(int pageNo, int pageSize, String tname) {
        PageHelper.startPage(pageNo,pageSize);
        List<Teacher> teachers = teacherMapper.selectTeacherByName(tname);
        PageInfo<Teacher> pageInfo = new PageInfo<>(teachers);
        return pageInfo;
    }
}
