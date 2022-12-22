package com.cerdure.bookshelf.domain.book;

import com.cerdure.bookshelf.domain.board.Review;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {

    @Id
    @Column(name = "category_id")
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<Book> books = new ArrayList<>();

    @Builder
    public Category(Integer id, String name, List<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    public void coincidenceHighlight(String input){
            input = input.toUpperCase();
            int startIndex = this.name.toUpperCase().indexOf(input);
            int endIndex = startIndex + input.length();
            String coincidenceStr = "<strong>" + this.name.substring(startIndex, endIndex) + "</strong>";
            String prevStr = this.name.substring(0, startIndex);
            String nextStr = this.name.substring(endIndex, this.name.length());
            this.name = prevStr + coincidenceStr + nextStr;
    }
}
