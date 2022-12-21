package com.cerdure.bookshelf.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void testMember() {
        Long isbnRandomRate = 1000000000000L;
        Long isbnRandomMin = 9000000000000L;
        System.out.println();
    }
}