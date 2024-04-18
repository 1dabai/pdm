package com.szpx.service.impl;

import com.szpx.entity.Yonghuguanli;
import com.szpx.mapper.YonghuguanliMapper;
import com.szpx.service.YonghuguanliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YonghuguanliServeImpl implements YonghuguanliService {
    @Autowired
    private YonghuguanliMapper yonghuguanliMapper;


//    // 用户查询
    @Override
    public List<Yonghuguanli> selectAllYonghuguanli(Yonghuguanli yonghuguanli) {

        return yonghuguanliMapper.selectAllYonghuguanli(yonghuguanli);
    }

    // 在这里根据 inputValue 进行数据查询，并返回符合条件的数据
    @Override
    public List<Yonghuguanli> searchDocument(int inputValue) {
        return yonghuguanliMapper.searchDocument(inputValue);
    }


    // 用户修改
    @Override
    public int updateYonghuguanli(Yonghuguanli yonghuguanli) {
        return yonghuguanliMapper.updateYonghuguanli(yonghuguanli);
    }


    // 用户添加
    @Override
    public int addYonghuguanli(Yonghuguanli yonghuguanli) {
        return yonghuguanliMapper.addYonghuguanli(yonghuguanli);
    }

    // 用户信息删除
    @Override
    public int delYonghuguanli(Integer user_id) {
        return yonghuguanliMapper.delYonghuguanli(user_id);
    }

    @Override
    public Yonghuguanli selectbyidYonghuguanli(Integer user_id) {
        return yonghuguanliMapper.selectbyidYonghuguanli(user_id);
    }

    // 用户信息查询
//    @Override
//    public List<Yonghuguanli> getListByCon(Yonghuguanli yonghuguanli) {
//        return YonghuguanliMapper.getListByCon(yonghuguanli);
//    }

    // 查询全部信息
    @Override
    public Yonghuguanli selectUserById(Integer user_id) {
        return null;
    }


}
