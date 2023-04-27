package com.kiwa.controller;

import com.kiwa.domain.Commodity;
import com.kiwa.service.CommodityService;
import com.kiwa.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author hp
 * 商品controller
 */
@Controller
@RequestMapping("/commodity")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    @GetMapping("/getList")
    @ResponseBody
    public Map<String, Object> commodityList(){
        List<Commodity> list = commodityService.getCommodityList();
        return Result.succeed(0,"ok",list);
    }
}
