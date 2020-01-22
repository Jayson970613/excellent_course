package com.orypeu.excellent_course.system.service.impl;

import com.orypeu.excellent_course.system.entity.RoleMenu;
import com.orypeu.excellent_course.system.mapper.RoleMenuMapper;
import com.orypeu.excellent_course.system.service.IRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色与菜单对应关系 服务实现类
 * </p>
 *
 * @author LJH
 * @since 2020-01-21
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {

}
