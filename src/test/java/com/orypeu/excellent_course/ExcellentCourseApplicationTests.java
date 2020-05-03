package com.orypeu.excellent_course;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.orypeu.excellent_course.system.entity.User;
import com.orypeu.excellent_course.system.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ExcellentCourseApplicationTests {

    @Resource
    private UserMapper userMapper;
    @Test
    void contextLoads() {
    }

    @Test
    void dbTest(){
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", "admin"));
        System.out.printf(user.getPassword());
    }

}
