package com.middleware.mobile.web.repository;


import com.middleware.mobile.domain.entity.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Long add(Member member) {
        entityManager.persist(member);
        return member.getMemberId();
    }

    public Member find(Long id) {
        return entityManager.find(Member.class, id);
    }
}
