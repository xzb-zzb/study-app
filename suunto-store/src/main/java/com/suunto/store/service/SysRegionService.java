package com.suunto.store.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.suunto.store.pojo.SysRegion;

import java.util.List;

/**
 * <p>
 * 地区表 服务类
 * </p>
 *
 * @author zhangbing.xie
 * @since 2022-07-07
 */
public interface SysRegionService extends IService<SysRegion> {

    public List<SysRegion> getSysRegionByRegionCode(String areaCode);
}
