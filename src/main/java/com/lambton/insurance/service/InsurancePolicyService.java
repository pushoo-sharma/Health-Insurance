package com.lambton.insurance.service;

import com.lambton.insurance.dao.InsurancePolicyDao;
import com.lambton.insurance.model.InsurancePolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InsurancePolicyService {

    @Autowired
    InsurancePolicyDao insurancePolicyDao;

    public ResponseEntity<List<InsurancePolicy>> getAllPolicyHolder() {
        try {
            List<InsurancePolicy> insurancePolicy = insurancePolicyDao.findAll();
            return new ResponseEntity<>(insurancePolicy, HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<InsurancePolicy> getInsurancePolicyById(Integer insurancePolicyId) {
        try {
            Optional<InsurancePolicy> policyHld = insurancePolicyDao.findById(insurancePolicyId);
            return policyHld.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            // Log the exception or handle it appropriately
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
