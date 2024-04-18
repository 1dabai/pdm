package com.szpx.service;

import com.szpx.entity.Inquiry;

import java.util.List;

public interface InquiryService {
    List<Inquiry> selectAllInquiry();
    List<Inquiry> searchDocument(String inputValue);
    int removeInquiry(Integer dd_id);
    Inquiry selectInquiryById(Integer dd_id);
    int updateInquiry(Inquiry inquiry); //修改

}
