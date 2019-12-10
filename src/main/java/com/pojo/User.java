package com.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zmf
 * @version 1.0
 * @ClassName User
 * @Description: 用户类
 * @date 2019/12/10 20:31
 */
@ApiModel(value = "用户实体类", description = "用于对用户的实体封装")
@Data
public class User {

    @ApiModelProperty(value = "用户名", example = "zmf")
    private String name;
    @ApiModelProperty(value = "邮箱", example = "123456@qq.com")
    private String email;
}
