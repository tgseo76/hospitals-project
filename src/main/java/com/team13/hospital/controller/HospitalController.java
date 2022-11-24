package com.team13.hospital.controller;

import com.team13.hospital.domain.dto.HospitalResponse;
import com.team13.hospital.domain.entity.Hospital;
import com.team13.hospital.service.HospitalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalController {
    private final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

//    @GetMapping("/{id}")
//    public Hospital findById(@PathVariable("id") Integer id) {
//        return hospitalService.findById(id);
//    }

    @GetMapping("/{id}")
    public HospitalResponse newGet(@PathVariable("id") Integer id){
        return hospitalService.newFind(id);
    }


}
