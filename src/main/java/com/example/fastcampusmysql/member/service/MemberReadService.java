package com.example.fastcampusmysql.member.service;

import com.example.fastcampusmysql.member.entity.Member;
import com.example.fastcampusmysql.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberReadService {

    private final MemberRepository memberRepository;

    public Member getMember(Long id) {
        return memberRepository.findById(id).orElseThrow();
    }
}
