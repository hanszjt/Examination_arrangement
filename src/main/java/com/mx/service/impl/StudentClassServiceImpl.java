package com.mx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mx.bean.StudentClass;
import com.mx.mapper.StudentClassMapper;
import com.mx.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mx on 2019/2/28.
 */
@Service
public class StudentClassServiceImpl implements StudentClassService {
    @Autowired
    StudentClassMapper studentClassMapper;

    @Override
    public int addStudentClass(StudentClass studentClass) {
        int i = studentClassMapper.addStudentClass(studentClass);
        return i;
    }

    @Override
    public int removeStudentClass(int id) {
        int i = studentClassMapper.deleteStudentClass(id);
        return i;
    }

    @Override
    public int updateStudentClass(StudentClass studentClass) {
        int i = studentClassMapper.updateStudentClass(studentClass);
        return i;
    }

    @Override
    public PageInfo<StudentClass> selectStudentClass(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<StudentClass> studentClass = studentClassMapper.findAllStudentClass();
        PageInfo<StudentClass> pageInfo = new PageInfo<>(studentClass);
        return pageInfo;
    }

    @Override
    public StudentClass selectStudentClassById(int id) {
        StudentClass studentClass = studentClassMapper.querryStudentClassById(id);
        return studentClass;
    }

    @Override
    public int deleteStudentClassByIds(List<Integer> ids) {
        int i = studentClassMapper.deleteStudentClassByIds(ids);
        return i;
    }

    @Override
    public int selectStudentClassCount() {
        return studentClassMapper.selectStudentClassCount();
    }

    @Override
    public PageInfo<StudentClass> selectStudentClassByName(int pageNo, int pageSize, String classname) {
        PageHelper.startPage(pageNo,pageSize);
        List<StudentClass> studentClasses = studentClassMapper.selectStudentClassByName(classname);
        PageInfo<StudentClass> pageInfo = new PageInfo<>(studentClasses);
        return pageInfo;
    }
}
