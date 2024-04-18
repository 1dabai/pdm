package com.szpx.service.impl;

import com.szpx.entity.Baobiao;
import com.szpx.mapper.BaobiaoMapper;
import com.szpx.service.BaobiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class BaobiaoServiceImpl implements BaobiaoService {

    @Autowired
    private BaobiaoMapper baobiaoMapper;

    @Override
    public List<Baobiao> getAllBaoBiao() {
        return baobiaoMapper.pilist();
    }
}
