package com.example.fastcampusmysql.member.controller;

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
    public Member register(@RequestBody RegisterMemberCommand command) {
        return memberWriteService.create(command);
    }

    @GetMapping("/members/{id}")
    public Member getMember(@PathVariable Long id) {
        return memberReadService.getMember(id);
    }
}
