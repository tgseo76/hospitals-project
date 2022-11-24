package com.team13.hospital.service;

import com.team13.hospital.domain.dto.MemberResponse;
import com.team13.hospital.domain.entity.Member;
import com.team13.hospital.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberResponse findById(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new RuntimeException("해당 멤버가 없음"));
        return MemberResponse.of(member);
    }
}
