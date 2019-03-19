package com.mx.service;

import com.github.pagehelper.PageInfo;
import com.mx.bean.StudentClass;

import java.util.List;

/**
 * Created by mx on 2019/2/28.
 */
public interface StudentClassService {

    int addStudentClass(StudentClass studentClass);

    int removeStudentClass(int id);

    int updateStudentClass(StudentClass studentClass);

    PageInfo<StudentClass> selectStudentClass(int pageNo , int pageSize);

    StudentClass selectStudentClassById(int id);

    int deleteStudentClassByIds(List<Integer> ids);

    int selectStudentClassCount();

    PageInfo<StudentClass> selectStudentClassByName(int pageNo,int pageSize,String classname);
}
