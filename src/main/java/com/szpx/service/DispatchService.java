package com.szpx.service;

import com.szpx.entity.Dispatch;
import com.szpx.entity.User;


import java.util.List;


public interface DispatchService {
    List<Dispatch> selectAllDispatch();


    Dispatch selectUserByOrderNumber(String orderNumber);

    int updateDispatch(Dispatch dispatch);

    int deleteOrderNumber(String orderNumber);

    int AddDispatch(Dispatch dispatch);
}