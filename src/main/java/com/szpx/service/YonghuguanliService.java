package com.szpx.service;

import com.szpx.entity.User;
import com.szpx.entity.Yonghuguanli;

import java.util.List;

public interface YonghuguanliService {

    // 用户信息查找
    List<Yonghuguanli> selectAllYonghuguanli(Yonghuguanli yonghuguanli);
    List<Yonghuguanli> searchDocument(int inputValue);


    // 修改用户信息
    int updateYonghuguanli(Yonghuguanli yonghuguanli);

    // 添加用户
    int addYonghuguanli(Yonghuguanli yonghuguanli);

    // 删除用户信息
    int delYonghuguanli(Integer user_id);


//    //多条件分页模糊查
//    List<Yonghuguanli> getListByCon(Yonghuguanli yonghuguanli);



    //根据id查询用户信息
    Yonghuguanli selectbyidYonghuguanli(Integer user_id);

    Yonghuguanli selectUserById(Integer user_id);


}
