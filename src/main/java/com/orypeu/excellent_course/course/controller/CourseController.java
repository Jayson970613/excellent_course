package com.orypeu.excellent_course.course.controller;


import com.alibaba.fastjson.JSONObject;
import com.orypeu.excellent_course.common.entity.TableDataInfo;
import com.orypeu.excellent_course.course.entity.Annex;
import com.orypeu.excellent_course.course.entity.Course;
import com.orypeu.excellent_course.course.entity.Section;
import com.orypeu.excellent_course.course.service.IAnnexService;
import com.orypeu.excellent_course.course.service.ICourseService;
import com.orypeu.excellent_course.course.service.ISectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 课程表 前端控制器
 * </p>
 *
 * @author LJH
 * @since 2020-01-21
 */
@Controller
@RequestMapping("/course")
public class CourseController {

	private String prefix = "/course/";

	@Autowired
	ICourseService courseService;

	@Autowired
	ISectionService sectionService;

	@Autowired
	IAnnexService annexService;

	@RequestMapping("/insert")
	public String insertCourse(@RequestBody Course course) {
		System.out.println(course.toString());
		if (courseService.add(course) > 0) {
			return prefix + "list";
		} else {
			return "error/error";
		}
	}

	@RequestMapping("/add")
	public String addCourse() {
		return prefix + "add";
	}

	@RequestMapping("/main")
	public String courseMain(@RequestParam String id, Model model) {
		Course course = courseService.getCourseById(id);
		List<Section> parentList = sectionService.getParentSection(id);
		List<List<Section>> sectionList = sectionService.getSectionListByParent(parentList);
		List<Annex> annexList = annexService.getAllAnnexByCourseId(id);
		model.addAttribute("course", course);
		model.addAttribute("parentList", parentList);
		model.addAttribute("sectionList", sectionList);
		model.addAttribute("annexList", annexList);

		return prefix + "main";
	}

	@RequestMapping("/sectionDiv")
	public String sectionContent(String sectionId) {
		return prefix + "content";
	}

	@RequestMapping("/list")
	public String listCourse(Model model) {
		System.out.println("进入listCourse");
		return prefix + "list";
	}

	@RequestMapping("/courseData")
	@ResponseBody
	public TableDataInfo getCourseJson() {
		List<Course> courseList = courseService.getAllCourse();
		TableDataInfo tableDataInfo = new TableDataInfo();
		tableDataInfo.setTotal(courseList.size());
		tableDataInfo.setRows(courseList);
		return tableDataInfo;
	}

	@RequestMapping("/edit")
	public String courseEdit(@RequestParam String id, Model model) {
		Course course = courseService.getCourseById(id);
		model.addAttribute("course", course);
		return prefix + "edit";
	}

	@RequestMapping("/update")
	@ResponseBody
	public String updateCourse(@RequestBody Course course) {
		if (courseService.update(course) > 0) {
			return "success";
		} else {
			return "error";
		}
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String delete(@RequestBody JSONObject json) {
		String courseId = json.getString("courseId");
		if (courseService.delete(courseId)) {
			return "success";
		} else {
			return "error";
		}
	}
}
