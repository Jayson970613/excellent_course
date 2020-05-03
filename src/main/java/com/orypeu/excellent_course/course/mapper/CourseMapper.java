package com.orypeu.excellent_course.course.mapper;

import com.orypeu.excellent_course.course.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.time.Year;
import java.util.List;

/**
 * <p>
 * 课程表 Mapper 接口
 * </p>
 *
 * @author LJH
 * @since 2020-01-21
 */
public interface CourseMapper extends BaseMapper<Course> {

	List<Year> selectYears();
}
