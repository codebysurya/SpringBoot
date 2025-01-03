package com.staya.spring.rest.hospital.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staya.spring.rest.hospital.hospitalentity.HospitalEntity;
import com.staya.spring.rest.hospital.repository.HospitalRepository;

@Service
public class HospitalService {
	@Autowired
	HospitalRepository hospitalRepository;

	public HospitalEntity saveHospital(HospitalEntity hospitalEntity) {
		
		 return hospitalRepository.save(hospitalEntity);


		
	}

	public List<HospitalEntity> saveAllHospitals(List<HospitalEntity> hospiList) {
		
		return hospitalRepository.saveAll(hospiList);
	}

	public List<HospitalEntity> getAllHospitals() {
		
		return hospitalRepository.findAll();
		
	}

	public Optional<HospitalEntity>getHospitalById(Long id) {
		
		return hospitalRepository.findById(id);
		
	}

	public Optional<List<HospitalEntity>> getByLocation(String location) {
		
		return hospitalRepository.getByLocation(location);
	}

	public Optional<List<HospitalEntity>> getByRating(double minRating, double maxRating) {
		
		return hospitalRepository.findByRatingBetween(minRating, maxRating);
	}
		
	
//	 public HospitalEntity updateHospital(Long id, HospitalEntity hospitalEntity) {
//	        return hospitalRepository.findById(id)
//	                .map(existingHospital -> {
//	                    if (hospitalEntity.getName() != null) {
//	                        existingHospital.setName(hospitalEntity.getName());
//	                    }
//	                    if (hospitalEntity.getLocation() != null) {
//	                        existingHospital.setLocation(hospitalEntity.getLocation());
//	                    }
//	                    if (hospitalEntity.getRating() != 0) {
//	                        existingHospital.setRating(hospitalEntity.getRating());
//	                    }
//	                    return hospitalRepository.save(existingHospital);
//	                })
//	                .orElse(null); // return null if hospital not found
//	    }
	
	public HospitalEntity updateHospital(Long id, Map<String, Object> updatedetails) {
		
	Optional<HospitalEntity> optionalHospital=	hospitalRepository.findById(id);
	
	if(optionalHospital.isPresent()) {
		HospitalEntity hospital=optionalHospital.get();
		
		if(updatedetails.containsKey("name")) {
			hospital.setName((String) updatedetails.get("name"));
		}
		
		if(updatedetails.containsKey("location")) {
			hospital.setLocation(null);
		}
		
		if(updatedetails.containsKey("rating")) {
			hospital.setRating((double) updatedetails.get("rating"));
		}
		
		return hospitalRepository.save(hospital);
		
		
	}
	return null;
	
	
		
	}

}
