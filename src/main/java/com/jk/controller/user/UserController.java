package com.jk.controller.user;

import com.alibaba.fastjson.JSON;
import com.jk.model.LogInfo;
import com.jk.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("test")
    @ResponseBody
    public void test(Integer a,Integer b){
        userService.test(a,b);
    }

    @RequestMapping("test2")
    @ResponseBody
    public void test2(){
        userService.test2();
    }

    /*
    * 从Mongodb取出日志记录存到Mysql数据库中
    * */
    @RequestMapping("monToMysql")
    @ResponseBody
    public void monToMysql(){
        userService.monToMysql();
    }

    @RequestMapping("chart")
    public String chart(Model model){
        List<HashMap<String, Object>> chartList = userService.queryChart();
        String jsonString = JSON.toJSONString(chartList);
        model.addAttribute("userList",jsonString);
        return "chart";
    }



}
