package com.example.test.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.test.entity.Time;
import com.example.test.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/time")
public class TimeController {
//    @Autowired
//    private TimeMapper timeMapper;
    @Autowired
    private TimeService timeService;
    @GetMapping
    public List<Time> findAll()
    {
//    List all= timeMapper.findAll();
//        return all;
        return timeService.list();
    }
    @PostMapping("/select")
    public Time get( @RequestParam String username)
    {
        QueryWrapper<Time> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username);
        return timeService.getOne(queryWrapper);
    }
    @PostMapping
    public  boolean save(@RequestBody Time time)
    {
        //更新或新增
        return timeService.saveTime(time);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id)
    {
      //  return timeMapper.deleteById(id);
        return timeService.removeById(id);
    }
    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids)
    {
        return timeService.removeByIds(ids);
    }
    //分页查询
    //分页接口路径：/time/page?pageNum= pageSize=
   // @RequestParam接受
    //limit第一个参数(pageNum-1)*pageSize,第二个参数pageSize
    @GetMapping("/page")
//    public Map<String, Object> findPage(@RequestParam Integer pageNum,
//                                        @RequestParam Integer pageSize,
//                                        @RequestParam String username)
//    {
//        pageNum=(pageNum-1)*pageSize;
//        username="%"+username+"%";
//        List<Time> data=timeMapper.selectPage(pageNum,pageSize,username);
//     Integer total=  timeMapper.selectTotal(username);
//     Map<String, Object> res=new HashMap<>();
//     res.put("total",total);
//     res.put("data",data);
//        return res;
        //分页查询mybatis-plus框架
    public IPage<Time> findPage(@RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize,
                                        @RequestParam(defaultValue = "") String username,
                                        @RequestParam(defaultValue = "" )String email)
    {
        IPage<Time> page=new Page<>(pageNum,pageSize);
      QueryWrapper queryWrapper=  new QueryWrapper<>();
      if(!"".equals(username))
      {
          queryWrapper.like("username",username);
      }
        if(!"".equals(username))
        {
            queryWrapper.like("email",email);
        }

      return timeService.page(page,queryWrapper);
    }
    @GetMapping("/export")
    public void export(HttpServletResponse response)throws  Exception{
        List<Time> list=timeService.list();
        ExcelWriter writer= ExcelUtil.getWriter(true);

        writer.addHeaderAlias("username","用户名");
        writer.addHeaderAlias("password","密码");
        writer.addHeaderAlias("email","邮箱");
        writer.addHeaderAlias("createtime","创建时间");
        writer.write(list,true);
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet; charset=UTF-8");
        String fileName= URLEncoder.encode("用户信息","UTF-8");
        response.setHeader("Content-Disposition","attachment;filename="+fileName+".xlsx");

        ServletOutputStream outputStream = response.getOutputStream();
        writer.flush(outputStream,true);
        outputStream.close();
        writer.close();

    }
    @PostMapping("/import")
    public boolean imp(MultipartFile file)throws Exception{
        InputStream inputStream=file.getInputStream();
        ExcelReader reader=ExcelUtil.getReader(inputStream);
//        List<Time> list=reader.readAll(Time.class);
//       timeService.saveBatch(list);
//       return true;
        List<List<Object>> list=reader.read(1);
        List<Time> times= CollUtil.newArrayList();
        for (List<Object> row:list)
        {
            Time time=new Time();
            time.setUsername(row.get(0).toString());
            time.setPassword(row.get(1).toString());
            time.setEmail(row.get(2).toString());
            times.add(time);
        }
        timeService.saveBatch(times);
       return true;
    }
}
