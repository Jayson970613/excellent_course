package com.orypeu.excellent_course.common.bean;

import com.orypeu.excellent_course.configuration.ApplicationContextRegister;
import com.orypeu.excellent_course.system.entity.User;
import com.orypeu.excellent_course.system.service.IMenuService;
import com.orypeu.excellent_course.system.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName UserRealm
 * @Description TODO
 * @Author LJH
 * @Date 2020/1/21 17:01
 * @Version 1.0
 */
public class UserRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        /*Long userId = ShiroUtils.getUserId();
        IMenuService menuService = ApplicationContextRegister.getBean(IMenuService.class);
        Set<String> perms = menuService.listPerms(userId);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(perms);
        return info;*/
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        Map<String, Object> map = new HashMap<>(16);
        map.put("username", username);
        String password = new String((char[]) token.getCredentials());

        IUserService userService = ApplicationContextRegister.getBean(IUserService.class);
        // 查询用户信息
        User user = userService.list(map).get(0);

        // 账号不存在
        if (user == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }

        // 密码错误
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("账号或密码不正确");
        }

        // 账号锁定
        if (user.getStatus() == 0) {
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }
}
