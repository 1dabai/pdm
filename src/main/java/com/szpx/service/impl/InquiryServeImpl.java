package com.szpx.service.impl;

import com.szpx.entity.Inquiry;
import com.szpx.mapper.InquiryMapper;
import com.szpx.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InquiryServeImpl implements InquiryService {
    @Autowired
    private InquiryMapper inquiryMapper;

    @Override
    public List<Inquiry> selectAllInquiry() {
        return inquiryMapper.selectAll();
    }
    @Override
    public List<Inquiry> searchDocument(String inputValue) {
        // 在这里根据 inputValue 进行数据查询，并返回符合条件的数据
        return inquiryMapper.searchDocument(inputValue);
    }

    @Override
    public int removeInquiry(Integer dd_id) {
        return inquiryMapper.deleteByPrimaryKey(dd_id);
    }

    @Override
    public Inquiry selectInquiryById(Integer dd_id) {
        return inquiryMapper.selectByPrimaryKey(dd_id);
    }

    @Override
    public int updateInquiry(Inquiry inquiry) {
        return inquiryMapper.updateByPrimaryKeySelective(inquiry);
    }


}
