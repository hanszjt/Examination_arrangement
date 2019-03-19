package com.mx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mx.bean.Examsubject;
import com.mx.mapper.ExamSubjectMapper;
import com.mx.service.ExamSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mx on 2019/2/28.
 */
@Service
public class ExamSubjectServiceImpl implements ExamSubjectService {

    @Autowired
    ExamSubjectMapper examSubjectMapper;

    @Override
    public int addExamsubject(Examsubject examsubject) {
        int i = examSubjectMapper.addExamsubject(examsubject);
        return i;
    }

    @Override
    public int removeExamsubject(int id) {
        int i = examSubjectMapper.deleteExamsubject(id);
        return i;
    }

    @Override
    public int updateExamsubject(Examsubject examsubject) {
        int i = examSubjectMapper.updateExamsubject(examsubject);
        return i;
    }

    @Override
    public PageInfo<Examsubject> selectExamsubject(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Examsubject> examsubject = examSubjectMapper.findAllExamsubject();
        PageInfo<Examsubject> pageInfo = new PageInfo<>(examsubject);
        return pageInfo;
    }

    @Override
    public Examsubject selectExamsubjectById(int id) {
        Examsubject examsubject = examSubjectMapper.querryExamsubjectById(id);
        return examsubject;
    }

    @Override
    public int deleteExamsubjectByIds(List<Integer> ids) {
        int i = examSubjectMapper.deleteExamsubjectByIds(ids);
        return i;
    }

    @Override
    public int selectExamsubjectCount() {

        return examSubjectMapper.selectExamsubjectCount();
    }

    @Override
    public PageInfo<Examsubject> selectExamsubjectByName(int pageNo, int pageSize, String subjectname) {
        PageHelper.startPage(pageNo,pageSize);
        List<Examsubject> examsubjects = examSubjectMapper.selectExamsubjectByName(subjectname);
        PageInfo<Examsubject> pageInfo = new PageInfo<>(examsubjects);
        return pageInfo;
    }
}
