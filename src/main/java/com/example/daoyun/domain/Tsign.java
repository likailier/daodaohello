package com.example.daoyun.domain;

import java.util.Date;

public class Tsign {
    private int tsignid;
    private String classnumber;
    private int longitude;
    private int latitude;
    private int tid;//教师工号
    private int state;
    private Long stime;
    private Long etime;
    private int type;
    private int duration;

    private String retime;

    public int getTsignid() {
        return tsignid;
    }

    public void setTsignid(int tsignid) {
        this.tsignid = tsignid;
    }

    public String getClassnumber() {
        return classnumber;
    }

    public void setClassnumber(String classnumber) {
        this.classnumber = classnumber;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Long getStime() {
        return stime;
    }

    public void setStime(Long stime) {
        this.stime = stime;
    }

    public Long getEtime() {
        return etime;
    }

    public void setEtime(Long etime) {
        this.etime = etime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getRetime() {
        return retime;
    }

    public void setRetime(String retime) {
        this.retime = retime;
    }
}
