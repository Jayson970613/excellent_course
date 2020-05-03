package com.orypeu.excellent_course.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.orypeu.excellent_course.system.entity.User;
import com.orypeu.excellent_course.system.mapper.UserMapper;
import com.orypeu.excellent_course.system.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LJH
 * @since 2020-01-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean login(User user) {
        User userInDB = userMapper.selectOne(new QueryWrapper<User>().eq("username", user.getUsername()));
        System.out.println("数据库查出的user: " + userInDB);
        if (userInDB != null){
            if (userInDB.getPassword().equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }

}
