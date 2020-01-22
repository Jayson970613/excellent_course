package com.orypeu.excellent_course.system.service.impl;

import com.orypeu.excellent_course.system.entity.Log;
import com.orypeu.excellent_course.system.mapper.LogMapper;
import com.orypeu.excellent_course.system.service.ILogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统日志 服务实现类
 * </p>
 *
 * @author LJH
 * @since 2020-01-21
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {

}
