package com.orypeu.excellent_course.system.service.impl;

import com.orypeu.excellent_course.system.entity.File;
import com.orypeu.excellent_course.system.mapper.FileMapper;
import com.orypeu.excellent_course.system.service.IFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.PrivateKey;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 文件上传 服务实现类
 * </p>
 *
 * @author LJH
 * @since 2020-01-21
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements IFileService {

    @Resource
    private FileMapper fileMapper;

    @Override
    public File selectById(long id) {
        return fileMapper.selectById(id);
    }

    @Override
    public List<File> list(Map<String, Object> map) {
        return null;
    }

    @Override
    public int count(Map<String, Object> map) {
        return 0;
    }

    @Override
    public int update(File sysFile) {
        return 0;
    }

    @Override
    public int remove(Long id) {
        return 0;
    }

    @Override
    public int batchRemove(Long[] ids) {
        return 0;
    }

    @Override
    public Boolean isExist(String url) {
        return null;
    }
}
