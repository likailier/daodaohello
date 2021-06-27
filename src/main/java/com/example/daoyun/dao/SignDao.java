package com.example.daoyun.dao;

import com.example.daoyun.domain.Ssign;
import com.example.daoyun.domain.StudentClass;
import com.example.daoyun.domain.Tsign;
import com.example.daoyun.domain.User;
import com.tencentcloudapi.common.Sign;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Repository
public interface SignDao {
    public int teacherSign(Tsign tsign);
    public int checkSign(Tsign tsign);
    public int checkStudentSign(Ssign ssign);
    public int selectTsignId(String classnumber,long stime);
    public int studentSign(Ssign ssign);
    public Tsign signDistance(int tsignid);
    public int finishSign(int tsignid);
    public List<Tsign> classSignList(String classnumber);
    public List<Ssign> studentSignList(int tsignid);

    public List<String> noSignList(Tsign tsign);
    public List<User> noSignListName(List<String> nosignlist);

    public int suSign(Ssign ssign);
}
