package com.cerdure.bookshelf.domain;

import com.cerdure.bookshelf.domain.enums.MemberGrade;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Trend {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trend_id")
    private Long id;
    private String searchData;
    private Integer count;

    @PrePersist
    public void prePersist() {
        this.count = this.count == null ? 1 : this.count;
    }

    @Builder
    public Trend(Long id, String searchData, Integer count) {
        this.id = id;
        this.searchData = searchData;
        this.count = count;
    }

    public void countPlus(){
        this.count++;
    }
}
