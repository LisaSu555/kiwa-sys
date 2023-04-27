package com.kiwa.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kiwa.domain.Price;
import com.kiwa.domain.VO.PriceVO;
import com.kiwa.service.PriceService;
import com.kiwa.mapper.PriceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author hp
* @description 针对表【price】的数据库操作Service实现
* @createDate 2023-04-27 16:03:20
*/
@Service
public class PriceServiceImpl extends ServiceImpl<PriceMapper, Price>
    implements PriceService{

    @Autowired
    private PriceMapper priceMapper;

    @Override
    public List<PriceVO> getPriceList() {
        return priceMapper.getPriceList();
    }
}




