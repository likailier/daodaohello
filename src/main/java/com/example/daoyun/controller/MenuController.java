package com.example.daoyun.controller;

import com.example.daoyun.domain.Menu;
import com.example.daoyun.service.MenuService;
import com.example.daoyun.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    MenuService menuService;

    @PostMapping("/newmenu")
    public Result newMenu(@RequestBody Menu menu){
        if (menuService.newMenu(menu) == 1){
            return Result.success().setCode("200").setMsg("插入成功");
        }
        return Result.failure("0","菜单名重复");
    }

    @DeleteMapping("/deletemenu/{id}")
    public Result deleteMenu(@PathVariable int id){
        if (id <= 5){
            return Result.failure("0","该菜单与系统相关，请勿删除");
        }
        if (menuService.deleteMenu(id) == 1){
            return Result.success().setCode("200").setMsg("删除菜单成功");
        }
        return Result.failure("0","删除菜单失败");
    }

    @GetMapping("/menu")
    public Result allMenu(){
        List<Menu> menu = menuService.allMenu();
        return Result.success().setCode("200").setMsg("查询菜单成功").setData(menu);
    }

}
