package com.orypeu.excellent_course.common.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.orypeu.excellent_course.common.annotation.Log;
import com.orypeu.excellent_course.common.entity.Tree;
import com.orypeu.excellent_course.common.utils.MD5Utils;
import com.orypeu.excellent_course.common.utils.Result;
import com.orypeu.excellent_course.common.utils.RandomValidateCodeUtil;
import com.orypeu.excellent_course.configuration.ExcellentCourseConfig;
import com.orypeu.excellent_course.system.entity.File;
import com.orypeu.excellent_course.system.entity.Menu;
import com.orypeu.excellent_course.system.entity.User;
import com.orypeu.excellent_course.system.service.IFileService;
import com.orypeu.excellent_course.system.service.IMenuService;
import com.orypeu.excellent_course.system.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.model.IModel;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/*
 * @ClassName LoginController
 * @Description TODO
 * @Author LJH
 * @Date 2020/1/20 16:35
 * @Version 1.0
 */
@Controller
public class LoginController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    ExcellentCourseConfig excellentCourseConfig;
    @Autowired
    private IUserService userService;

    @Autowired
    IMenuService menuService;

    @Autowired
    IFileService fileService;

    @GetMapping({"/", ""})
    String welcome(Model model) {
        return "redirect:/index";
    }

    @GetMapping({"/index"})
    public String index(Model model) {
        System.out.println("进来index了");
        List<Tree<Menu>> menus = menuService.listMenuTree();
        model.addAttribute("menus", menus);
        User user = (User) model.getAttribute("user");
        System.out.println("index中的：" + user.getUsername() + ": " + user.getPassword());
        System.out.println("result:" + model.getAttribute("result").toString());
        File file = fileService.selectById(user.getPicId());
        if (file != null && file.getUrl() != null) {
            if (fileService.isExist(file.getUrl())) {
                model.addAttribute("picUrl", file.getUrl());
            } else {
                model.addAttribute("picUrl", "/img/photo_s.jpg");
            }
        } else {
            model.addAttribute("picUrl", "/img/photo_s.jpg");
        }
        model.addAttribute("username", user.getUsername());
        return "index";
    }

    @RequestMapping("/login")
    public String login(String username, String password, Model model) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        System.out.println("进来login了");
        System.out.println(user.getUsername() + ": " + user.getPassword());
        if (userService.login(user)){
            System.out.println("进入登陆成功了");
            user = userService.selectById(user.getUserId());
            model.addAttribute("user", user);
            return "index";
        }
        else {
            System.out.println("进入登陆失败了");
            model.addAttribute("result", Result.error("登陆失败！请检查用户名和密码是否填写正确"));
//            return "login";
            return "index";
        }
//        System.out.println("没进到登陆判断");
//        return "index";
    }

    /*@Log("登陆")
    @PostMapping("/login")
    @ResponseBody
    Result ajaxLogin(String username, String password, String verify, HttpServletRequest request) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return null;
    }*/

    @GetMapping("/logout")
    String logout() {
//        ShiroUtils.logout();
        return "redirect:/login";
    }

    @GetMapping("/main")
    String main() {
        System.out.println("测试是否到了这里！");
        return "main";
    }

    /*
        生成验证码
    */
    @GetMapping(value = "/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            //Thread.sleep(500);
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            logger.error("获取验证码失败>>>> ", e);
        }
    }
}


