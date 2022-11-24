package com.team13.hospital.controller;

import com.team13.hospital.domain.dto.MemberRequest;
import com.team13.hospital.domain.dto.MemberResponse;
import com.team13.hospital.domain.entity.Member;
import com.team13.hospital.service.MemberService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

//    @GetMapping("/{id}")
//    public Member get(@PathVariable("id") Long id) {
//        return memberService.findById(id);
//    }

    //dto -> 반환타입 수정
    @GetMapping("/{id}")
    public MemberResponse get(@PathVariable("id") Long id) {
        return memberService.findById(id);
    }

    @PostMapping("")
    public MemberResponse creat(@RequestBody MemberRequest memberRequest){ // 전송버튼 x -> @requestBody 전송버튼o ->MemberRequest memberRequest
        return memberService.creat(memberRequest);
    }


}
