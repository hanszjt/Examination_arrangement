package com.mx.service.impl;

import com.mx.bean.Exam;
import com.mx.mapper.ExamMapper;
import com.mx.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
