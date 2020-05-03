package com.orypeu.excellent_course.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.orypeu.excellent_course.common.utils.FtpUtil;
import com.orypeu.excellent_course.course.entity.Annex;
import com.orypeu.excellent_course.course.mapper.AnnexMapper;
import com.orypeu.excellent_course.course.service.IAnnexService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author LJH
 * @since 2020-01-21
 */
@Service
public class AnnexServiceImpl extends ServiceImpl<AnnexMapper, Annex> implements IAnnexService {

	@Resource
	private FtpUtil ftpUtil;

	@Resource
	private AnnexMapper annexMapper;

	@Override
	public List<Annex> save(MultipartFile[] files, String courseId) {
		List<Annex> result = new ArrayList<>();
		System.out.println("进入save 中的files" + files);
		for (MultipartFile uploadFile : files) {
			System.out.println("uploadFile: " + uploadFile);
			Annex annex = new Annex();
			annex.setCourseId(courseId);
			String oldName = uploadFile.getOriginalFilename();
			System.out.println("oldName: " + oldName);
			annex.setTitle(oldName);
			annex.setType(oldName.substring(oldName.lastIndexOf(".") + 1));
			//使用FTPUtils工具类生成新的文件名，新文件名 = newName + 文件后缀
			String newName = ftpUtil.getFileName();
			newName = newName + oldName.substring(oldName.lastIndexOf("."));
			annex.setName(newName);
			boolean flag = false;
			//获取上传的io流
			try {
				InputStream input = uploadFile.getInputStream();
				flag = ftpUtil.fileUpload(newName, uploadFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (flag) {
				//设置服务器文件url路径
				String url = "http://" + ftpUtil.hostname + "/" + newName;
				System.out.println("上传成功的url：" + url);
				annex.setUrl(url);
			}
			annex.setUploadTime(new Date());
			annex.setId(String.valueOf(annexMapper.insert(annex)));

			System.out.println("最终的annex：" + annex);

			result.add(annex);
		}
		return result;
	}

	@Override
	public List<Annex> getAllAnnexByCourseId(String courseId) {
		return annexMapper.selectList(new QueryWrapper<Annex>().eq("course_id", courseId));
	}

	@Override
	public boolean delete(String annexId) {
		Annex annex = annexMapper.selectById(annexId);
		if (ftpUtil.fileDelete(annex.getName()) && annexMapper.deleteById(annexId) > 0) {
			return true;
		} else {
			return false;
		}
	}
}
