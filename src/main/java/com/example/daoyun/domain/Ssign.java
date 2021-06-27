package com.example.daoyun.domain;

public class Ssign {
    private int ssignid;
    private int tsignid;
    private int number;
    private int longitude;
    private int latitude;
    private int distance;
    private String classnumber;
    private String name;

    public int getSsignid() {
        return ssignid;
    }

    public void setSsignid(int ssignid) {
        this.ssignid = ssignid;
    }

    public int getTsignid() {
        return tsignid;
    }

    public void setTsignid(int tsignid) {
        this.tsignid = tsignid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getClassnumber() {
        return classnumber;
    }

    public void setClassnumber(String classnumber) {
        this.classnumber = classnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
