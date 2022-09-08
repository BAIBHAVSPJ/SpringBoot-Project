package com.tech.limits.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.limits.Entities.LimitsConfiguration;

@RestController
public class LimitsConfigurationController {
	
	@GetMapping("/limits")
	public LimitsConfiguration returnLimits() {
		
		
		return null;
		
		
	}

}
