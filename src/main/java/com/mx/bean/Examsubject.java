package com.mx.bean;

/**
 * Created by mx on 2019/2/28.
 */
public class Examsubject {

    private int id;
    private String subjectname;

    @Override
    public String toString() {
        return "Examsubject{" +
                "id=" + id +
                ", subjectname='" + subjectname + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }
}
