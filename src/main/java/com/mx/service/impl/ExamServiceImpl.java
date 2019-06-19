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

    /**
     * 添加考场信息
     * @param exam
     * @return
     */
    @Override
    public int addExam(Exam exam) {
        int i = examMapper.addExam(exam);
        return i;
    }

    /**
     * 删除考场信息
     * @param id
     * @return
     */
    @Override
    public int removeExam(int id) {
        int i = examMapper.deleteExam(id);
        return i;
    }

    /**
     * 更新考场信息
     * @param exam
     * @return
     */
    @Override
    public int updateExam(Exam exam) {
        int i = examMapper.updateExam(exam);
        return i;
    }

    /**
     * 查询考场信息
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Exam> selectExam(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Exam> exams = examMapper.findAllExam();
        PageInfo<Exam> pageInfo = new PageInfo<>(exams);
        return pageInfo;
    }

    /**
     * 根据id查询考场信息
     * @param id
     * @return
     */
    @Override
    public Exam selectExamById(int id) {
        Exam exam = examMapper.querryExamById(id);
        return exam;
    }

    /**
     * 根据日期查询考场信息
     * @param date
     * @return
     */
    @Override
    public int selectExamByDate(String date) {
        int i = examMapper.querryExamByDate(date);
        return i;
    }

    /**
     * 根据id批量删除考场信息
     * @param ids
     * @return
     */
    @Override
    public int deleteExamByIds(List<Integer> ids) {
        int i = examMapper.deleteExamByIds(ids);
        return i;
    }

    /**
     * 查询考场信息数量
     * @return
     */
    @Override
    public int selectExamCount() {
        return examMapper.selectExamCount();
    }

    /**
     * 根据老师名称来查询考场信息
     * @param pageNo
     * @param pageSize
     * @param subjectname
     * @return
     */
    @Override
    public PageInfo<Exam> selectExamByName(int pageNo, int pageSize, String subjectname) {
        PageHelper.startPage(pageNo,pageSize);
        List<Exam> exams = examMapper.selectExamByName(subjectname);
        PageInfo<Exam> pageInfo = new PageInfo<>(exams);
        return pageInfo;
    }
}
