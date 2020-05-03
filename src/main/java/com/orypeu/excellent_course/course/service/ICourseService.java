package com.orypeu.excellent_course.course.service;

import com.orypeu.excellent_course.course.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.orypeu.excellent_course.system.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Year;
import java.util.List;

/**
 * <p>
 * 课程表 服务类
 * </p>
 *
 * @author LJH
 * @since 2020-01-21
 */
public interface ICourseService extends IService<Course> {

	int add(Course course);
	int update(Course course);
	boolean delete(String id);
	int deleteById(String id);
	List<Course> getAllCourse();
	List<Course> getCourseByYear(String year);
	List<Year> getAllYears();
	Course getCourseById(String id);

}
