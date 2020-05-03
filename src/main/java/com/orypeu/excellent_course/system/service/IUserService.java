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

    boolean login(User user);
}
