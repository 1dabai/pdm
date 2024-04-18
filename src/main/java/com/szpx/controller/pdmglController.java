package com.szpx.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.szpx.entity.Edi;
//import com.szpx.service.EdiService;

import com.szpx.service.EdiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

//这是一个大部分功能实现类pdmgl实现跳转，pdmgll实现添加功能，edilist实现实时显示，addUs实现添加功能，updateEdi提供修改更新

@Controller
public class pdmglController {

    @Autowired
    private EdiService ediService;
//    @Autowired
////    private EdiService ediService;
    /**
     * 访问FormTableAjaxIndex
     *
     * @param session
     * @return RequestMapping 返回一个网页
     */
    @RequestMapping("/dw")
    public String dw(HttpSession session) {
        return "baidu";
    }

//    这是一个输入寄送和收货的地址导向网页
    @RequestMapping("/pdmgl")
    public String pdmgl(HttpSession session) {
        return "pdmglsh";
    }

    @RequestMapping("/nnlist")
    public String nnlist(HttpSession session) {
        return "ynn/ynn";
    }



    //报表管理
    @RequestMapping("/tobaobiaoguanli")
    public String tobaobiaoguanli(HttpSession session) {
        return "zqy/baobiaoguanli";
    }
    //图表
    @RequestMapping("/totubiao")
    public String totubiao(HttpSession session) {
        return "zqy/tubiao";
    }



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

    @PostMapping("/pdmgll")
    @ResponseBody
    public String pdmgllRequest(@RequestBody Edi edi, HttpSession session, Model model) {
        // 在这里处理接收到的JSON数据，比如解析JSON字符串并保存到数据库中。

        if (edi != null) {
            //前端传过来的jsonDataFromTheFrontEnd值是：{"cellphone":"17687188086","vercode":"17687188086","password":"17687188086","confirmPassword":"17687188086","nickname":"17687188086","agreement":"on"}
//            System.out.println("前端传过来的jsonDataFromTheFrontEnd值是：" + jsonDataFromTheFrontEnd);
            System.out.println(edi);
            int i = ediService.addUs(edi);
            System.out.println("count:"+i);
            // 使用alibaba.fastjson对字符串进行反序列化
            // 创建一个包含多个对象的列表
            // 构造多个对象绑定的JSON格式数据,此处借用User的查询业务
            // 将对象列表转换为 JSON格式的字符串数组并返回
        } else {
            System.out.println("前端传过来的jsonDataFromTheFrontEnd值为空");
        }

        return null;// 返回成功消息给前端（仅作为示例）。在实际应用中，你可能需要返回一个包含更多信息的JSON响应对象。
    }




    @GetMapping("/edilist")
    public String getList(
            @RequestParam(defaultValue = "1") int pno,
            @RequestParam(defaultValue = "3") int pageSize,
            Edi edi, Model model) {
        PageHelper.startPage(pno, pageSize); //开始分页
        List<Edi> elist = ediService.getListEdi(edi);
        PageInfo<Edi> page = new PageInfo<Edi>(elist);
        model.addAttribute("ulist", elist); //将查询出来的数据放入model对象中
        model.addAttribute("page", page);
        model.addAttribute("name", edi.getName());
        model.addAttribute("pno", pno);
        return "lishihuiTeacherHtml/lishihuiSystemUser/lishihui_user_ulist";
    }


    @RequestMapping("/addUs")
    public String addUs(Edi edi) {
        int num = ediService.addUs(edi);
        if (num > 0)
            return "null";
        else
            return null;
    }

    @RequestMapping("/updateEdi")
    public String updateEdi(Edi edi) {
        int num = ediService.updateEdi(edi);
        if (num > 0)
            return "0";
        else
            return null;
    }


    @GetMapping("/toupdateEdi/{ddId}")
    public String toUpdate(@PathVariable("ddId") Integer ddId, Model model) {
        Edi edi = ediService.selectEdiById(ddId);
        if (edi != null) {
            model.addAttribute("edi", edi); //将查询出来的信息 传到修改页面
            return "lishihuiTeacherHtml/lishihuiSystemUser/lishihui_user_update"; //逻辑视图
        } else {
            System.out.println("空的");
            return null;
        }
    }

}
