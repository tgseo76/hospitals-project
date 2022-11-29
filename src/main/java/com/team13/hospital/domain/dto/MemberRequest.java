package com.team13.hospital.domain.dto;

import com.team13.hospital.domain.entity.Member;
import lombok.*;

@Builder
@AllArgsConstructor
@Getter
public class MemberRequest {
    private String name;
    private String address;
    private String phone;
    private int age;

    public Member toEntity() {
        return Member.builder()
                .name(name)
                .address(address)
                .phone(phone)
                .age(age)
                .build();
    }
}
