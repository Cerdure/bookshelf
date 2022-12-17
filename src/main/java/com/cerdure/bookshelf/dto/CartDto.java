package com.cerdure.bookshelf.dto;

import com.cerdure.bookshelf.domain.Book;
import com.cerdure.bookshelf.domain.member.Member;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class CartDto {

    private Long id;

    @NotBlank
    private Member member;

    @NotBlank
    private Book book;

    @NotBlank
    private Integer amount;

    @NotBlank
    private Integer price;

    @Builder
    public CartDto(Long id, Member member, Book book, int amount, int price) {
        this.id = id;
        this.member = member;
        this.book = book;
        this.amount = amount;
        this.price = price;
    }
}
