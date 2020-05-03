package com.orypeu.excellent_course.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orypeu.excellent_course.course.entity.Course;
import com.orypeu.excellent_course.course.entity.Section;
import com.orypeu.excellent_course.course.mapper.CourseMapper;
import com.orypeu.excellent_course.course.mapper.SectionMapper;
import com.orypeu.excellent_course.course.service.ICourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Year;
import java.util.List;

/**
 * <p>
 * 课程表 服务实现类
 * </p>
 *
 * @author LJH
 * @since 2020-01-21
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

	@Resource
	CourseMapper courseMapper;
	@Resource
	SectionMapper sectionMapper;

	@Override
	public int add(Course course) {
		return courseMapper.insert(course);
	}

	@Override
	public int update(Course course) {
		return courseMapper.update(course, new QueryWrapper<Course>().eq("id", course.getId()));
	}

	@Override
	public boolean delete(String id) {
		boolean flag = false;
		if (courseMapper.deleteById(id) > 0){
			QueryWrapper<Section> queryWrapper = new QueryWrapper<Section>().eq("course_id", id);
			sectionMapper.delete(queryWrapper);
			flag = true;
		}
		return flag;
	}

	@Override
	public int deleteById(String id) {
		return courseMapper.deleteById(id);
	}

	@Override
	public List<Course> getAllCourse() {
		return courseMapper.selectList(null);
	}

	@Override
	public List<Course> getCourseByYear(String year) {
		Year myYear = Year.parse(year);
		return courseMapper.selectList(new QueryWrapper<Course>().eq("year", myYear));
	}

	@Override
	public List<Year> getAllYears() {
		return courseMapper.selectYears();
	}

	@Override
	public Course getCourseById(String id) {
		return courseMapper.selectById(id);
	}
}
