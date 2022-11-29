package com.team13.hospital.service;

import com.team13.hospital.domain.dto.MemberRequest;
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
        Member member = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 멤버가 없음"));
        return MemberResponse.of(member);
    }

    public MemberResponse create(MemberRequest memberRequest) {
        if (memberRepository.existsByName(memberRequest.getName())) throw new IllegalArgumentException("이미 존재하는 이름입니다.");
        Member member = memberRepository.save(memberRequest.toEntity());
        return MemberResponse.of(member);
    }
}
