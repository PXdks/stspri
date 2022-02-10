package com.example.test.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.test.entity.Admin;
import com.example.test.mapper.AdminMapper;

import com.example.test.service.AdminService;
import com.example.test.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminMapper adminMapper;
    @Autowired
    private AdminService adminService;

    @GetMapping("/login")

    public Admin login(@RequestBody @RequestParam String username, @RequestParam String password) {
        return adminMapper.log(username, password);
    }

    @GetMapping
    public List<Admin> findAll() {
        return adminService.list();
    }

    @PostMapping("/register")
    public Boolean Register(@RequestBody Admin admin) {
        return adminService.save(admin);
    }
    //利用QueryWrapper实现登录验证
   @PostMapping("/log")
    public Admin login(@RequestBody Admin admin)
   {
       QueryWrapper<Admin> queryWrapper=new QueryWrapper<>();
       queryWrapper.eq("username",admin.getUsername());
       queryWrapper.eq("password",admin.getPassword());
    
       Admin one= adminService.getOne(queryWrapper);
       String token= TokenUtils.genToken(one.getId().toString(),one.getPassword());
       one.setToken(token);
       return one;
       //若查询出多个记录，取其一即可通过
//       List<Admin> list=adminService.list(queryWrapper);
//       return list.size()!=0;
       //抑或抛出异常
//       try {
//           Admin one= adminService.getOne(queryWrapper);
//           return one!=null;
//       }
//       catch (Exception e)
//       {
//           return false;
//       }

   }
}
