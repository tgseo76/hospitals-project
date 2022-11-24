package com.team13.hospital.repository;

import com.team13.hospital.domain.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    Optional<Hospital> findById(Integer id);
}
