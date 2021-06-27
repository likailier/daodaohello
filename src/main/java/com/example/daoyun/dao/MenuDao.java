package com.example.daoyun.dao;

import com.example.daoyun.domain.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao {
    public List<Menu> allMenu();
    public int newMenu(Menu menu);
    public int deleteMenu(int id);
    public int checkMenu(String name);
}
