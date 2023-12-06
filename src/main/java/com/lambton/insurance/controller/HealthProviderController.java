package com.lambton.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lambton.insurance.model.HealthProvider;
import com.lambton.insurance.service.HealthProviderService;

@RestController
@RequestMapping("healthproviders")
public class HealthProviderController {
	
	@Autowired
	HealthProviderService healthProviderService;
	
	@GetMapping("")
    public ResponseEntity<List<HealthProvider>> getAllHealthProvider() {
        return healthProviderService.getAllHealthProviders();
    }

    @GetMapping("/{healthProviderId}")
    public ResponseEntity<HealthProvider> getHealthProviderById(@PathVariable Integer healthProviderId) {
        return healthProviderService.getHealthProviderById(healthProviderId);
    }
}
