package com.mx.service;

import com.mx.bean.ArrangementExam;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by mx on 2019/3/4.
 */
public interface ArrangementExamService {


    Map<String , Object> addExam(ArrangementExam arrangementExam) throws ParseException;

    List<Integer> getInvigilator();
}
