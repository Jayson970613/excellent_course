package com.orypeu.excellent_course.course.controller;


import com.alibaba.fastjson.JSONObject;
import com.orypeu.excellent_course.course.entity.Course;
import com.orypeu.excellent_course.course.entity.Section;
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
 * 栏目表 前端控制器
 * </p>
 *
 * @author LJH
 * @since 2020-01-21
 */
@Controller
@RequestMapping("/section")
public class SectionController {

	private String prefix = "/section/";

	@Autowired
	ISectionService sectionService;
	@Autowired
	ICourseService courseService;

	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@RequestBody Section section) {
		if (sectionService.add(section) > 0) {
			return "success";
		} else {
			return "error";
		}
	}

	@RequestMapping("/add")
	public String add(@RequestParam String courseId, Model model) {
		Course course = courseService.getCourseById(courseId);
		List<Section> parentList = sectionService.getParentSection(courseId);
		System.out.println(course);
		System.out.println(parentList);
		model.addAttribute("course", course);
		model.addAttribute("parentList", parentList);
		return prefix + "add";
	}

	@RequestMapping("/getSectionByCourse")
	@ResponseBody
	public List<Section> getSectionByCourse(@RequestBody JSONObject json) {
		String courseId = json.getString("courseId");
		List<Section> sectionList = sectionService.getSectionByCourseId(courseId);
		System.out.println(sectionList.size());
		for (Section section : sectionList) {
			System.out.println(section);
		}
		return sectionList;
	}

	@RequestMapping("/sectionList")
	@ResponseBody
	public List<Section> getSectionListByCourseId(@RequestParam String courseId) {
		List<Section> sectionList = sectionService.getSectionByCourseId(courseId);
		for (Section section : sectionList) {
			if (section.getParentId().equals("null")) {
				section.setParentId("");
			}
		}
		return sectionList;
	}

	@RequestMapping("/edit")
	public String sectionEdit(@RequestParam String id, Model model) {
		Section section = sectionService.getById(id);
		Course course = courseService.getCourseById(section.getCourseId());
		String parentId = section.getParentId();
		Section parent;
		if (parentId == null || parentId.equals("null")) {
			parent = new Section();
			parent.setParentId("null");
			parent.setName("课程顶级栏目");
		} else {
			parent = sectionService.getById(parentId);
		}
		System.out.println("parent: " + parent);
		model.addAttribute("course", course);
		model.addAttribute("section", section);
		model.addAttribute("parent", parent);
		return prefix + "edit";
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String delete(@RequestBody JSONObject json) {
		String sectionId = json.getString("sectionId");
		if (sectionService.delete(sectionId) > 0) {
			return "success";
		} else {
			return "error";
		}
	}
}
