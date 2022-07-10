package com.suunto.store.controller;


import com.alibaba.fastjson.JSONObject;
import com.suunto.store.service.SysRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 地区表 前端控制器
 * </p>
 *
 * @author zhangbing.xie
 * @since 2022-07-07
 */
@RestController
@RequestMapping("/region")
public class SysRegionController {

    @Autowired
    private SysRegionService sysRegionService;

    @RequestMapping("/getRegionInfo")
    public String getRegionINfo(String areaCode) {
        return JSONObject.toJSONString(sysRegionService.getSysRegionByRegionCode(areaCode));
    }
}

