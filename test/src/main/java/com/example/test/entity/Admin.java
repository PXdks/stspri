package com.example.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "admin")
public class Admin {
    @TableId(type = IdType.AUTO)
    private int id;
    private String username;
    private String password;

}
