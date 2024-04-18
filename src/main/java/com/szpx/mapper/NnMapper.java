package com.szpx.mapper;

import com.szpx.entity.Nn;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface NnMapper extends Mapper<Nn> {
    List<Nn> getListByCon(Nn nn, int id);//多条件分页模糊查

    /**
     * 添加
     *
     * @param nn
     * @return
     */
    int addnn(Nn nn);

    /**
     * 修改
     *
     * @param nn
     * @return
     */
    int updateNoById(Nn nn);

    /**
     * 根据ID删除NN
     *
     * @param id NNid
     * @return
     */
    int deleteNnById(Integer id);

    List<Nn> selectNnById(Integer id);
}
