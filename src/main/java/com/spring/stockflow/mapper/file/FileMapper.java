package com.spring.stockflow.mapper.file;

import com.spring.stockflow.domain.File;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {
    void insertFile(File fileVO);

    void deleteFile(Long fileId);
}
