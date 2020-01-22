package com.orypeu.excellent_course.system.service;

import com.orypeu.excellent_course.common.entity.Tree;
import com.orypeu.excellent_course.system.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 菜单管理 服务类
 * </p>
 *
 * @author LJH
 * @since 2020-01-21
 */
public interface IMenuService extends IService<Menu> {

    Tree<Menu> getSysMenuTree(Long id);
    List<Tree<Menu>> listMenuTree();
    Tree<Menu> getTree();
    Tree<Menu> getTree(Long id);
    List<Menu> list(Map<String, Object> params);
    int remove(Long id);
    boolean save(Menu menu);
    int update(Menu menu);
    Menu get(Long id);
    Set<String> listPerms(Long userId);
}
