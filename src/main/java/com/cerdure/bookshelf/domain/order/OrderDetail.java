package com.cerdure.bookshelf.domain.order;

import com.cerdure.bookshelf.domain.Book;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderDetail {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_detail_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    private Integer amount;
    private Integer price;

    @Builder
    public OrderDetail(Long id, Order order, Book book, int amount, int price) {
        this.id = id;
        this.order = order;
        this.book = book;
        this.amount = amount;
        this.price = price;
    }
}
