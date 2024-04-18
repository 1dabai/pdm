package com.szpx.controller.nn;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.szpx.entity.Nn;
import com.szpx.service.NnService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NnController {
    @Autowired
    NnService nnService;

    //查询站点
    @GetMapping("/nnlist")
    public String getList(
            @RequestParam(defaultValue = "1") int pno,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(defaultValue = "-1") int searchId,
            Nn nn, Model model) {
        PageHelper.startPage(pno, pageSize); //开始分页
        List<Nn> ulist = nnService.getListByCon(nn, searchId);
//        测试
        System.out.println("ulist = " + ulist);
        PageInfo<Nn> page = new PageInfo<Nn>(ulist);
        System.out.println("page = " + page);
        model.addAttribute("ulist", ulist); //将查询出来的数据放入model对象中
        model.addAttribute("id", nn.getId());
        System.out.println("page = " + nn.getId());
        model.addAttribute("strat", nn.getStrat());
        model.addAttribute("end", nn.getEnd());
        model.addAttribute("price", nn.getPrice());
        return "ynn/ynn";
    }

//    @GetMapping("/nnlist/search")
//    public String getListById(, Model model) {
//        PageHelper.startPage(1, 5); //开始分页
//        List<Nn> ulist = nnService.selectNnById(searchId);
////        测试
//        System.out.println("ulist = " + ulist);
//        PageInfo<Nn> page = new PageInfo<Nn>(ulist);
//        System.out.println("page = " + page);
//        model.addAttribute("ulist", ulist); //将查询出来的数据放入model对象中
//        return "ynn/ynn";
//    }

    //增加站点
    @RequestMapping("/addNn")
    public String addNn(Nn nn) {
        System.out.println("nn = " + nn);
        int num = nnService.addNn(nn);
        if (num > 0)
            return "redirect:/nnlist";
        else
            return null;
    }

    //修改站点
    @RequestMapping("/updateNn")
    public String updateNn(Nn nn) {
        System.out.println("nn = " + nn);
        int num = nnService.updateNn(nn);
        if (num > 0)
            return "redirect:/nnlist";
        else
            return null;
    }

    //删除站点
    @RequestMapping("/delNn/{id}")
    public String delNn(@PathVariable("id") Integer id) {
        System.out.println("id = " + id);
        int num = nnService.delNn(id);
        if (num > 0)
            return "redirect:/nnlist";
        else
            return null;
    }


}



