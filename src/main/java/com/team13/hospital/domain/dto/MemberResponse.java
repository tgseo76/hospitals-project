package com.team13.hospital.domain.dto;

import com.team13.hospital.domain.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class MemberResponse {
    private Long id;
    private boolean admin;
    private String name;
    private int age;

    public static MemberResponse of(Member entity) {
        return MemberResponse.builder()
                .id(entity.getId())
                .admin(entity.isAdmin())
                .name(entity.getName())
                .age(entity.getAge())
                .build();
    }
}
