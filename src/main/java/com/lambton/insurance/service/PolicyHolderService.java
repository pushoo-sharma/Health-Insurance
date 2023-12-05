package com.lambton.insurance.service;

import com.lambton.insurance.dao.PolicyHolderDao;
import com.lambton.insurance.model.PolicyHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PolicyHolderService {

    @Autowired
    PolicyHolderDao policyHolderDao;

    public ResponseEntity<List<PolicyHolder>> getAllPolicyHolder() {
        try {
            return new ResponseEntity<>(policyHolderDao.findAll(), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<PolicyHolder> getPolicyHolderById(Integer policyHolderId) {
        try {
            Optional<PolicyHolder> policyHld = policyHolderDao.findById(policyHolderId);
            return policyHld.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            // Log the exception or handle it appropriately
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> createPolicyHolder(PolicyHolder policyHolder) {
        try {

            // Check if the user property is null
            if (policyHolder.getUser() == null) {
                // Handle appropriately, either set a valid User or return an error response
                String errorMessage = "The 'user' property in PolicyHolder cannot be null.";
                return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
            }
            // Return a success response with a message
            String successMessage = "PolicyHolder created successfully.";
            return new ResponseEntity<>(successMessage, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception or handle it appropriately
            String errorMessage = "An internal server error occurred: " + e.getMessage();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> updatePolicyHolderService(Integer policyHolderId, PolicyHolder policyHolder) {
        try {
            Optional<PolicyHolder> existingPolicy = policyHolderDao.findById(policyHolderId);
            if (existingPolicy.isPresent()) {
                PolicyHolder policyToUpdate = existingPolicy.get();
                policyToUpdate.setUser(policyHolder.getUser());

                // Check if the user property is null
                if (policyToUpdate.getUser() == null) {
                    // Handle appropriately, either set a valid User or return an error response
                    String errorMessage = "The 'user' property in PolicyHolder cannot be null.";
                    return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
                }

                policyHolderDao.save(policyToUpdate);
                // Return a success response with a message
                String successMessage = "PolicyHolder updated successfully.";
                return new ResponseEntity<>(successMessage, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            // Log the exception or handle it appropriately
            String errorMessage = "An internal server error occurred: " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> deletePolicyHolder(Integer policyHolderId) {
        try {
            if (policyHolderDao.existsById(policyHolderId)) {
                policyHolderDao.deleteById(policyHolderId);
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
