package com.szpx.controller.zrp;

import com.szpx.entity.Inquiry;
import com.szpx.service.InquiryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
//@RequestMapping("/zrp")
public class InquiryController {
    @Autowired
    private InquiryService inquiryService;

    /**
     * 访问FormTableAjaxIndex
     * /lsh/toHuiHui
     *
     * @param session
     * @return RequestMapping 返回一个网页
     */
    @RequestMapping("/toinquiry")
    public String toinquiry(HttpSession session, Model model) {
        List<Inquiry> inquiryList = inquiryService.selectAllInquiry();
//        System.out.println(inquiryList.toString());
        model.addAttribute("h",inquiryList);
//        D:\demo\src\main\resources\templates\lishihuiTeacherHtml\lishihuiAjaxHtml\huihui.html
        return "zrp/inquiry";
    }
    @RequestMapping("/document")
    @ResponseBody
    public List<Inquiry> searchDocument(@RequestParam String inputValue) {
        List<Inquiry> searchResult = inquiryService.searchDocument(inputValue);
        return searchResult;
    }

    /**
     * 删除
     */
    @RequestMapping("/removeInquiry/{dd_id}")
    public String removeInquiry(@PathVariable("dd_id") Integer dd_id) {
        if(inquiryService.removeInquiry(dd_id)>0){
            return "redirect:/toinquiry";
        }else{
            return null;
        }
    }
    /**
     * 编辑
     */
    @RequestMapping("/editInquiry/{dd_id}")
    public String editInquiry(@PathVariable("dd_id") Integer dd_id, Model model) {
        log.info("===============");
        log.info(dd_id.toString());
        Inquiry inquiry = inquiryService.selectInquiryById(dd_id);
        log.info(inquiry.toString());
        if (inquiry != null) {
            model.addAttribute("edi", inquiry); //将查询出来的信息 传到修改页面
//            return "zrp/editInquiry"; //逻辑视图
            return "zrp/editlnquiry"; //逻辑视图
        } else {
            return null;
        }
    }

    @RequestMapping("/updateInquiry")
    public String updateInquiry( Inquiry inquiry) {
        int num = inquiryService.updateInquiry(inquiry);
        if (num > 0){
            return "redirect:/toinquiry";
        }else{

        }  return null;
    }





}

