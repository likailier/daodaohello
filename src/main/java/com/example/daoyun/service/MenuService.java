package com.example.daoyun.service;

import com.example.daoyun.domain.Menu;

import java.util.List;

public interface MenuService {
    public List<Menu> allMenu();
    public int newMenu(Menu menu);
    public int deleteMenu(int id);
}
