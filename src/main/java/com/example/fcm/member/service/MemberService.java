package com.example.fcm.member.service;

import com.example.fcm.member.Member;
import com.example.fcm.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long registerMember(String name) {
        Member member = new Member(name);
        memberRepository.save(member);
        return member.getMemberId();
    }
}
