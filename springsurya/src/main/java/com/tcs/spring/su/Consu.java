package com.tcs.spring.su;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Consu {
	
	@GetMapping("/twist")
	public String getter() {
		return"myvies";
	}

}
