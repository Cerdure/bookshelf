package com.cerdure.bookshelf.domain;

import com.cerdure.bookshelf.domain.board.Review;
import com.cerdure.bookshelf.domain.enums.Answer;
import com.cerdure.bookshelf.domain.enums.MemberGrade;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
    public Book(Long id, String name, String imgPath, Integer category, String author, String publisher, LocalDate publishDate, String ISBN, Integer originPrice, Integer discountRate, Integer discountPrice, Integer stock, Integer sales, Integer rating, String intro, String bookIndex, String publisherReview) {
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

    public String getCategoryToString() throws Exception{
        switch (this.category){
            case 1: return "북셸프 오리지널";
            case 2: return "시 / 에세이";
            case 3: return "소설";
            case 4: return "인문";
            case 5: return "건강";
            case 6: return "요리";
            case 7: return "경제 / 경영";
            case 8: return "자기계발";
            case 9: return "정치 / 사회";
            case 10: return "역사 / 문화";
            case 11: return "만화";
            case 12: return "컴퓨터 / IT";
            case 13: return "과학";
            case 14: return "여행";
            case 15: return "예술 / 대중문화";
            case 16: return "취미 / 실용 / 스포츠";
            case 17: return "종교";
            case 18: return "외국어";
            case 19: return "철학";
            case 20: return "어린이 / 청소년";
            default: throw new Exception("일치하는 카테고리가 없습니다.");
        }
    }



}
