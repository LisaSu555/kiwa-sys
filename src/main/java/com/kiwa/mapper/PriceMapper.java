package com.kiwa.mapper;

import com.kiwa.domain.Price;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kiwa.domain.VO.PriceVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author hp
* @description 针对表【price】的数据库操作Mapper
* @createDate 2023-04-27 16:03:20
* @Entity com.kiwa.domain.Price
*/
@Repository
public interface PriceMapper extends BaseMapper<Price> {

    List<PriceVO> getPriceList();
}




