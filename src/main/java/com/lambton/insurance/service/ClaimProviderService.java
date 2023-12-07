package com.lambton.insurance.service;

import com.lambton.insurance.dao.ClaimsProviderDao;
import com.lambton.insurance.model.Claim;
import com.lambton.insurance.model.User;
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

    public ResponseEntity<Claim> createClaim(Claim claim) {
        try {
            return new ResponseEntity<>(claimsProviderDao.save(claim), HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception or handle it appropriately
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Claim> updateClaim(Integer claimId, Claim updatedClaim) {
        try {
            Optional<Claim> existingClaim = claimsProviderDao.findById(claimId);
            if (existingClaim.isPresent()) {
                Claim claimToUpdate = existingClaim.get();

                // Update fields based on your requirements
                claimToUpdate.setDiagnosis(updatedClaim.getDiagnosis());
                claimToUpdate.setTreatmentCost(updatedClaim.getTreatmentCost());
                claimToUpdate.setStatus(updatedClaim.getStatus());

                // Save the updated claim
                return new ResponseEntity<>(claimsProviderDao.save(claimToUpdate), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            // Return empty if an exception occurs
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> deleteClaim(Integer claimId) {
        try {
            if (claimsProviderDao.existsById(claimId)) {
                claimsProviderDao.deleteById(claimId);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                // Return a 404 Not Found response if the user doesn't exist
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // Log the exception or handle it appropriately
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
