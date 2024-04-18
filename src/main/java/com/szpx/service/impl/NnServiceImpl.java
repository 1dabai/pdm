package com.szpx.service.impl;

import com.szpx.entity.Nn;
import com.szpx.mapper.NnMapper;
import com.szpx.service.NnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NnServiceImpl implements NnService {
    @Autowired
    private NnMapper nnMapper;

    @Override
    public List<Nn> selectNnById(Integer id) {
        return nnMapper.selectNnById(id);
    }

    @Override
    public Nn selectUserById(Integer id) {
        return null;
    }

    @Override
    public List<Nn> selectAllNn() {
        return null;
    }

    @Override
    public int addNn(Nn nn) {
        int row = nnMapper.addnn(nn);
        return row;

    }

    @Override
    public int delNn(Integer id) {
        return nnMapper.deleteNnById(id);
    }

    @Override
    public int updateNn(Nn nn) {
        System.out.println("nnserver = " + nn);
        int row = nnMapper.updateNoById(nn);
        System.out.println("row = " + row);
        return row;
    }

    @Override
    public List<Nn> getListByCon(Nn nn, int id) {
        if (id == -1) {
            return nnMapper.getListByCon(nn, id);
        } else {
            return nnMapper.selectNnById(id);
        }
    }

}
