package com.example.daoyun.service.impl;

import com.example.daoyun.dao.SignDao;
import com.example.daoyun.domain.Ssign;
import com.example.daoyun.domain.StudentClass;
import com.example.daoyun.domain.Tsign;
import com.example.daoyun.domain.User;
import com.example.daoyun.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Transactional
@Service
public class SignServiceImpl implements SignService {

    @Autowired
    SignDao signDao;

    @Override
    public int teacherSign(Tsign tsign) {

        if (tsign.getType()==1) {
            long now = System.currentTimeMillis();
            tsign.setStime(now);
            tsign.setEtime(now + 60000 * 5);//发起签到时间加上持续时间
            tsign.setState(1);
            return signDao.teacherSign(tsign);
        }
        if (tsign.getType()==2){
            long now = System.currentTimeMillis();
            tsign.setStime(now);
            tsign.setEtime(now + 60000 * tsign.getDuration());//发起签到时间加上持续时间
            tsign.setState(1);
            return signDao.teacherSign(tsign);
        }
        return 0;

    }

    @Override
    public int checkSign(Tsign tsign) {
        tsign.setStime(System.currentTimeMillis());
        return signDao.checkSign(tsign);
    }

    @Override
    public int selectTsignId(String classnumber,long stime) {
        return signDao.selectTsignId(classnumber,stime);
    }


    @Override
    public int studentSign(Ssign ssign) {
        ssign.setTsignid(signDao.selectTsignId(ssign.getClassnumber(),System.currentTimeMillis()));

        //检查是否签到过
        if(signDao.checkStudentSign(ssign)>0){
            return 2;
        }


        Tsign tsign = signDao.signDistance(ssign.getTsignid());
        double diatance =
                Math.pow((double)ssign.getLongitude()-tsign.getLongitude(),2)+Math.pow((double)ssign.getLatitude()-tsign.getLatitude(),2);
        diatance = Math.sqrt(diatance);
        ssign.setDistance((int) diatance);
        System.out.println(ssign.getClassnumber());
        return signDao.studentSign(ssign);
    }

    @Override
    public int finishSign(int tsignid) {
        return signDao.finishSign(tsignid);
    }

    @Override
    public List<Tsign> classSignList(String classnumber) {
        List classTsign = signDao.classSignList(classnumber);
        for (int i = 0;i < classTsign.size();i++){
            Tsign classtsign = (Tsign) classTsign.get(i);
            DateFormat df =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            classtsign.setRetime(df.format(classtsign.getStime()));
        }
        return classTsign;
    }

    @Override
    public List<Ssign> studentSignList(int tsignid) {
        return signDao.studentSignList(tsignid);
    }

    @Override
    public List<User> noSignList(Tsign tsign) {
        List<String> nosignlistnumber = new ArrayList<>(signDao.noSignList(tsign));
        return signDao.noSignListName(nosignlistnumber);
    }

    @Override
    public int suSign(Ssign ssign){
        ssign.setDistance(0);
        return signDao.suSign(ssign);
    }

}
