package com.suunto.store.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 地区表
 * </p>
 *
 * @author zhangbing.xie
 * @since 2022-07-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SysRegion对象", description="地区表")
public class SysRegion implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "地区主键编号")
      @TableId(value = "region_id", type = IdType.ID_WORKER_STR)
    private String regionId;

    @ApiModelProperty(value = "地区名称")
    private String regionName;

    @ApiModelProperty(value = "地区缩写")
    private String regionShortName;

    @ApiModelProperty(value = "行政地区编号")
    private String regionCode;

    @ApiModelProperty(value = "地区父id")
    private String regionParentId;

    @ApiModelProperty(value = "地区级别 1-省、自治区、直辖市 2-地级市、地区、自治州、盟 3-市辖区、县级市、县")
    private Integer regionLevel;

    @ApiModelProperty(value = "经度")
    private String locationLat;

    @ApiModelProperty(value = "纬度")
    private String locationLng;


}
