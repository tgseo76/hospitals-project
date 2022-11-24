package com.team13.hospital.domain.dto;

import com.team13.hospital.domain.entity.Member;
import lombok.*;

//사용자가 입력했을때 걸러서 저장하기 위해 사용request
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MemberRequest {
    private String name;
    private String address;
    private String phone;
    private int age;

    //static 사용하지안흥ㅁ
    public Member toEntity(){ //@RequestBody MemberRequest memberRequest 컨트롤로에 자기자신을 바꿔주는거기때문에 toentitiy()안에 인자x
        return Member.builder()
                .name(name)
                .address(address)
                .phone(phone)
                .age(age)
                .build();

    }

}
