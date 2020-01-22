package com.orypeu.excellent_course.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName JumpTest
 * @Description TODO
 * @Author LJH
 * @Date 2020/1/21 15:00
 * @Version 1.0
 */
@Controller
@RequestMapping("/test")
public class JumpTest {

    @RequestMapping("/jump")
    public String testJump(){
        return "test";
    }
}
