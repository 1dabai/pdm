package com.szpx.mapper;

import com.szpx.entity.Edi;
import com.szpx.entity.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface EdiMapper extends Mapper<Edi>{
    //这是实现分类查找功能的接口，上面是接口继承到edi实现类
    List<Edi> getAddList(Edi ddId);
    Edi selectEdiById(Integer ddId);
}
