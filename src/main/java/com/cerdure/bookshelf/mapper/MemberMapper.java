package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.dto.member.MemberDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper extends EntityMapper<MemberDto, Member> {
    MemberMapper MAPPER = Mappers.getMapper(MemberMapper.class);
}
