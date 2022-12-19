package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.UploadFile;
import com.cerdure.bookshelf.dto.UploadFileDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FileMapper extends EntityMapper<UploadFileDto, UploadFile> {
    FileMapper MAPPER = Mappers.getMapper(FileMapper.class);
}
