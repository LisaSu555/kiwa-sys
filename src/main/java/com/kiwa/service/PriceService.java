package com.kiwa.service;

import com.kiwa.domain.Price;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kiwa.domain.VO.PriceVO;

import java.util.List;

/**
* @author hp
* @description 针对表【price】的数据库操作Service
* @createDate 2023-04-27 16:03:20
*/
public interface PriceService extends IService<Price> {

    List<PriceVO> getPriceList();
}
