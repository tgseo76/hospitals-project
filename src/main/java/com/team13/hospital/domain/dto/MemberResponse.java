package com.team13.hospital.domain.dto;


import com.team13.hospital.domain.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


//user한테 돌려주는
@Builder
@AllArgsConstructor
//@NoArgsConstructor
@Getter //객체를 json으로 바꿔주는과정에서 getter필요
public class MemberResponse {
    private Long id;
    private boolean admin; //t=관리자 f=일반
    private String name;
    private int age;

    
    //생성자를 사용하면 값이 없을때 문제가 생기지만 빌더는 null값 넣어줌
    public static MemberResponse of(Member entity){ //of라는 스태틱 변수
        return MemberResponse.builder()//시작 builder()
                //dto에 넣을 필드명 builder 값이 없으면 null
                .id(entity.getId())
                .admin(entity.isAdmin())
                .name(entity.getName())
                .age(entity.getAge())
                .build(); //마지막에는 .build()
    }


}
