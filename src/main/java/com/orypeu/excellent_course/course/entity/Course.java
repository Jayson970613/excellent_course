package com.orypeu.excellent_course.course.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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

    private LocalDateTime year;

    /**
     * 负责人id（教师id）
     */
    private String principalId;

    private String college;


}
