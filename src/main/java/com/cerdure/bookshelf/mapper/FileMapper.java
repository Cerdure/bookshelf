package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.File;
import com.cerdure.bookshelf.dto.FileDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FileMapper extends EntityMapper<FileDto, File> {
    FileMapper MAPPER = Mappers.getMapper(FileMapper.class);
}
