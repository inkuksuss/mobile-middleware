package com.middleware.mobile.domain.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {

    @Id
    private Long memberId;
}
