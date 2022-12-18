package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.Cart;
import com.cerdure.bookshelf.domain.enums.Answer;
import com.cerdure.bookshelf.domain.enums.MemberGrade;
import com.cerdure.bookshelf.domain.member.Address;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.domain.order.Order;
import com.cerdure.bookshelf.dto.member.MemberDto;
import java.time.LocalDate;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-18T20:14:59+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Oracle Corporation)"
)
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member toEntity(MemberDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Long id = null;
        String pw = null;
        String name = null;
        String nickname = null;
        String birth = null;
        String sex = null;
        String phone = null;
        Address address = null;
        MemberGrade grade = null;
        Integer point = null;
        LocalDate regDate = null;
        Answer delflag = null;
        LocalDate delDate = null;
        Cart cart = null;
        String role = null;

        Member member = new Member( id, pw, name, nickname, birth, sex, phone, address, grade, point, regDate, delflag, delDate, cart, role );

        return member;
    }

    @Override
    public MemberDto toDto(Member arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Long id = null;
        String pw = null;
        String name = null;
        String nickname = null;
        String birth = null;
        String sex = null;
        String phone = null;
        String zipcode = null;
        String city = null;
        Address address = null;
        String street = null;
        MemberGrade grade = null;
        Integer point = null;
        LocalDate regDate = null;
        Answer delflag = null;
        LocalDate delDate = null;
        List<Order> orders = null;
        Cart cart = null;

        MemberDto memberDto = new MemberDto( id, pw, name, nickname, birth, sex, phone, zipcode, city, address, street, grade, point, regDate, delflag, delDate, orders, cart );

        return memberDto;
    }
}
