package com.mx.bean;

/**
 * Created by mx on 2019/3/5.
 */
public class Exam {
    private int id;
    private String classroom;
    private String invigilator;
    private String examsubject;
    private String examtime;
    private String examclass;


    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", classroom='" + classroom + '\'' +
                ", invigilator='" + invigilator + '\'' +
                ", examsubject='" + examsubject + '\'' +
                ", examtime='" + examtime + '\'' +
                ", examclass='" + examclass + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getInvigilator() {
        return invigilator;
    }

    public void setInvigilator(String invigilator) {
        this.invigilator = invigilator;
    }

    public String getExamsubject() {
        return examsubject;
    }

    public void setExamsubject(String examsubject) {
        this.examsubject = examsubject;
    }

    public String getExamtime() {
        return examtime;
    }

    public void setExamtime(String examtime) {
        this.examtime = examtime;
    }

    public String getExamclass() {
        return examclass;
    }

    public void setExamclass(String examclass) {
        this.examclass = examclass;
    }
}
