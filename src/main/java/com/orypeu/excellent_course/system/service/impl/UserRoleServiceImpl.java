package com.orypeu.excellent_course.system.service.impl;

import com.orypeu.excellent_course.system.entity.UserRole;
import com.orypeu.excellent_course.system.mapper.UserRoleMapper;
import com.orypeu.excellent_course.system.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与角色对应关系 服务实现类
 * </p>
 *
 * @author LJH
 * @since 2020-01-21
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
