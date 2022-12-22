package com.cerdure.bookshelf.domain.book;

import com.cerdure.bookshelf.domain.board.Review;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private Long id;
    private String name;
    private String imgPath;
    private String author;
    private String publisher;
    private LocalDate publishDate;
    private String ISBN;
    private Integer originPrice;
    private Integer discountRate;
    private Integer discountPrice;
    private Integer stock;
    private Integer sales;
    private Integer rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE)
    private List<Review> reviews = new ArrayList<>();

    @Size(max = 3000)
    private String intro;
    @Size(max = 3000)
    private String bookIndex;
    @Size(max = 3000)
    private String publisherReview;

    @PrePersist
    public void prePersist() {
        Long isbnRandomRate = 1000000000000L;
        Long isbnRandomMin = 9000000000000L;
        String randomISBN = new BigDecimal(
                Double.parseDouble(
                        String.valueOf(
                                Math.floor(
                                        Math.random() * isbnRandomRate + isbnRandomMin)))).toString();
        int randomYear = (int)(Math.random()*3)+2020;
        int randomMonth = (int)(Math.random()*10)+3;
        int randomDay = (int)(Math.random()*30)+1;
        String randomDateStr = randomYear + "." + (randomMonth < 10 ? "0" + randomMonth : randomMonth) + "." + (randomDay < 10 ? "0" + randomDay: randomDay);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate randomDate = LocalDate.parse(randomDateStr, formatter);

        this.author = this.author == null ? randomName() : this.author;
        this.ISBN = this.ISBN == null ? randomISBN : this.ISBN;
        this.publishDate = this.publishDate == null ? randomDate : this.publishDate;
        this.publisher = this.publisher == null ?
                (this.name.length() > 6 ? this.name.substring(0,5) + " 출판사" : this.name + " 출판사") : this.publisher;
        this.originPrice = this.originPrice == null ? (int)(Math.random()*29+7)*1000 : this.originPrice;
        this.discountRate = this.discountRate == null ? (int)(Math.random()*6)*10 : this.discountRate;
        this.discountPrice = this.discountPrice == null ? this.originPrice*(100-this.discountRate)/100 : this.discountPrice;
        this.stock = this.stock == null ? 20 : this.stock;
        this.sales = this.sales == null ? (int)(Math.random()*100+1) : this.sales;
        this.rating = this.rating == null ? (int)(Math.random()*5+1) : this.rating;
        this.intro = this.intro == null ? this.name+" 책 소개" : this.intro;
        this.bookIndex = this.bookIndex == null ? this.name+" 목차" : this.bookIndex;
        this.publisherReview = this.publisherReview == null ? this.name+" 서평" : this.publisherReview;
    }

    @Builder
    public Book(Long id, String name, String imgPath, Category category, String author, String publisher, LocalDate publishDate, String ISBN, Integer originPrice, Integer discountRate, Integer discountPrice, Integer stock, Integer sales, Integer rating, String intro, String bookIndex, String publisherReview) {
        this.id = id;
        this.name = name;
        this.imgPath = imgPath;
        this.category = category;
        this.author = author;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.ISBN = ISBN;
        this.originPrice = originPrice;
        this.discountRate = discountRate;
        this.discountPrice = discountPrice;
        this.stock = stock;
        this.intro = intro;
        this.bookIndex = bookIndex;
        this.publisherReview = publisherReview;
        this.sales = sales;
        this.rating = rating;
    }

    public static String randomName() {
        List<String> 성 = Arrays.asList("김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황");
        List<String> 이름 = Arrays.asList("경", "관", "규", "근", "기", "길", "나", "단", "달", "담", "대", "덕", "명", "문", "민",
                                         "백", "범", "병", "서", "석", "선", "설", "섭", "성", "수", "승", "시", "신", "아", "안",
                                         "애", "연", "영", "예", "오", "옥", "완", "원", "유", "윤", "이", "익", "인", "일", "재",
                                         "전", "정", "주", "준", "중", "지", "진", "찬", "창", "태", "하", "한", "해", "혁", "현",
                                         "형", "혜", "호", "홍", "효", "훈", "휘", "희");
        Collections.shuffle(성);
        Collections.shuffle(이름);
        return 성.get(0) + 이름.get(0) + 이름.get(1);
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
