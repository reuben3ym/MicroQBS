package com.phlink.bus.api.common.service.impl;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.exception.FdfsServerException;
import com.github.tobato.fastdfs.service.AppendFileStorageClient;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.phlink.bus.api.common.service.FdfsStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Slf4j
@Service
public class FdfsStorageServiceImpl implements FdfsStorageService {

    @Autowired
    protected FastFileStorageClient fastFileStorageClient;
    @Autowired
    protected AppendFileStorageClient storageClient;

    private static final String GROUP = "group1";

    @Override
    public StorePath simpleUpload(InputStream inputStream, Long fileSize, String fileExtName){
        StorePath path = storageClient.uploadFile(GROUP, inputStream, fileSize, fileExtName);
        log.info("上传文件-----{}", path.getFullPath());
        return path;
    }

    @Override
    public Boolean deleteFile(String path){
        try {
            storageClient.deleteFile(GROUP, path.replace(GROUP + "/", ""));
        }catch (FdfsServerException e) {
            log.error("删除文件失败 {}", e.getMessage());
            return false;
        }
        return true;
    }

}
