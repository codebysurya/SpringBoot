package com.staya.spring.rest.hospital.controller;

//import java.net.NoRouteToHostException;
import java.util.*;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.staya.spring.rest.hospital.hospitalentity.HospitalEntity;
import com.staya.spring.rest.hospital.service.HospitalService;

@RestController
@RequestMapping("/api/v1")
public class HospitalController {
	@Autowired
	HospitalService hospitalService;
	
	@PostMapping("/hospitals")
	public ResponseEntity<?> saveHospital(@RequestBody HospitalEntity hospitalEntity){
		
		HospitalEntity hospital=	hospitalService.saveHospital(hospitalEntity);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				             .header("info", "Hospital data saved")
				             .body(hospital);
		
	}
	
	
	@PostMapping("/hospitals/bulk")
	public ResponseEntity<List<HospitalEntity>> saveAllHospitals(@RequestBody List<HospitalEntity> hospiList){
		
		
		List<HospitalEntity> hospitals=	hospitalService.saveAllHospitals(hospiList);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				             .header("info", "all hospitals saved")
				             .body(hospitals);
		
		
	}
	
	
	@GetMapping("/hospitals")
	public ResponseEntity<List<HospitalEntity>> getAllHospitals(){
		List<HospitalEntity> hospitals=hospitalService.getAllHospitals();
		
		return ResponseEntity.status(HttpStatus.OK)
				             .header("info", "got all hospital data")
				             .body(hospitals);
		
	}
	
	
	@GetMapping("/hospitals/{id}")
		public ResponseEntity<HospitalEntity> getHospitalById(@PathVariable ("id") Long id){
		
		Optional<HospitalEntity> op= hospitalService.getHospitalById(id);
		
		if(op.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK)
					             .header("info", "got hospital by " +id)
					             .body(op.get());
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
		             .header("info", "no hospital by that "+id)
		             .build();
		}
		
	}
	
	
	@GetMapping("/hospitals/location/{location}")
	public ResponseEntity<List<HospitalEntity>> getByLocation(@PathVariable ("location") String location){
		
		Optional<List<HospitalEntity>> op=hospitalService.getByLocation(location);
		
		if(op.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK)
					             .header("info", "got hospital by " +location)
					             .body(op.get());
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
		             .header("info", "no hospital by that "+location)
		             .build();
		}
		
		
	}
	
	
	@GetMapping("/hospitals/rating/{minRating}/{maxRating}")
	public ResponseEntity<List<HospitalEntity>> getByRating(@PathVariable("minRating") double minRating,
			                                                   @PathVariable("maxRating") double maxRating){
		
		Optional<List<HospitalEntity>> op=hospitalService.getByRating(minRating,maxRating);
		
		
		if(op.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK)
					             .header("info", "got hospitals " )
					             .body(op.get());
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
		             .header("info", "no hospital by that ")
		             .build();
		}
		
		
	}
	
	
	
//	@PatchMapping("/hospitals/{id}")
//    public ResponseEntity<HospitalEntity> updateHospital(@PathVariable Long id, @RequestBody HospitalEntity hospitalEntity) {
//        HospitalEntity updatedHospital = hospitalService.updateHospital(id, hospitalEntity);
//        
//        if (updatedHospital == null) {
//            return ResponseEntity.notFound().build(); // return 404 if hospital not found
//        }
//        
//        return ResponseEntity.ok(updatedHospital); // return 200 with the updated hospital details
//    }
//	
	
	
	@PatchMapping("/hospitals/{id}")
 public ResponseEntity<HospitalEntity> updateHospital(@PathVariable Long id, @RequestBody Map<String, Object> updatedetails){
		
		HospitalEntity hospital= hospitalService.updateHospital(id,updatedetails);
		
		if(hospital!= null) {
			return ResponseEntity.status(HttpStatus.OK)
								.header("info", "data updated")
								.body(hospital);
		}
			else {
				
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
									.header("info","Dta not found")
									.build();
			}
		}
		
	}
	
	
	


