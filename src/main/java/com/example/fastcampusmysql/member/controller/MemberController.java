package com.example.fastcampusmysql.member.controller;

import com.example.fastcampusmysql.member.dto.MemberDto;
import com.example.fastcampusmysql.member.dto.RegisterMemberCommand;
import com.example.fastcampusmysql.member.entity.Member;
import com.example.fastcampusmysql.member.service.MemberReadService;
import com.example.fastcampusmysql.member.service.MemberWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberWriteService memberWriteService;
    private final MemberReadService memberReadService;

    @PostMapping("/members")
    public MemberDto register(@RequestBody RegisterMemberCommand command) {
        Member member = memberWriteService.register(command);
        return memberReadService.toDto(member);
    }

    @GetMapping("/members/{id}")
    public MemberDto getMember(@PathVariable Long id) {
        return memberReadService.getMember(id);
    }
}
