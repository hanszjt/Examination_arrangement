package com.mx.service;

import com.github.pagehelper.PageInfo;
import com.mx.bean.Examsubject;

import java.util.List;

/**
 * Created by mx on 2019/2/28.
 */
public interface ExamSubjectService {
    int addExamsubject(Examsubject examsubject);

    int removeExamsubject(int id);

    int updateExamsubject(Examsubject examsubject);

    PageInfo<Examsubject> selectExamsubject(int pageNo , int pageSize);

    Examsubject selectExamsubjectById(int id);

    int deleteExamsubjectByIds(List<Integer> ids);

    int selectExamsubjectCount();

    PageInfo<Examsubject> selectExamsubjectByName(int pageNo,int pageSize,String subjectname);
    
}
