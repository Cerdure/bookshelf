package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.Book;
import com.cerdure.bookshelf.domain.Cart;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.dto.CartDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-18T20:14:59+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Oracle Corporation)"
)
public class CartMapperImpl implements CartMapper {

    @Override
    public Cart toEntity(CartDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Long id = null;
        Member member = null;
        Book book = null;
        int amount = 0;
        int price = 0;

        Cart cart = new Cart( id, member, book, amount, price );

        return cart;
    }

    @Override
    public CartDto toDto(Cart arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Long id = null;
        Member member = null;
        Book book = null;
        int amount = 0;
        int price = 0;

        CartDto cartDto = new CartDto( id, member, book, amount, price );

        return cartDto;
    }
}
