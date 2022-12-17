package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.order.OrderDetail;
import com.cerdure.bookshelf.domain.shelf.Bookmark;
import com.cerdure.bookshelf.dto.order.OrderDetailDto;
import com.cerdure.bookshelf.dto.shelf.BookmarkDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookmarkMapper extends EntityMapper<BookmarkDto, Bookmark> {
    BookmarkMapper MAPPER = Mappers.getMapper(BookmarkMapper.class);
}
