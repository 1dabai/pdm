package com.szpx.mapper;

import com.szpx.entity.Inquiry;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface InquiryMapper extends Mapper<Inquiry> {
    List<Inquiry> searchDocument(String inputValue);

}
