package com.phlink.core.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.phlink.core.base.PhlinkBaseEntity;
import com.phlink.core.common.constant.CommonConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@TableName("t_role")
@ApiModel(value = "角色")
public class Role extends PhlinkBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色名 以ROLE_开头")
    private String name;

    @ApiModelProperty(value = "是否为注册默认角色")
    private Boolean defaultRole;

    @ApiModelProperty(value = "数据权限类型 0全部默认 1自定义 2本部门及以下 3本部门 4仅本人")
    private Integer dataType = CommonConstant.DATA_TYPE_ALL;

    @ApiModelProperty(value = "备注")
    private String description;

    @TableField(exist=false)
    @ApiModelProperty(value = "拥有权限")
    private List<RolePermission> permissions;

    @TableField(exist=false)
    @ApiModelProperty(value = "拥有数据权限")
    private List<RoleDepartment> departments;
}