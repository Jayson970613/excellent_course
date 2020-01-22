package com.orypeu.excellent_course.system.service;

import com.orypeu.excellent_course.system.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LJH
 * @since 2020-01-21
 */
public interface IUserService extends IService<User> {

    User selectById(Long id);
    List<User> list(Map<String, Object> map);
    int count(Map<String, Object> map);
    boolean save(User user);
    int update(User user);
    int remove(Long userId);
    int batchRemove(Long[] userIds);
    Long[] listAllDept();
    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    public User selectUserByLoginName(String userName);

    boolean login(User user);
}
