package com.staya.spring.rest.TestController;

import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
	
	@GetMapping("/pincodedetails/{pincode}")
	public ResponseEntity<String> getPincodeDetails(@PathVariable("pincode") String pincode){
		
		
		
		RestTemplate restTemplate=new RestTemplate();
		
		ResponseEntity<String> response=restTemplate.getForEntity("https://api.postalpincode.in/pincode/"+pincode, String.class);
		
		return ResponseEntity.status(HttpStatus.OK)
                              .header("status","surya sucess")
                              .body(response.getBody());
	}

}
