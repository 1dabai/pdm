package com.szpx.mapper;

import com.szpx.entity.Baobiao;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;

public interface BaobiaoMapper extends Mapper<Baobiao> {
    List<Baobiao> pilist();//多条件分页模糊查找

}
