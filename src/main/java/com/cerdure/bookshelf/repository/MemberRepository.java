package com.cerdure.bookshelf.repository;

import com.cerdure.bookshelf.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member, UUID> {

    public List <Member> findById(Long id);
    public List <Member> findByName(String name);
    public List <Member> findByPhone(String phone);
}
