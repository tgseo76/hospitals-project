package com.team13.hospital.domain.dto;


import com.team13.hospital.domain.entity.Hospital;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HospitalResponse {
    private String name;
    private String phone;
    private String road_address;
    private String address;

    public static HospitalResponse of(Hospital hospital){
        return HospitalResponse.builder()
                .name(hospital.getHospitalName())
                .phone(hospital.getPhone())
                .road_address(hospital.getRoadNameAddress())
                .address(hospital.getFullAddress())
                .build();

    }

}
