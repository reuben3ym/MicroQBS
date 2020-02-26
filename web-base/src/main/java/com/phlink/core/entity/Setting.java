package com.phlink.core.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.phlink.core.base.PhlinkBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("sys_setting")
@ApiModel(value = "配置")
@NoArgsConstructor
public class Setting extends PhlinkBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "配置值value")
    private String value;

    public Setting(String id){

        super.setId(id);
    }
}