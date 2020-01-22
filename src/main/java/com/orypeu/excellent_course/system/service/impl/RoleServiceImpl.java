package com.orypeu.excellent_course.system.service.impl;

import com.orypeu.excellent_course.system.entity.Role;
import com.orypeu.excellent_course.system.mapper.RoleMapper;
import com.orypeu.excellent_course.system.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author LJH
 * @since 2020-01-21
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
