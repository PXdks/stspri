package com.example.test.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.test.entity.Booklist;
import com.example.test.entity.Time;
import com.example.test.service.impl.BooklistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Xliu
 * @since 2022-02-02
 */
@RestController
@RequestMapping("/booklist")
public class BooklistController {
    @Autowired
    private BooklistServiceImpl booklistService;
@GetMapping
public IPage<Booklist> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                            @RequestParam(defaultValue = "10") Integer pageSize)
{
    IPage<Booklist> page=new Page<>(pageNum,pageSize);
    QueryWrapper queryWrapper=  new QueryWrapper<>();

    return booklistService.page(page,queryWrapper);
}

}

