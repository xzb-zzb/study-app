package com.suunto.store.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.suunto.store.mapper.SysRegionMapper;
import com.suunto.store.pojo.SysRegion;
import com.suunto.store.service.SysRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 地区表 服务实现类
 * </p>
 *
 * @author zhangbing.xie
 * @since 2022-07-07
 */
@Service
public class SysRegionServiceImpl extends ServiceImpl<SysRegionMapper, SysRegion> implements SysRegionService {
    @Autowired
    private SysRegionMapper sysRegionMapper;

    public List<SysRegion> getSysRegionByRegionCode(String regionCode) {
        QueryWrapper<SysRegion> queryWrapper = new QueryWrapper<>();
        if (ObjectUtil.isNotEmpty(regionCode)) {
            queryWrapper.eq("region_code", regionCode);
        }
        return sysRegionMapper.selectList(queryWrapper);
    }
}
