package com.orypeu.excellent_course.system.service.impl;

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
    public User selectById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> list(Map<String, Object> map) {
        return null;
    }

    @Override
    public int count(Map<String, Object> map) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int remove(Long userId) {
        return 0;
    }

    @Override
    public int batchRemove(Long[] userIds) {
        return 0;
    }

    @Override
    public Long[] listAllDept() {
        return new Long[0];
    }

    @Override
    public User selectUserByLoginName(String userName) {
        return null;
    }

    @Override
    public boolean login(User user) {
        User userInDB = userMapper.selectById(user.getUserId());
        if (userInDB != null){
            if (userInDB.getPassword().equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }
}
