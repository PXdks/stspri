package com.example.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.test.entity.Time;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TimeMapper  extends BaseMapper<Time> {
//    @Select("SELECT *FROM time")
//    List<Time> findAll();
//    @Insert("INSERT INTO time(username,password) VALUES(#{username},#{password})")
//    int insert(Time time);
//    int update(Time time);
//@Delete("delete from time where id=#{id}")
//    Integer deleteById(@Param("id") Integer id);
//@Select("select *from time  where username like #{username} limit #{pageNum},#{pageSize}")
//    List<Time> selectPage(Integer pageNum, Integer pageSize,String username);
//@Select("select count(*) from time where username like concat('%',#{username},'%')")
//    Integer selectTotal(String username);


}
