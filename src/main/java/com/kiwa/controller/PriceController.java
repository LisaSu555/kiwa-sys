package com.kiwa.controller;

import com.kiwa.domain.VO.PriceVO;
import com.kiwa.service.PriceService;
import com.kiwa.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author hp
 */
@Controller
@RequestMapping("/price")
public class PriceController {
    @Autowired
    private PriceService priceService;

    @ResponseBody
    @RequestMapping("/getList")
    public Map<String,Object> getPriceListPage(){
        List<PriceVO> list = priceService.getPriceList();
        return Result.succeed(0,"查询成功",list);
    }
}
