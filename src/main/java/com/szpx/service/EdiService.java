package com.szpx.service;

import com.szpx.entity.Edi;
import com.szpx.entity.User;

import java.util.List;


public interface EdiService {
    //添加接口的返回值，成功返回数值1-其他
    int addUs(Edi userId);
    //这是一个测试的接口
    List<Edi> selectAllEdi();
    //这是一个修改返回的
    int updateEdi(Edi edi);
    //这是一个分页查找的
    List<Edi> getListEdi(Edi edi);

    Edi selectEdiById(Integer ddId);

}
