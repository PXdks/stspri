package com.example.test.service.impl;

import com.example.test.entity.Booklist;
import com.example.test.mapper.BooklistMapper;
import com.example.test.service.IBooklistService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Xliu
 * @since 2022-02-02
 */
@Service
public class BooklistServiceImpl extends ServiceImpl<BooklistMapper, Booklist> implements IBooklistService {

}
