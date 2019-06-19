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

    /**
     * 添加考试科目信息
     * @param examsubject
     * @return
     */
    @Override
    public int addExamsubject(Examsubject examsubject) {
        int i = examSubjectMapper.addExamsubject(examsubject);
        return i;
    }

    /**
     * 删除考试科目信息
     * @param id
     * @return
     */
    @Override
    public int removeExamsubject(int id) {
        int i = examSubjectMapper.deleteExamsubject(id);
        return i;
    }

    /**
     * 修改考试科目信息
     * @param examsubject
     * @return
     */
    @Override
    public int updateExamsubject(Examsubject examsubject) {
        int i = examSubjectMapper.updateExamsubject(examsubject);
        return i;
    }

    /**
     * 查询考试科目信息
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Examsubject> selectExamsubject(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Examsubject> examsubject = examSubjectMapper.findAllExamsubject();
        PageInfo<Examsubject> pageInfo = new PageInfo<>(examsubject);
        return pageInfo;
    }

    /**
     * 通过id查询考试科目信息
     * @param id
     * @return
     */
    @Override
    public Examsubject selectExamsubjectById(int id) {
        Examsubject examsubject = examSubjectMapper.querryExamsubjectById(id);
        return examsubject;
    }

    /**
     * 通过id批量删除考试科目信息
     * @param ids
     * @return
     */
    @Override
    public int deleteExamsubjectByIds(List<Integer> ids) {
        int i = examSubjectMapper.deleteExamsubjectByIds(ids);
        return i;
    }

    /**
     * 查询考试科目数量
     * @return
     */
    @Override
    public int selectExamsubjectCount() {

        return examSubjectMapper.selectExamsubjectCount();
    }

    /**
     * 通过考试科目名称查询考试科目信息
     * @param pageNo
     * @param pageSize
     * @param subjectname
     * @return
     */
    @Override
    public PageInfo<Examsubject> selectExamsubjectByName(int pageNo, int pageSize, String subjectname) {
        PageHelper.startPage(pageNo,pageSize);
        List<Examsubject> examsubjects = examSubjectMapper.selectExamsubjectByName(subjectname);
        PageInfo<Examsubject> pageInfo = new PageInfo<>(examsubjects);
        return pageInfo;
    }
}
