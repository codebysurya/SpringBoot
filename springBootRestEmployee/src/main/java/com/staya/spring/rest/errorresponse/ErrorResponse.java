package com.staya.spring.rest.errorresponse;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
	
	 private String message;
	 private int statuscode;
	 private LocalDateTime timestamp;
	

}
