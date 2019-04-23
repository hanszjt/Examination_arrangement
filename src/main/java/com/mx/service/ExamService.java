package com.mx.service;

import com.github.pagehelper.PageInfo;
import com.mx.bean.Exam;

import java.util.List;

/**
 * Created by mx on 2019/3/8.
 */
public interface ExamService {
    int addExam(Exam exam);

    int removeExam(int id);

    int updateExam(Exam exam);

    PageInfo<Exam> selectExam(int pageNo , int pageSize);

    Exam selectExamById(int id);

    int selectExamByDate(String date);

    int deleteExamByIds(List<Integer> ids);

    int selectExamCount();

    PageInfo<Exam> selectExamByName(int pageNo,int pageSize,String subjectname);
}
