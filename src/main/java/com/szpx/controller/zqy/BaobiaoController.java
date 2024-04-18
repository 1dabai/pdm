package com.szpx.controller.zqy;

import com.szpx.entity.Baobiao;
import com.szpx.service.BaobiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 1.测试前端使用Ajax向后台发送JSON数据，后台接收到数据。
 * 2.后台使用JSON解析前端传过来的数据后返回JSON数据给前端展示
 */


@Controller
@RequestMapping("BaoBiao")
public class BaobiaoController {

    @Autowired
    private BaobiaoService baobiaoService;

    @RequestMapping("/toBaoBiao")
    public String tomlc(HttpSession session, Model model){
        List<Baobiao> pilist = baobiaoService.getAllBaoBiao();

        System.out.println("控制器中获得的Baobiao的数据是：" + pilist.toString());

        return "stuHtal/mlc*";
    }

}