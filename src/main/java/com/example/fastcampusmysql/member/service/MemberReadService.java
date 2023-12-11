package com.example.fastcampusmysql.member.service;

import com.example.fastcampusmysql.member.dto.MemberDto;
import com.example.fastcampusmysql.member.entity.Member;
import com.example.fastcampusmysql.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberReadService {

    private final MemberRepository memberRepository;

    public MemberDto getMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow();
        return toDto(member);
    }

    public MemberDto toDto(Member member) {
        return new MemberDto(
            member.getId(), member.getEmail(), member.getNickname(), member.getBirthday()
        );
    }
}
