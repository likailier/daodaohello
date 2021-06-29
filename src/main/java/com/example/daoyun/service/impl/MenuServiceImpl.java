package com.example.daoyun.service.impl;


import com.example.daoyun.dao.MenuDao;
import com.example.daoyun.domain.Menu;
import com.example.daoyun.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuDao menuDao;

    @Override
    public List<Menu> allMenu() {
        return menuDao.allMenu();
    }

    @Override
    public int newMenu(Menu menu) {
        menu.setUrl("#/UserInfo");
        if (menuDao.checkMenu(menu.getName())>0){
            return 0;
        }
        return menuDao.newMenu(menu);
    }

    @Override
    public int deleteMenu(int id) {
        return menuDao.deleteMenu(id);
    }
}
