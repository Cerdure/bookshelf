package com.cerdure.bookshelf.domain;

import com.cerdure.bookshelf.domain.enums.Answer;
import com.cerdure.bookshelf.domain.enums.MemberGrade;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private Long id;

    private String name;

    private String imgPath;

    private Integer category;
//    1  북셸프 오리지널
//    2  시 / 에세이
//    3  소설
//    4  인문
//    5  건강
//    6  요리
//    7  경제 / 경영
//    8  자기계발
//    9  정치 / 사회
//    10  역사 / 문화
//    11  만화
//    12  컴퓨터 / IT
//    13  과학
//    14  여행
//    15  예술 / 대중문화
//    16  취미 / 실용 / 스포츠
//    17  종교
//    18  외국어
//    19  철학
//    20  어린이 / 청소년

    private String author;
    private String publisher;
    private String publishDate;
    private Double ISBN;
    private Integer originPrice;
    private Integer discountRate;
    private Integer discountPrice;
    private Integer stock;

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
        int randomYear = (int)(Math.random()*23)+2000;
        int randomMonth = (int)(Math.random()*10)+3;
        int randomDay = (int)(Math.random()*30)+1;

        this.author = this.author == null ? randomName() : this.author;
        this.ISBN = this.ISBN == null ? Math.floor(Math.random()*isbnRandomRate+isbnRandomMin) : this.ISBN;
        this.publishDate = this.publishDate == null ?
                randomYear + "." + (randomMonth < 10 ? "0" + randomMonth : randomMonth) + "." + (randomDay < 10 ? "0" + randomDay : randomDay)
                : this.publishDate;
        this.publisher = this.publisher == null ? this.name+" 출판사" : this.publisher;
        this.originPrice = this.originPrice == null ? (int)(Math.random()*29+7)*1000 : this.originPrice;
        this.discountRate = this.discountRate == null ? (int)(Math.random()*6)*10 : this.discountRate;
        this.discountPrice = this.discountPrice == null ? this.originPrice*(100-this.discountRate)/100 : this.discountPrice;
        this.stock = this.stock == null ? 20 : this.stock;
        this.intro = this.intro == null ? this.name+" 책 소개" : this.intro;
        this.bookIndex = this.bookIndex == null ? this.name+" 목차" : this.bookIndex;
        this.publisherReview = this.publisherReview == null ? this.name+" 서평" : this.publisherReview;
    }

    @Builder
    public Book(Long id, String name, String imgPath, Integer category, String author, String publisher, String publishDate, Double ISBN, Integer originPrice, Integer discountRate, Integer discountPrice, Integer stock, String intro, String bookIndex, String publisherReview) {
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

}
