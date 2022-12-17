package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.order.Order;
import com.cerdure.bookshelf.domain.order.OrderDetail;
import com.cerdure.bookshelf.dto.order.OrderDetailDto;
import com.cerdure.bookshelf.dto.order.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderDetailMapper extends EntityMapper<OrderDetailDto, OrderDetail> {
    OrderDetailMapper MAPPER = Mappers.getMapper(OrderDetailMapper.class);
}
