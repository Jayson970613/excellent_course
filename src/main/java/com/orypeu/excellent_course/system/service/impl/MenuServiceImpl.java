package com.orypeu.excellent_course.system.service.impl;

import com.orypeu.excellent_course.common.entity.Tree;
import com.orypeu.excellent_course.system.entity.Menu;
import com.orypeu.excellent_course.system.mapper.MenuMapper;
import com.orypeu.excellent_course.system.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 菜单管理 服务实现类
 * </p>
 *
 * @author LJH
 * @since 2020-01-21
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Override
    public Tree<Menu> getSysMenuTree(Long id) {
        return null;
    }

    @Override
    public List<Tree<Menu>> listMenuTree() {
        return null;
    }

    @Override
    public Tree<Menu> getTree() {
        return null;
    }

    @Override
    public Tree<Menu> getTree(Long id) {
        return null;
    }

    @Override
    public List<Menu> list(Map<String, Object> params) {
        return null;
    }

    @Override
    public int remove(Long id) {
        return 0;
    }

    @Override
    public int update(Menu menu) {
        return 0;
    }

    @Override
    public Menu get(Long id) {
        return null;
    }

    @Override
    public Set<String> listPerms(Long userId) {
        return null;
    }
}
