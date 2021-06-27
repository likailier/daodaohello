package com.example.daoyun.service;

import com.example.daoyun.domain.Ssign;
import com.example.daoyun.domain.StudentClass;
import com.example.daoyun.domain.Tsign;
import com.example.daoyun.domain.User;

import java.util.List;

public interface SignService {
    public int teacherSign(Tsign tsign);
    public int checkSign(Tsign tsign);
    public int selectTsignId(String classnumber,long stime);
    public int studentSign(Ssign ssign);
    public int finishSign(int tsignid);
    public List<Tsign> classSignList(String classnumber);
    public List<Ssign> studentSignList(int tsignid);

    public List<User> noSignList(Tsign tsign);
    public int suSign(Ssign ssign);
}
