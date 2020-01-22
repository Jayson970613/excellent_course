package com.orypeu.excellent_course.course.entity;

import java.time.LocalDate;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author LJH
 * @since 2020-01-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    /**
     * 1或2，1代表男，2代表女
     */
    private Integer sex;

    private LocalDate birthday;

    /**
     * 电话
     */
    private String phone;

    /**
     * 传真
     */
    private String fax;

    /**
     * 学历
     */
    private String education;

    /**
     * 学位
     */
    private String degree;

    /**
     * email
     */
    private String email;

    /**
     * 通信地址
     */
    private String address;

    /**
     * 研究方向
     */
    private String research;

    /**
     * 教学情况
     */
    private String situation;

    /**
     * 学术研究
     */
    private String academic;


}
