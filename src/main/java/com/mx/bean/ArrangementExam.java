package com.mx.bean;

import java.util.Date;
import java.util.List;

/**
 * Created by mx on 2019/3/4.
 */
public class ArrangementExam {
    private String start;
    private String end;
    private List<Integer> classId;
    private List<Integer> subjectId;

    @Override
    public String toString() {
        return "ArrangementExam{" +
                "start=" + start +
                ", end=" + end +
                ", classId=" + classId +
                ", subjectId=" + subjectId +
                '}';
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public List<Integer> getClassId() {
        return classId;
    }

    public void setClassId(List<Integer> classId) {
        this.classId = classId;
    }

    public List<Integer> getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(List<Integer> subjectId) {
        this.subjectId = subjectId;
    }
}
