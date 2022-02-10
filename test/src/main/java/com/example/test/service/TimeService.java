package com.example.test.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.test.entity.Time;
import com.example.test.mapper.TimeMapper;
import org.springframework.stereotype.Service;

@Service
public class TimeService extends ServiceImpl<TimeMapper,Time> {
    public boolean saveTime(Time time) {
//        if (time.getId() == null) {
//            return save(time);
//        }
//        else{
//            return updateById(time);
//        }
        return saveOrUpdate(time);

    }

//    @Autowired
//    TimeMapper timeMapper;
//    public int save(Time time)
//    {
//        if (time.getId()==null)//id 为空为新增
//        {
//          return   timeMapper.insert(time);
//        }
//        else {//否则为更新
//         return    timeMapper.update(time);
//        }
//    }
}
