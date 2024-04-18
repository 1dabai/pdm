package com.szpx.service;

import com.szpx.entity.Nn;

import java.util.List;

public interface NnService {
    List<Nn> selectNnById(Integer id);

    Nn selectUserById(Integer id);

    List<Nn> selectAllNn();

    int addNn(Nn nn);

    int delNn(Integer id);

    int updateNn(Nn nn);

    List<Nn> getListByCon(Nn nn, int searchId); //多条件分页模糊查


}

