package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.board.Review;
import com.cerdure.bookshelf.dto.board.ReviewDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReviewMapper extends EntityMapper<ReviewDto, Review> {
    ReviewMapper MAPPER = Mappers.getMapper(ReviewMapper.class);
}
