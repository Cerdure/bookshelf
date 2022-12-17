package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.member.Follow;
import com.cerdure.bookshelf.domain.order.Order;
import com.cerdure.bookshelf.dto.member.FollowDto;
import com.cerdure.bookshelf.dto.order.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper extends EntityMapper<OrderDto, Order> {
    OrderMapper MAPPER = Mappers.getMapper(OrderMapper.class);
}
