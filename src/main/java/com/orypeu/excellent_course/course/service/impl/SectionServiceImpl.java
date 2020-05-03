package com.orypeu.excellent_course.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orypeu.excellent_course.course.entity.Section;
import com.orypeu.excellent_course.course.mapper.SectionMapper;
import com.orypeu.excellent_course.course.service.ISectionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 栏目表 服务实现类
 * </p>
 *
 * @author LJH
 * @since 2020-01-21
 */
@Service
public class SectionServiceImpl extends ServiceImpl<SectionMapper, Section> implements ISectionService {

	@Resource
	SectionMapper sectionMapper;

	@Override
	public int add(Section section) {
		return sectionMapper.insert(section);
	}

	@Override
	public int update(Section section) {
		return sectionMapper.updateById(section);
	}

	@Override
	public int delete(String id) {
		sectionMapper.delete(new QueryWrapper<Section>().eq("parent_id", id));
		return sectionMapper.deleteById(id);
	}

	@Override
	public List<Section> getSectionByCourseId(String courseId) {
		return sectionMapper.selectList(new QueryWrapper<Section>().eq("course_id", courseId));
	}

	@Override
	public List<List<Section>> getSectionListByParent(List<Section> parent) {
		List<List<Section>> result = new ArrayList<>();
		for (Section section : parent) {
			List<Section> temp = sectionMapper.selectList(
					new QueryWrapper<Section>().eq("parent_id", section.getId()));
			result.add(temp);
		}
		return result;
	}

	@Override
	public List<Section> getParentSection(String courseId) {
		Map<String, String> condition = new HashMap<>();
		condition.put("course_id", courseId);
		condition.put("parent_id", "null");
		return sectionMapper.selectList(new QueryWrapper<Section>().allEq(condition));
	}

	@Override
	public List<Section> getChildrenSectionByParent(String parentId) {
		List<Section> childrenList = sectionMapper.selectList(new QueryWrapper<Section>().eq("parent_id", parentId));
		return childrenList;
	}
}
