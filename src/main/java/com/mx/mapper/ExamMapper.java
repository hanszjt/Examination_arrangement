package com.mx.mapper;

import com.mx.bean.Exam;

/**
 * Created by mx on 2019/3/8.
 */
public interface ExamMapper {

    /**
     * 添加考试信息
     * @param exam
     * @return
     */
    int addExam(Exam exam);


}
