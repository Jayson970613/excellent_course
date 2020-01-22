package com.orypeu.excellent_course;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.orypeu.excellent_course.course.mapper", "com.orypeu.excellent_course.system.mapper"})
public class ExcellentCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExcellentCourseApplication.class, args);
    }

}
