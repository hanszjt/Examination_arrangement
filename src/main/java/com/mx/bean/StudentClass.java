package com.mx.bean;

/**
 * Created by mx on 2019/2/28.
 */
public class StudentClass {

    private int id;
    private String classname;
    private int studentnum;

    @Override
    public String toString() {
        return "StudentClass{" +
                "id=" + id +
                ", classname='" + classname + '\'' +
                ", studentnum='" + studentnum + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public int getStudentnum() {
        return studentnum;
    }

    public void setStudentnum(int studentnum) {
        this.studentnum = studentnum;
    }
}
