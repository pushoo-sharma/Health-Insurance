package com.lambton.insurance.controller;

import com.lambton.insurance.model.InsurancePolicy;
import com.lambton.insurance.service.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("policies")
public class InsurancePolicyController {

    @Autowired
    InsurancePolicyService insurancePolicyService;

    @GetMapping("")
    public ResponseEntity<List<InsurancePolicy>> getAllInsurancePolicy() {
        return insurancePolicyService.getAllPolicyHolder();
    }

    @GetMapping("/{insurancePolicyId}")
    public ResponseEntity<InsurancePolicy> getPolicyHolderById(@PathVariable Integer insurancePolicyId) {
        return insurancePolicyService.getInsurancePolicyById(insurancePolicyId);
    }

}