package com.orypeu.excellent_course.database;

import com.orypeu.excellent_course.system.entity.User;
import com.orypeu.excellent_course.system.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName DBTest
 * @Description TODO
 * @Author Cucumber
 * @Date 2020/2/10
 * @Version 1.0
 **/
public class DBTest {
	@Autowired
	public static UserServiceImpl userService;
	public static void main(String[] args) {
		/*User user = userService.selectUserByLoginName("orypeu");
		System.out.println(user);*/
	}
}
