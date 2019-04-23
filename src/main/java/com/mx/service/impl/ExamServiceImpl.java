package com.mx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mx.bean.Exam;
import com.mx.mapper.ExamMapper;
import com.mx.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mx on 2019/3/8.
 */
@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    ExamMapper examMapper;
    @Override
    public int addExam(Exam exam) {
        int i = examMapper.addExam(exam);
        return i;
    }

    @Override
    public int removeExam(int id) {
        int i = examMapper.deleteExam(id);
        return i;
    }

    @Override
    public int updateExam(Exam exam) {
        int i = examMapper.updateExam(exam);
        return i;
    }

    @Override
    public PageInfo<Exam> selectExam(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Exam> exams = examMapper.findAllExam();
        PageInfo<Exam> pageInfo = new PageInfo<>(exams);
        return pageInfo;
    }

    @Override
    public Exam selectExamById(int id) {
        Exam exam = examMapper.querryExamById(id);
        return exam;
    }

    @Override
    public int selectExamByDate(String date) {
        int i = examMapper.querryExamByDate(date);
        return i;
    }

    @Override
    public int deleteExamByIds(List<Integer> ids) {
        int i = examMapper.deleteExamByIds(ids);
        return i;
    }

    @Override
    public int selectExamCount() {
        return examMapper.selectExamCount();
    }

    @Override
    public PageInfo<Exam> selectExamByName(int pageNo, int pageSize, String subjectname) {
        PageHelper.startPage(pageNo,pageSize);
        List<Exam> exams = examMapper.selectExamByName(subjectname);
        PageInfo<Exam> pageInfo = new PageInfo<>(exams);
        return pageInfo;
    }
}
