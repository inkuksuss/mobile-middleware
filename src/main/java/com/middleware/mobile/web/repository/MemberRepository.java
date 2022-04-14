package com.middleware.mobile.web.repository;


import com.middleware.mobile.domain.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Optional;


@Mapper
@Repository
public interface MemberRepository {

    void addMember(MemberDto memberDto) throws SQLException;

    Optional<MemberDto> findMemberByEmail(String email) throws SQLException;

    Optional<MemberDto> findMemberById(long id) throws SQLException;
}
