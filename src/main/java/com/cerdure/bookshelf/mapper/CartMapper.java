package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.Book;
import com.cerdure.bookshelf.domain.Cart;
import com.cerdure.bookshelf.dto.BookDto;
import com.cerdure.bookshelf.dto.CartDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartMapper extends EntityMapper<CartDto, Cart> {
    CartMapper MAPPER = Mappers.getMapper(CartMapper.class);
}
