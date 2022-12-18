package com.cerdure.bookshelf.vo;

import lombok.Data;

@Data
public class BookVo {
    private String name;
    private String sortOrder;
    private Integer page;
}
