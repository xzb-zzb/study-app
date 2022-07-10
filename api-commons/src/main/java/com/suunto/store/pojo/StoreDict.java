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
 * 门店字典
 * </p>
 *
 * @author zhangbing.xie
 * @since 2022-07-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="StoreDict对象", description="门店字典")
public class StoreDict implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增ID")
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "编码")
    private String dictCode;

    @ApiModelProperty(value = "名称")
    private String dictDesc;

    @ApiModelProperty(value = "分类编码")
    private String categoryCode;

    @ApiModelProperty(value = "分类说明")
    private String categoryDesc;

    @ApiModelProperty(value = "排序编号")
    private Integer sortNo;


}
