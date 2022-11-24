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

//    public Member findById(Long id) {
//        return memberRepository.findById(id).orElseThrow(() -> new RuntimeException("해당 멤버가 없음"));
//    }

    public MemberResponse findById(Long id) { // member->memberDto
        Member member=memberRepository.findById(id).get();//.orElseThrow(() -> new RuntimeException("해당 멤버가 없음"));
        return MemberResponse.of(member); //of를 만듦
    }

    public MemberResponse creat(MemberRequest memberRequest) {
        Member member=memberRepository.save(memberRequest.toEntity()); //memberrequest가서 구현
        //reques에 맞게 저장된 값을 member에 저장
        return MemberResponse.of(member); //member에 저장된 entity를 reponsedto로 저장
    }
}
