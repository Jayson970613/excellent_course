package com.orypeu.excellent_course.system.controller;


import com.alibaba.fastjson.JSONObject;
import com.orypeu.excellent_course.common.utils.RandomValidateCodeUtil;
import com.orypeu.excellent_course.course.entity.Course;
import com.orypeu.excellent_course.course.service.ICourseService;
import com.orypeu.excellent_course.system.entity.User;
import com.orypeu.excellent_course.system.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Year;
import java.util.List;

/**
 * <p>
 * 前台控制器
 * </p>
 *
 * @author LJH
 * @since 2020-01-21
 */
@Controller
public class ReceptionController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ICourseService courseService;

	@Autowired
	IUserService userService;

	@RequestMapping("/coursesInYear")
	@ResponseBody
	public List<Course> getCourseByYear(@RequestBody JSONObject json) {
		System.out.println("进入getCourseByYear");
		System.out.println("json: " + json);
		String year = json.getString("year");
		List<Course> courseList = courseService.getCourseByYear(year);
		for (Course course : courseList) {
			System.out.println(course);
		}
		return courseList;
	}

	@RequestMapping({"/index", "/"})
	public String index(Model model) {
		List<Year> years = courseService.getAllYears();
		for (Year year : years) {
			System.out.println(year);
		}
		List<Course> courseList = courseService.getCourseByYear(years.get(0).toString());
		for (Course course : courseList) {
			System.out.println(course);
		}
		model.addAttribute("years", years);
		model.addAttribute("courseList", courseList);
		return "index";
	}

	@RequestMapping("/admin")
	public String admin() {
		return "login";
	}

	@RequestMapping("/login")
	@ResponseBody
	public String login(@RequestBody JSONObject jsonObject) {
		System.out.println("登陆传来的json：" + jsonObject);
		String userName = jsonObject.getString("username");
		String password = jsonObject.getString("password");
		User user = new User();
		user.setUsername(userName);
		user.setPassword(password);
		if (userService.login(user)) {
			return "success";
		} else {
			return "error";
		}
	}

	/**
	 * 生成验证码
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
