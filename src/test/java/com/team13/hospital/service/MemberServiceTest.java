package com.team13.hospital.service;

import com.team13.hospital.domain.dto.MemberRequest;
import com.team13.hospital.domain.dto.MemberResponse;
import com.team13.hospital.domain.entity.Member;
import com.team13.hospital.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

class MemberServiceTest {
    private final MemberRepository memberRepository = Mockito.mock(MemberRepository.class);
    private final MemberService memberService = new MemberService(memberRepository);

    @Test
    void create() {
        // given
        // 예상 입력 값 작성
        MemberRequest memberRequest = MemberRequest.builder()
                .name("홍길동")
                .address("서울")
                .phone("01011112222")
                .age(25)
                .build();
        // 예상 반환 값 작성.
        MemberResponse expected = MemberResponse.builder()
                .id(1L)
                .admin(false)
                .name("홍길동")
                .age(25)
                .build();

        given(memberRepository.save(any(Member.class))).willReturn(memberRequest.toEntity());
        given(memberRepository.existsByName("홍길동")).willReturn(false);

        // when
        MemberResponse result = memberService.create(memberRequest);

        // then
        assertEquals(expected.getName(), result.getName());
        assertEquals(expected.getAge(), result.getAge());
    }

    @Test
    @DisplayName("member 중복시 RuntimeException 발생")
    void create_member_중복() {
        MemberRequest memberRequest = MemberRequest.builder()
                .name("홍길동")
                .address("서울")
                .phone("01011112222")
                .age(25)
                .build();

        given(memberRepository.existsByName(any())).willReturn(true);

        assertThrows(IllegalArgumentException.class, () -> memberService.create(memberRequest));
    }
}