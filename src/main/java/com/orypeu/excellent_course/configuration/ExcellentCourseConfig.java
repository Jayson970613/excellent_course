package com.orypeu.excellent_course.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName ExcellentCourseConfig
 * @Description TODO
 * @Author LJH
 * @Date 2020/1/20 16:37
 * @Version 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "excellentcourse")
public class ExcellentCourseConfig {

    //上传路径
    private String uploadPath;

    private String username;

    private String password;
}
