package com.orypeu.excellent_course.course.service;

import com.orypeu.excellent_course.course.entity.Course;
import com.orypeu.excellent_course.course.entity.Section;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 栏目表 服务类
 * </p>
 *
 * @author LJH
 * @since 2020-01-21
 */
public interface ISectionService extends IService<Section> {

	int add(Section section);
	int update(Section section);
	int delete(String id);
	List<Section> getSectionByCourseId(String courseId);
	List<List<Section>> getSectionListByParent(List<Section> parent);
	List<Section> getParentSection(String courseId);
	List<Section> getChildrenSectionByParent(String parentId);
}
