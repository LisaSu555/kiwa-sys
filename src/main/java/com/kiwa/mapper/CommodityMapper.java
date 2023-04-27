package com.kiwa.mapper;

import com.kiwa.domain.Commodity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author hp
* @description 针对表【commodity(商品)】的数据库操作Mapper
* @createDate 2023-04-27 10:54:58
* @Entity com.kiwa.domain.Commodity
*/
@Repository
public interface CommodityMapper extends BaseMapper<Commodity> {

}




