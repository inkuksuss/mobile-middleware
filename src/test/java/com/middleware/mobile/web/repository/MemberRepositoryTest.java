package com.middleware.mobile.web.repository;

import com.middleware.mobile.domain.common.Authority;
import com.middleware.mobile.domain.common.Status;
import com.middleware.mobile.domain.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    void add() throws Exception{

        Member member= new Member();
        member.setMemberName("memberA");
        member.setMemberAuthority(Authority.MEMBER.getValue());
        member.setMemberStatus(Status.PUBLIC.getValue());


        Long id = memberRepository.add(member);
        Member member1 = memberRepository.find(id);


        Assertions.assertThat(member.getMemberId()).isEqualTo(member1.getMemberId());


    }

    @Test
    void find() {
    }
}