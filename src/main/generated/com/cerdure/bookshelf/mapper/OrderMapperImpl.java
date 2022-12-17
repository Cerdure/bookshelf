package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.member.Address;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.domain.order.Order;
import com.cerdure.bookshelf.domain.order.OrderDetail;
import com.cerdure.bookshelf.dto.order.OrderDto;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-18T00:46:45+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Oracle Corporation)"
)
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order toEntity(OrderDto dto) {
        if ( dto == null ) {
            return null;
        }

        Long id = null;
        Member member = null;
        String name = null;
        Address address = null;
        String phone = null;
        String requirement = null;
        int totalPrice = 0;
        LocalDateTime regDate = null;
        List<OrderDetail> orderdetails = null;

        Order order = new Order( id, member, name, address, phone, requirement, totalPrice, regDate, orderdetails );

        return order;
    }

    @Override
    public OrderDto toDto(Order entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        Member member = null;
        String name = null;
        Address address = null;
        String phone = null;
        String requirement = null;
        Integer totalPrice = null;
        LocalDateTime regDate = null;
        List<OrderDetail> orderdetails = null;

        OrderDto orderDto = new OrderDto( id, member, name, address, phone, requirement, totalPrice, regDate, orderdetails );

        return orderDto;
    }
}
