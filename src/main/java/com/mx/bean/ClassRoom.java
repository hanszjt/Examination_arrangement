package com.mx.bean;

/**
 * Created by mx on 2019/3/4.
 */
public class ClassRoom {
    private int id;
    private String teachbuilding;
    private String classroomnum;
    private int classroomcount;

    @Override
    public String toString() {
        return "ClassRoom{" +
                "id=" + id +
                ", teacherbuilding='" + teachbuilding + '\'' +
                ", classroomnum='" + classroomnum + '\'' +
                ", classroomcount=" + classroomcount +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeachbuilding() {
        return teachbuilding;
    }

    public void setTeachbuilding(String teachbuilding) {
        this.teachbuilding = teachbuilding;
    }

    public String getClassroomnum() {
        return classroomnum;
    }

    public void setClassroomnum(String classroomnum) {
        this.classroomnum = classroomnum;
    }

    public int getClassroomcount() {
        return classroomcount;
    }

    public void setClassroomcount(int classroomcount) {
        this.classroomcount = classroomcount;
    }
}
