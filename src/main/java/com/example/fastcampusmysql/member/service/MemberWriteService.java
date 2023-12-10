package com.example.fastcampusmysql.member.service;

import com.example.fastcampusmysql.member.dto.RegisterMemberCommand;
import com.example.fastcampusmysql.member.entity.Member;
import com.example.fastcampusmysql.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberWriteService {

    private final MemberRepository memberRepository;

    public Member create(RegisterMemberCommand command) {
    /*
       목표 = 회원 정보를(이메일, 닉네임, 생년월일) 등록한다.
           - 닉네임은 10자를 넘길 수 없다.

       파라미터 - memberRegisterCommand

       Member member = Member.of(memberRegisterCommand)
       memberRepository.save()
    */

    Member member = Member.builder()
            .nickname(command.nickname())
            .email(command.email())
            .birthday(command.birthday())
            .build();
    return memberRepository.save(member);
    }
}
