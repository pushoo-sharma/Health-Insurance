package com.lambton.insurance.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.lambton.insurance.dao.HealthProviderDao;
import com.lambton.insurance.model.HealthProvider;


@Service
public class HealthProviderService {

	@Autowired
	HealthProviderDao healthProviderDao;
	
	public ResponseEntity<List<HealthProvider>> getAllHealthProviders() {
        try {
            List<HealthProvider> healthProviders = healthProviderDao.findAll();
            return new ResponseEntity<>(healthProviders, HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
	
	 public ResponseEntity<HealthProvider> getHealthProviderById(Integer healthProviderId) {
	        try {
	            Optional<HealthProvider> healthProvider = healthProviderDao.findById(healthProviderId);
	            return healthProvider.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	        } catch (Exception e) {
	            // Log the exception or handle it appropriately
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
}
