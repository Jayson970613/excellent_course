package com.orypeu.excellent_course.system.service;

import com.orypeu.excellent_course.system.entity.File;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 文件上传 服务类
 * </p>
 *
 * @author LJH
 * @since 2020-01-21
 */
public interface IFileService extends IService<File> {

    File selectById(long id);
    List<File> list(Map<String, Object> map);
    int count(Map<String, Object> map);
    boolean save(File sysFile);
    int update(File sysFile);
    int remove(Long id);
    int batchRemove(Long[] ids);
    /**
     * 判断一个文件是否存在
     *
     * @param url FileDO中存的路径
     * @return
     */
    Boolean isExist(String url);
}
