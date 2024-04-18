package com.szpx.mapper;

import com.szpx.entity.User;
import com.szpx.entity.Yonghuguanli;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface YonghuguanliMapper extends Mapper<Yonghuguanli> {

    // 用户信息查找
    List<Yonghuguanli> selectAllYonghuguanli(Yonghuguanli yonghuguanli);
    List<Yonghuguanli> searchDocument(int inputValue);
    // 多条件分页模糊查
    int insertYonghuguanli(Yonghuguanli yonghuguanli);

    // 用户信息修改
    int updateYonghuguanli(Yonghuguanli yonghuguanli);

    // 用户信息添加
    int addYonghuguanli(Yonghuguanli yonghuguanli);

    //删除用户信息
    int delYonghuguanli(Integer id);

    //根据id查询用户信息
    Yonghuguanli selectbyidYonghuguanli(Integer user_id);

}
