package com.staya.spring.rest.hospital.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.staya.spring.rest.hospital.hospitalentity.HospitalEntity;

@Repository
public interface HospitalRepository extends JpaRepository<HospitalEntity, Long>{

	Optional<List<HospitalEntity>> getByLocation(String location);
	
	
	Optional<List<HospitalEntity>> findByRatingBetween(double minRating, double maxRating);
	

}
