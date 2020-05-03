package com.orypeu.excellent_course.course.service;

import com.orypeu.excellent_course.course.entity.Annex;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LJH
 * @since 2020-01-21
 */
public interface IAnnexService extends IService<Annex> {

	List<Annex> save(MultipartFile[] files, String courseId);
	List<Annex> getAllAnnexByCourseId(String courseId);

	boolean delete(String annexId);
}
