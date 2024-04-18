package com.szpx.service.impl;

import com.szpx.entity.Dispatch;
import com.szpx.mapper.DispatchMapper;
import com.szpx.service.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DispatchServicelmpl implements DispatchService {

    @Autowired(required = false)
    private DispatchMapper dispatchMapper;

    //查询所有的运单号信息
    @Override
    public List<Dispatch> selectAllDispatch() {
        return dispatchMapper.selectAll();
    }

    //根据运单号查询该运单详情内容
    @Override
    public Dispatch selectUserByOrderNumber(String orderNumber) {
        return dispatchMapper.selectByPrimaryKey(orderNumber);
    }

    //根据运单号进行修改
    @Override
    public int updateDispatch(Dispatch dispatch) {
        return dispatchMapper.updateByPrimaryKeySelective(dispatch);
    }

    //根据order_number 运单号进行删除的
    @Override
    public int deleteOrderNumber(String orderNumber) {
        return dispatchMapper.deleteByPrimaryKey(orderNumber);
    }

    @Override
    public int AddDispatch(Dispatch dispatch) {
        return dispatchMapper.insert(dispatch);
    }


}




