package com.orypeu.excellent_course.course.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.Year;

/**
 * <p>
 * 课程表
 * </p>
 *
 * @author LJH
 * @since 2020-01-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private Year year;

    /**
     * 负责人
     */
    private String principal;

    private String college;


}
