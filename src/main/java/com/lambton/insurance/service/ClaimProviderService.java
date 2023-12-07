package com.lambton.insurance.service;

import com.lambton.insurance.dao.ClaimsProviderDao;
import com.lambton.insurance.model.Claim;
import com.lambton.insurance.model.HealthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClaimProviderService {

    @Autowired
    ClaimsProviderDao claimsProviderDao;

    public ResponseEntity<List<Claim>> getAllClaims() {
        try {
            List<Claim> getAllClaims = claimsProviderDao.findAll();
            return new ResponseEntity<>(getAllClaims, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public List<Claim> getClaimsByUserId(Long userId) {
        return claimsProviderDao.findClaimsByUserId(userId);
    }


    public ResponseEntity<Claim> getClaimById(Integer claimId) {
        try {
            Optional<Claim> claim = claimsProviderDao.findById(claimId);
            return claim.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            // Log the exception or handle it appropriately
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
