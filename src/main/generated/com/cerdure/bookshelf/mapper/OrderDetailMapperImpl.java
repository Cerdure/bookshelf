package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.Book;
import com.cerdure.bookshelf.domain.order.Order;
import com.cerdure.bookshelf.domain.order.OrderDetail;
import com.cerdure.bookshelf.dto.order.OrderDetailDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-18T20:14:59+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Oracle Corporation)"
)
public class OrderDetailMapperImpl implements OrderDetailMapper {

    @Override
    public OrderDetail toEntity(OrderDetailDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Long id = null;
        Order order = null;
        Book book = null;
        int amount = 0;
        int price = 0;

        OrderDetail orderDetail = new OrderDetail( id, order, book, amount, price );

        return orderDetail;
    }

    @Override
    public OrderDetailDto toDto(OrderDetail arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Long id = null;
        Order order = null;
        Book book = null;
        Integer amount = null;
        Integer price = null;

        OrderDetailDto orderDetailDto = new OrderDetailDto( id, order, book, amount, price );

        return orderDetailDto;
    }
}
