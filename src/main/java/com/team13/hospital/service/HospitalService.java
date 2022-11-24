package com.team13.hospital.service;

import com.team13.hospital.domain.dto.HospitalResponse;
import com.team13.hospital.domain.entity.Hospital;
import com.team13.hospital.repository.HospitalRepository;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    //hospital entity
    public Hospital findById(Integer id) {
        Hospital hospital = hospitalRepository.findById(id).orElseThrow(() -> new RuntimeException("해당 병원이 없습니다."));
        return hospital;
    }

    //hospitalResponse dto
    public HospitalResponse newFind(Integer id){
        Hospital hospital=hospitalRepository.findById(id).get();
        return HospitalResponse.of(hospital);
    }
}
