package com.cerdure.bookshelf.dto.order;

import com.cerdure.bookshelf.domain.book.Book;
import com.cerdure.bookshelf.domain.order.Order;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderDetailDto {

    private Long id;

    @NotBlank
    private Order order;

    @NotBlank
    private Book book;

    @NotBlank
    private Integer amount;

    @NotBlank
    private Integer price;

    @Builder
    public OrderDetailDto(Long id, Order order, Book book, Integer amount, Integer price) {
        this.id = id;
        this.order = order;
        this.book = book;
        this.amount = amount;
        this.price = price;
    }
}
