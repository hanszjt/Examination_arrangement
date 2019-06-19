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

    /**
     * 添加班级信息
     * @param studentClass
     * @return
     */
    @Override
    public int addStudentClass(StudentClass studentClass) {
        int i = studentClassMapper.addStudentClass(studentClass);
        return i;
    }

    /**
     * 删除班级信息
     * @param id
     * @return
     */
    @Override
    public int removeStudentClass(int id) {
        int i = studentClassMapper.deleteStudentClass(id);
        return i;
    }

    /**
     * 更新班级信息
     * @param studentClass
     * @return
     */
    @Override
    public int updateStudentClass(StudentClass studentClass) {
        int i = studentClassMapper.updateStudentClass(studentClass);
        return i;
    }

    /**
     * 查询班级信息
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<StudentClass> selectStudentClass(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<StudentClass> studentClass = studentClassMapper.findAllStudentClass();
        PageInfo<StudentClass> pageInfo = new PageInfo<>(studentClass);
        return pageInfo;
    }

    /**
     * 通过id查询班级信息
     * @param id
     * @return
     */
    @Override
    public StudentClass selectStudentClassById(int id) {
        StudentClass studentClass = studentClassMapper.querryStudentClassById(id);
        return studentClass;
    }

    /**
     * 通过id批量删除班级
     * @param ids
     * @return
     */
    @Override
    public int deleteStudentClassByIds(List<Integer> ids) {
        int i = studentClassMapper.deleteStudentClassByIds(ids);
        return i;
    }

    /**
     * 查询班级数量
     * @return
     */
    @Override
    public int selectStudentClassCount() {
        return studentClassMapper.selectStudentClassCount();
    }

    /**
     * 通过班级编号查询班级信息
     * @param pageNo
     * @param pageSize
     * @param classname
     * @return
     */
    @Override
    public PageInfo<StudentClass> selectStudentClassByName(int pageNo, int pageSize, String classname) {
        PageHelper.startPage(pageNo,pageSize);
        List<StudentClass> studentClasses = studentClassMapper.selectStudentClassByName(classname);
        PageInfo<StudentClass> pageInfo = new PageInfo<>(studentClasses);
        return pageInfo;
    }
}
