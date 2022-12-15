package com.cerdure.bookshelf;

import com.cerdure.bookshelf.domain.Book;
import com.cerdure.bookshelf.domain.member.Address;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.domain.order.Order;
import com.cerdure.bookshelf.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
        initService.dbInit2();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        public void dbInit1() {
            Member member = Member.builder()
                    .pw("1q2w3e4r!")
                    .name("관리자")
                    .nickname("관리자")
                    .birth("000000")
                    .phone("01000000000")
                    .address(new Address("서울","영등포구","K013"))
                    .point(1000000)
                    .regDate(LocalDate.now())
                    .build();
            em.persist(member);
        }

        public void dbInit2() {
            Member member = Member.builder()
                    .pw("1q2w3e4r!")
                    .name("테스터")
                    .nickname("테스터")
                    .birth("999999")
                    .phone("01012345678")
                    .address(new Address("서울","영등포구","K013"))
                    .point(99999)
                    .regDate(LocalDate.now())
                    .build();
            em.persist(member);
        }

    }
}
