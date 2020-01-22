package com.orypeu.excellent_course.course.service.impl;

import com.orypeu.excellent_course.course.entity.Course;
import com.orypeu.excellent_course.course.mapper.CourseMapper;
import com.orypeu.excellent_course.course.service.ICourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
