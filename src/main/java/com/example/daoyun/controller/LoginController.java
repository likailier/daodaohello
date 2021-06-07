package com.example.daoyun.controller;


import java.security.SecureRandom;
import java.util.Random;
import com.example.daoyun.domain.Login;
import com.example.daoyun.domain.User;
import com.example.daoyun.service.UserService;
import com.example.daoyun.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    //短信验证码生成
    private static final String SYMBOLS = "0123456789";
    @Autowired
    private UserService userService;
    private static final Random RANDOM = new SecureRandom();




    //电话号码和密码登录，返回token
    @RequestMapping("/userlogin")
    public Result userLogin(@RequestBody Login login){
        String token;

        System.out.println("登录"+login);
        if (login.getPhone() == null ||login.getPassword() == null || login.getPhone().equals("") ||login.getPassword().equals("")){
            return Result.failure("0", "账号密码不能为空");
        }
        if (userService.userLogin(login) != 1){
            return Result.failure("0","账号密码错误或账号不存在");
        }

        try{
            token = JWTutil.createToken(login.getPhone());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure("0","参数出错");
        }

        return Result.success().setCode("200").setMsg("登陆成功").setData(token);

    }


    @RequestMapping("/fastlogin")
    public Result fastLogin(@RequestParam String phone,@RequestParam String verifycode){
        String token;
        if (phone==null || phone.equals("")){
            return Result.failure("0", "账号不能为空");
        }
        if (userService.checkPhone(phone) != 1){
            return Result.failure("0","账号密码错误或账号不存在");
        }
        String code = JedisUtil.getVerifycode(phone);
        if (code == null){
            return Result.failure("0", "请重新输入验证码");
        }
        if (JedisUtil.getVerifycode(phone).equals(verifycode)){
            try{
                token = JWTutil.createToken(phone);
            } catch (Exception e) {
                e.printStackTrace();
                return Result.failure("0","参数出错");
            }
            return Result.success().setCode("200").setMsg("登陆成功").setData(token);
        }
        return Result.failure("0", "验证码错误");
    }



    //电话号码和密码注册
    @RequestMapping("/register")
    public Result register(@RequestBody Login login){
        if (login.getPhone() == null ||login.getPassword() == null || login.getPhone().equals("") ||login.getPassword().equals("")){
            return Result.failure("0", "账号密码不能为空");
        }
        if (userService.checkPhone(login.getPhone()) == 1){
            return Result.failure("0", "账号已存在");
        }
        userService.register(login);
        return Result.success().setCode("200").setMsg("注册成功");
    }


    @RequestMapping("/fastregister")
    public Result fastRegister(@RequestParam String phone,@RequestParam String verifycode){
        if (phone==null || phone.equals("")){
            return Result.failure("0", "账号不能为空");
        }
        if (userService.checkPhone(phone) == 1){
            return Result.failure("0", "账号已存在");
        }
        String code = JedisUtil.getVerifycode(phone);
        if (code == null){
            return Result.failure("0", "请重新输入验证码");
        }
        if (code.equals(verifycode)){
            userService.fastregister(phone);
            return Result.success().setCode("200").setMsg("注册成功");
        }
        return Result.failure("0", "验证码错误");

    }



    @RequestMapping("/sendsms")
    public void sendSms(@RequestParam String phone){

        //生成随机验证码
        String verifyCode = String.valueOf((int)(Math.random()*900000+100000));
        System.out.println("生成的验证码："+verifyCode);

        //存到redis里
        JedisUtil.setVerifycode(phone,verifyCode);

        SmsUtil.sendSms(verifyCode, new String[] {"+86"+phone});
    }






    @RequestMapping("/tokentest")
    public Result hello(){
        String str = "测试token成功";
        return Result.success().setCode(ResultCodeEnum.OK.getCode()).setMsg(str);
    }
}
