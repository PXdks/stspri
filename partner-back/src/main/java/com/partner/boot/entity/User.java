package com.partner.boot.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import com.baomidou.mybatisplus.annotation.TableName;
    import java.io.Serializable;
import cn.hutool.core.annotation.Alias;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

    import lombok.Getter;
    import lombok.Setter;

/**
* <p>
    * 
    * </p>
*
* @author xiaol
* @since 2023-01-25
*/
    @Getter
    @Setter
    @TableName("sys_user")
@ApiModel(value = "User对象", description = "")
    public class User implements Serializable {

    private static final long serialVersionUID = 1L;

            // id
            @ApiModelProperty("id")
            @Alias("id")
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

            // 用户名
            @ApiModelProperty("用户名")
            @Alias("用户名")
    private String username;

            // 密码
            @ApiModelProperty("密码")
            @Alias("密码")
    private String password;

            // 昵称
            @ApiModelProperty("昵称")
            @Alias("昵称")
    private String name;
}