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
public class Annex implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String sectionId;

    private String title;

    private String name;

    private LocalDate uploadTime;

    private String path;


}
