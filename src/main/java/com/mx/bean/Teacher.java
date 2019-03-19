package com.mx.bean;

/**
 * Created by mx on 2019/2/13.
 */
public class Teacher {

    private int id;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                ", tcollege='" + tcollege + '\'' +
                ", ttel='" + ttel + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String tid;
    private String tname;
    private String tcollege;
    private String ttel;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTcollege() {
        return tcollege;
    }

    public void setTcollege(String tcollege) {
        this.tcollege = tcollege;
    }

    public String getTtel() {
        return ttel;
    }

    public void setTtel(String ttel) {
        this.ttel = ttel;
    }

}
