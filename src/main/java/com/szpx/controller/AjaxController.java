package com.szpx.controller;

import com.alibaba.fastjson.JSONArray;
import com.szpx.entity.User;
import com.szpx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 1.测试前端使用Ajax向后台发送JSON数据，后台接收到数据。
 * 2.后台使用JSON解析前端传过来的数据后返回JSON数据给前端展示。
 */
@Controller
public class AjaxController {
    @Autowired
    private UserService userService;
    /**
     * 访问FormTableAjaxIndex
     *
     * @param session
     * @return RequestMapping 返回一个网页
     */

//    这是一个输入寄送和收货的地址导向网页

    /**
     *派件管理
     */
//    @RequestMapping("/toDispatchManagement")
//    public String zylDispatchtoDispatchManagement(HttpSession session) {
//
//        return "DispatchManagement";
//    }
//    @RequestMapping("/toinquiry")
//    public String toinquiry(HttpSession session) {
//        return "zrp/inquiry";
//    }


    /**
     * 测试ajax接收数据
     *
     * @param jsonDataFromTheFrontEnd 前端传过来的JSON数据，如果你希望直接绑定到Java对象上，可以定义一个对应的Java类（比如User），并使用@RequestBody User user来接收数据。
     *                                例如：public String submitForm(@RequestBody User user) {...}
     *                                在这种情况下，Spring MVC会自动将JSON数据绑定到User对象的属性上（属性名需要与JSON中的键名匹配）。你需要确保已经添加了Jackson库来处理JSON数据的自动绑定。
     * @param session
     * @param model
     * @return // 返回成功消息给前端（仅作为示例）。在实际应用中，你可能需要返回一个包含更多信息的JSON响应对象。
     */
    @PostMapping("/ajaxRequest")
    @ResponseBody
    public String ajaxRequest(@RequestBody String jsonDataFromTheFrontEnd, HttpSession session, Model model) {
        // 在这里处理接收到的JSON数据，比如解析JSON字符串并保存到数据库中。

        // 为了展示返回的JSON效果，这里直接将前端传过来的String类型的jsonDataFromTheFrontEnd转化为JSON后返回到前端去
        String result = "";
        if (jsonDataFromTheFrontEnd != null || jsonDataFromTheFrontEnd != "") {
            //前端传过来的jsonDataFromTheFrontEnd值是：{"cellphone":"17687188086","vercode":"17687188086","password":"17687188086","confirmPassword":"17687188086","nickname":"17687188086","agreement":"on"}
            System.out.println("前端传过来的jsonDataFromTheFrontEnd值是：" + jsonDataFromTheFrontEnd);
            // 使用alibaba.fastjson对字符串进行反序列化
            // 创建一个包含多个对象的列表
            // 构造多个对象绑定的JSON格式数据,此处借用User的查询业务
            // 当然如果是注册业务，这里应该去执行将Controller中接受的数据存入数据库的操作,此处只做简单展示
            List<User> userList = userService.selectAllUser();
            // 将对象列表转换为 JSON格式的字符串数组并返回
            String jsonArrayString = JSONArray.toJSONString(userList);
            System.out.println("准备返回的JSON字符串数据是：" + jsonArrayString); // 输出 JSON 数组字符串
            System.out.println("successful");
            result = jsonArrayString;
        } else {
            result = "failed";
        }

        return result;// 返回成功消息给前端（仅作为示例）。在实际应用中，你可能需要返回一个包含更多信息的JSON响应对象。
    }


}
