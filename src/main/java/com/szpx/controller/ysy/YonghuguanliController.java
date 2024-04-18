package com.szpx.controller.ysy;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.szpx.entity.User;
import com.szpx.entity.Yonghuguanli;
import com.szpx.service.YonghuguanliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 1.测试前端使用Ajax向后台发送JSON数据，后台接收到数据。
 * 2.后台使用JSON解析前端传过来的数据后返回JSON数据给前端展示。
 */
@Controller
//@RequestMapping("/ysy")
public class YonghuguanliController {
    @Autowired
    private YonghuguanliService yonghuguanliService;


//    // 查询
//    @RequestMapping("/yhgl")
//    @ResponseBody
//    public List<Yonghuguanli> Document(@RequestParam int inputValue) {
//       // List<Yonghuguanli> searchResult = yonghuguanliService.searchDocument(inputValue);
//        List<Yonghuguanli> lists;
//        if(inputValue==0) lists = yonghuguanliService.selectAllYonghuguanli();
//        else lists = yonghuguanliService.searchDocument(inputValue);
//        return lists;
//    }
    //    这是一个输入寄送和收货的地址导向网页
    @RequestMapping("/yhgljm")
    public String pdmgl(HttpSession session,Yonghuguanli yonghuguanli, Model model) {
        List<Yonghuguanli> lists = yonghuguanliService.selectAllYonghuguanli(yonghuguanli);
       // session.setAttribute("lists", lists);
        model.addAttribute("lists", lists);
        model.addAttribute("user_name", yonghuguanli.getUser_name());
        return "ysy/Yonghuguanli.html";
    }

    //    修改用户
    @RequestMapping("/updateYonghuguanli")
    public String updateYonghuguanli(Yonghuguanli yonghuguanli) {
        int num = yonghuguanliService.updateYonghuguanli(yonghuguanli);
        if (num > 0)
            return "redirect:/yhgljm";
        else
            return null;
    }


    // 去修改界面
    @GetMapping("/toupdateYonghuguanli/{user_id}")
    public String toupdateYonghuguanli(@PathVariable("user_id") Integer user_id, Model model) {
        Yonghuguanli yonghuguanli = yonghuguanliService.selectbyidYonghuguanli(user_id);
        if (yonghuguanli != null) {
            model.addAttribute("yonghuguanli", yonghuguanli); //将查询出来的信息 传到修改页面
            return "ysy/Yonghuguanli_update.html"; //逻辑视图
        } else {
            return null;
        }
    }


    /*
     * 增加用户
     */

    @RequestMapping("/addYonghuguanli")
    public String addYonghuguanli(Yonghuguanli yonghuguanli) {
        int num = yonghuguanliService.addYonghuguanli(yonghuguanli);
        if (num > 0)
            return "redirect:/yhgljm";
        else
            return null;
    }

    /*
     * 去往添加用户页面
     */

    @RequestMapping("/toaddYonghuguanli")
    public String toaddYonghuguanli(HttpSession session) {
        return "ysy/Yonghuguanli_add";
    }


    //删除用户
    @RequestMapping("/delYonghuguanli/{user_id}")
    public String delYonghuguanli(@PathVariable("user_id") Integer user_id) {
        int num =yonghuguanliService.delYonghuguanli(user_id);
        if (num > 0)
            return "redirect:/yhgljm"; //重定向到用户列表请求
        else
            return null;
    }



}
