package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.File;
import com.cerdure.bookshelf.domain.board.Review;
import com.cerdure.bookshelf.dto.FileDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-18T00:46:44+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Oracle Corporation)"
)
public class FileMapperImpl implements FileMapper {

    @Override
    public File toEntity(FileDto dto) {
        if ( dto == null ) {
            return null;
        }

        Long id = null;
        Review review = null;
        String fileName = null;
        String fullPath = null;
        String extension = null;

        File file = new File( id, review, fileName, fullPath, extension );

        return file;
    }

    @Override
    public FileDto toDto(File entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        Review review = null;
        String fileName = null;
        String extension = null;
        String fullPath = null;

        FileDto fileDto = new FileDto( id, review, fileName, extension, fullPath );

        return fileDto;
    }
}
