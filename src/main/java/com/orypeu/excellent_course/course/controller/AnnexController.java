package com.orypeu.excellent_course.course.controller;


import com.alibaba.fastjson.JSONObject;
import com.orypeu.excellent_course.common.entity.TableDataInfo;
import com.orypeu.excellent_course.common.utils.FtpUtil;
import com.orypeu.excellent_course.course.entity.Annex;
import com.orypeu.excellent_course.course.entity.Course;
import com.orypeu.excellent_course.course.service.IAnnexService;
import com.orypeu.excellent_course.course.service.ICourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author LJH
 * @since 2020-01-21
 */
@Controller
@RequestMapping("/annex")
public class AnnexController {

	@Resource
	private FtpUtil ftpUtil;

	@Resource
	private IAnnexService annexService;

	@Resource
	private ICourseService courseService;

	String prefix = "/annex/";

	@RequestMapping("/add")
	public String addAnnex(@RequestParam("courseId") String courseId, Model model) {
		Course course = courseService.getCourseById(courseId);
		model.addAttribute("course", course);
		return prefix + "upload";
	}

	@RequestMapping("/upload")
	@ResponseBody
	public JSONObject uploadAnnex(@RequestParam("files") MultipartFile[] files,
	                              @RequestParam("courseId") String courseId) {
		System.out.println("enter uploadAnnex");
		System.out.println("files: " + files);
		JSONObject jsonObject = new JSONObject();
		if (files != null || files.length != 0) {
			List<Annex> result = annexService.save(files, courseId);
			jsonObject.put("initialPreviewConfig", result);
			System.out.println(result);
		} else {
			System.out.println("没有文件！");
			jsonObject.put("error", "上传失败！");
		}

		return jsonObject;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String deleteAnnex(@RequestBody JSONObject json) {
		System.out.println("deleteAnnex传来的json: " + json);
		String annexId = json.getString("annexId");
		if (annexService.delete(annexId)) {
			return "success";
		} else {
			return "error";
		}
	}

	@RequestMapping("/annexList")
	@ResponseBody
	public TableDataInfo annexList(@RequestParam("courseId") String courseId) {
		System.out.println("courseId: " + courseId);
		TableDataInfo tableDataInfo = new TableDataInfo();
		List<Annex> annexList = annexService.getAllAnnexByCourseId(courseId);
		tableDataInfo.setTotal(annexList.size());
		tableDataInfo.setRows(annexList);
		return tableDataInfo;
	}
}
