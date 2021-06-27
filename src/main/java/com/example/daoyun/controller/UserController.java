package com.example.daoyun.controller;

import com.example.daoyun.domain.User;
import com.example.daoyun.service.UserService;
import com.example.daoyun.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PutMapping("/userinfo")
    public Result userInfo(@RequestBody User user) throws IOException {
        System.out.println(user.toString());
        if (userService.checkNum(user.getNumber()) > 0) {
            return Result.failure("0", "学号已存在");
        }
        if (userService.userInfo(user) == 1) {
            return Result.success().setCode("200").setMsg("修改成功");
        }
        return Result.failure("0", "修改失败");
    }

    @GetMapping("/userlist")
    public Result userList() {
        List<User> userlist = userService.userList();
        return Result.success().setCode("200").setMsg("查询用户列表成功").setData(userlist);
    }

    @PostMapping("newuser")
    public Result newUser(@RequestBody User user) {
        if (userService.checkPhone(user.getPhone()) == 1) {
            return Result.failure("0", "用户已存在");
        }
        if (userService.newUser(user) == 1) {
            return Result.success().setCode("200").setMsg("添加用户成功,默认密码123456");
        }
        return Result.failure("0", "添加用户失败");
    }

    @DeleteMapping("deleteuser/{phone}")
    public Result deleteUser(@PathVariable String phone){
        if (userService.deleteUser(phone) == 1){
            return Result.success().setCode("200").setMsg("删除成功");
        }
        return Result.failure("0","删除失败");
    }
}
