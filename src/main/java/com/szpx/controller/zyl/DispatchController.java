package com.szpx.controller.zyl;

import com.szpx.entity.Dispatch;
import com.szpx.service.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 1.测试前端使用Ajax向后台发送JSON数据，后台接收到数据。
 * 2.后台使用JSON解析前端传过来的数据后返回JSON数据给前端展示。
 */

@Controller
//@RequestMapping("/zyl")
public class DispatchController {

    @Autowired
    private DispatchService dispatchService;


    /**
     * 派件订单全部内容
     * @param session
     * @return RequestMapping 返回一个网页
     */
    /**
     * 根据按钮返回页所要展示的主要页面内容*/
    @RequestMapping("/toDispatch")
    public String toDispatch(HttpSession session, Model model) {
        //执行查询数据库的所有内容
        List<Dispatch> dispatchList = dispatchService.selectAllDispatch();
        //打印查询后的内容
//        System.out.println(dispatchList.toString());
        //把执行后的内容交给model对象保存，名称叫做toDispatchList
        model.addAttribute("toDispatchList",dispatchList);
        return "zyl/DispatchList";
    }

    /**
     * 派件订单详情
     * 根据运单号查询该订单的详情
     * @param OrderNumber 前端根据按钮获取的运单号
     * @param model
     * @return
     */
    @GetMapping("/selectByOrderNumber/{orderNumber}")
    public String selectByOrderNumber(@PathVariable("orderNumber") String OrderNumber, Model model) {
        //测试是否能正常接收值
//        System.out.println(OrderNumber);
        //根据运单号查询当前订单的派件信息
        Dispatch dispatch = dispatchService.selectUserByOrderNumber(OrderNumber);
        //测试执行后时候保存有内容
//        System.out.println(dispatch);

        //查询结果如果不为空就把内容交给model对象保存，并跳转页面到zyl文件下下面的Dispatch_detail.html页面
        if (dispatch != null) {
            model.addAttribute("dispatch", dispatch);
            return "zyl/DispatchDetail";
        } else {
            //如果为空，则跳转到error文件夹中的notFound.html
            return "zyl/error/notFound";
        }
    }

    /**
     * 派件订单修改详情页面
     * 根据运单号查询该订单的详情后进行修改
     * @param OrderNumber 前端根据按钮获取的运单号
     * @param model
     * @return
     */
    @GetMapping("/toUpdateDispatch/{orderNumber}")
    public String toUpdateDispatch(@PathVariable("orderNumber") String OrderNumber, Model model) {
        //测试是否能正常接收值
//        System.out.println(OrderNumber);
        //根据运单号查询当前订单的派件信息
        Dispatch dispatch = dispatchService.selectUserByOrderNumber(OrderNumber);
        //测试执行后时候保存有内容
//        System.out.println(dispatch);
        //查询结果如果不为空就把内容交给model对象保存，并跳转页面到zyl文件下下面的Dispatch_detail.html页面
        if (dispatch != null) {
            model.addAttribute("dispatch", dispatch);
            return "zyl/DispatchUpdate";
        } else {
            //如果为空，则跳转到error文件夹中的notFound.html
            return "zyl/error/notFound";
        }
    }

    /**
     * 派件详情修改页面提交
     * 修改派件订单详情页面提交时内容
     * @param dispatch
     * @return
     */
    @RequestMapping("/updateDispatch")
    public String updateDispatch(Dispatch dispatch) {
        //前端派件修改页面提交修改对象进行修改，修改成功用num接受
        int num = dispatchService.updateDispatch(dispatch);
        //当修改成功时，num得到1，然后重新返回派件管理页面，如果修改不成功，则跳转到错误页面
        if (num > 0)
            return "redirect:/toDispatch"; //重定向：派件管理
        else
            return "zyl/error/notFound";
    }


    /**
     * 删除当前派单信息
     * 根据order_number删除派单信息
     * @param OrderNumber
     * @return
     */
    @RequestMapping("/delDispatch/{orderNumber}")
    public String delUser(@PathVariable("orderNumber") String OrderNumber) {
        //根据前端传送的运单号来进行删除功能
        int num = dispatchService.deleteOrderNumber(OrderNumber);
        //当删除成功时，num得到1，然后重新返回派件管理页面，如果删除不成功，则跳转到错误页面
        if (num > 0)
            return "redirect:/toDispatch"; //重定向：派件管理
        else
            return "zyl/error/notFound";
    }

    /**
     * 跳转到新增派件页面
     * @param model
     * @return
     */
    @RequestMapping("/toAddDispatch")
    public String toAddDispatch(Model model){
        //设置以当前时间作为运单号前14位数
        String StrDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());;
        //生成两位数的随机数
        int ran = new Random().nextInt(90)+10;
        //时间和随机数拼接成16位数的运单号
        String orderNumber = StrDate + ran;
        //生成派单对象
        Dispatch dispatch = new Dispatch();
        //把生成浩的运单号交给对象中order_number保存
        dispatch.setOrder_number(orderNumber);
        //把运单号交给前端，
        model.addAttribute("newDispatch",dispatch);
        return "zyl/DispatchAdd";
    }

    /**
     * 新增派件页面提交
     * 新增派件订单详情页面提交时内容
     * @param dispatch
     * @return
     */
    @RequestMapping("/AddDispatch")
    public String AddDispatch(Dispatch dispatch) {
        //前端派件新增页面提交，执行成功后交给num接受
        int num = dispatchService.AddDispatch(dispatch);
        //当新增成功时，num得到1，然后重新返回派件管理页面，如果新增不成功，则跳转到错误页面
        if (num > 0)
            return "redirect:/toDispatch"; //重定向：派件管理
        else
            return "zyl/error/notFound";
    }

}

