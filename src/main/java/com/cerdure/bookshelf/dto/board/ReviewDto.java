package com.cerdure.bookshelf.dto.board;


import com.cerdure.bookshelf.domain.Book;
import com.cerdure.bookshelf.domain.UploadFile;
import com.cerdure.bookshelf.domain.board.Review;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.dto.UploadFileDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewDto {

    private Long id;
    private Book book;
    private Member member;
    private String content;
    private String tag;
    private Integer rating;
    private LocalDateTime regDate;
    private List<MultipartFile> files = new ArrayList<>();

    @Builder
    public ReviewDto(Long id, Book book, Member member, String content, String tag, Integer rating, LocalDateTime regDate, List<MultipartFile> files) {
        this.id = id;
        this.book = book;
        this.member = member;
        this.content = content;
        this.tag = tag;
        this.rating = rating;
        this.regDate = regDate;
        this.files = files;
    }

    public Review toEntity(){
        return Review.builder()
                .book(this.book)
                .member(this.member)
                .content(this.content)
                .tag(this.tag)
                .rating(this.rating)
                .regDate(this.regDate)
                .build();
    }
}
