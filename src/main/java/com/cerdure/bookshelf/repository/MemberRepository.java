package com.cerdure.bookshelf.repository;


import com.cerdure.bookshelf.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    public List <Member> findByName(String name);
    public List <Member> findByPhone(String phone);
}
