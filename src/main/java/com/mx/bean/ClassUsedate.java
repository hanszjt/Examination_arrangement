package com.mx.bean;

import java.util.Date;

/**
 * Created by mx on 2019/3/4.
 */
public class ClassUsedate {
    private int id;
    private String usedate;
    private int usetime;
    private int class_id;
    private String studentclassId;

    @Override
    public String toString() {
        return "ClassUsedate{" +
                "id=" + id +
                ", usedate='" + usedate + '\'' +
                ", usetime=" + usetime +
                ", class_id=" + class_id +
                ", studentclassId='" + studentclassId + '\'' +
                '}';
    }

    public String getStudentclassId() {
        return studentclassId;
    }

    public void setStudentclassId(String studentclassId) {
        this.studentclassId = studentclassId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsedate() {
        return usedate;
    }

    public void setUsedate(String usedate) {
        this.usedate = usedate;
    }

    public int getUsetime() {
        return usetime;
    }

    public void setUsetime(int usetime) {
        this.usetime = usetime;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }
}
