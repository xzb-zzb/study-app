package com.suunto.store.config.properties;

import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author zhangbing.xie
 * @Description：TODO 地图相关参数信息以及接口信息
 * @date 2022-07-07 15:46
 **/
public class MapsProperties {

    private static Properties prop = new Properties();

    static{
        try {
            ClassPathResource resource = new ClassPathResource("properties/maps.properties");
            InputStream in=resource.getInputStream();
            //解决中文乱码
            BufferedReader bf = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            prop.load(bf);
            in.close();
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取properties文件中的键值对
     * @param key
     * @return
     */
    public static String getPropValue(String key){
        return prop.getProperty(key);
    }
}
