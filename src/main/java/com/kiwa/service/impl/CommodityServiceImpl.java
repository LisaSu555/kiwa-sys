package com.kiwa.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kiwa.domain.Commodity;
import com.kiwa.service.CommodityService;
import com.kiwa.mapper.CommodityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author hp
* @description 针对表【commodity(商品)】的数据库操作Service实现
* @createDate 2023-04-27 10:54:58
*/
@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements CommodityService{

    @Autowired
    private CommodityMapper commodityMapper;

    @Override
    public List<Commodity> getCommodityList() {
        QueryWrapper<Commodity> queryWrap = new QueryWrapper<>();
        queryWrap.eq("delete_flag","no");
        List<Commodity> list = commodityMapper.selectList(queryWrap);
        return list;
    }
}




