package com.szpx.service.impl;

import com.szpx.entity.Edi;
import com.szpx.mapper.EdiMapper;
import com.szpx.service.EdiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EdiServiceImpl implements EdiService {
    @Autowired
    private EdiMapper ediMapper;
    //这是以恶搞添加功能的接口

    @Override
    public int addUs(Edi edi) {
        return ediMapper.insertSelective(edi);
    }
    //这是测试实现重载
    @Override
    public List<Edi> selectAllEdi() {
        return ediMapper.selectAll();
    }

    //这是更新
    @Override
    public int updateEdi(Edi edi) {
        return ediMapper.updateByPrimaryKeySelective(edi);
    }
    //这是查询
    @Override
    public List<Edi> getListEdi(Edi edi) {
        return ediMapper.getAddList(edi);
    }

    @Override
    public Edi selectEdiById(Integer ddId) {
        return ediMapper.selectByPrimaryKey(ddId);
    }
}
