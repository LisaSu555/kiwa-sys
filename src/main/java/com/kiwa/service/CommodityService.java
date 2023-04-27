package com.kiwa.service;

import com.kiwa.domain.Commodity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author hp
* @description 针对表【commodity(商品)】的数据库操作Service
* @createDate 2023-04-27 10:54:58
*/
public interface CommodityService extends IService<Commodity> {

    List<Commodity> getCommodityList();
}
