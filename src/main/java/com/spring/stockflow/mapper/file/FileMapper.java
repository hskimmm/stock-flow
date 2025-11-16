package com.spring.stockflow.mapper.file;

import com.spring.stockflow.domain.File;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {
    void insertFile(File fileVO);

    void deleteFile(Long fileId);

    List<File> getFileList(Long id);

    File getFileById(Long id);
}
