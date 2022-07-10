package com.suunto.store;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import com.suunto.store.pojo.SysRegion;
import com.suunto.store.service.SysRegionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
class SuuntoStoreApplicationTests {

    @Autowired
    private SysRegionService sysRegionService;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${apis.map.url}")
    private String mapsUrl;
    @Value("${apis.map.key}")
    private String mapKey;



    @Test
    void contextLoads() {
    }

    @Test
    public Object syncSysAreaData(String areaCode) {
        List<SysRegion> regionDataList = sysRegionService.getSysRegionByRegionCode(areaCode);
        // 获取腾讯地图的区域信息
        try {
            //7BOBZ-AOVWS-YH6OS-6QTRR-YRIKH-P4BIT
            Map dataMap = restTemplate.getForObject(new URI("https://apis.map.qq.com/ws/district/v1/list?key=O6FBZ-A5IKU-DPWVK-2OSF2-TUKUT-TVBWD"), Map.class);
            List<List> dataAreaList1 = (List<List>) dataMap.get("result");
            List<Map> dataAreaList = new ArrayList<>();
            dataAreaList1.forEach(data -> dataAreaList.addAll(data));
            List<String> collect = regionDataList.stream().map(data -> {
                Object o = dataAreaList.stream().filter(map -> map.get("id").equals(data.getRegionCode())).findFirst().map(location -> location.get("location")).orElse(null);
                if (o != null) {
                    Map ok = (Map) o;
                    data.setLocationLat(String.valueOf(ok.get("lat")));
                    data.setLocationLng(String.valueOf(ok.get("lng")));
                }
                StringBuilder sb = new StringBuilder();
                sb.append("INSERT INTO `sys_region` (region_id,region_name,region_short_name,region_code,region_parent_id,region_level,location_lat,location_lng) VALUES(");
                sb.append("'").append(data.getRegionId()).append("',");
                sb.append("'").append(data.getRegionName()).append("',");
                sb.append("'").append(data.getRegionShortName()).append("',");
                sb.append("'").append(data.getRegionCode()).append("',");
                sb.append("'").append(data.getRegionParentId()).append("',");
                sb.append("'").append(data.getRegionLevel()).append("',");
                sb.append("'").append(data.getLocationLat()).append("',");
                sb.append("'").append(data.getLocationLng()).append("');\n");

                return sb.toString();
            }).collect(Collectors.toList());
            // INSERT INTO `sys_region` (region_id,region_name,region_short_name,region_code,region_parent_id,region_level,location_lat,location_lng) VALUES
            //isAppend 是否追加
            FileUtil.writeLines(collect,"/Users/bingxie/Documents/Leisheng/areaMap.txt", CharsetUtil.CHARSET_UTF_8,true);
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //return dataList;
    }
}
