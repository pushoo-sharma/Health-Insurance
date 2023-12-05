package com.lambton.insurance.controller;

import com.lambton.insurance.model.PolicyHolder;
import com.lambton.insurance.service.PolicyHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("policyholders")
public class PolicyController {

    @Autowired
    PolicyHolderService policyHolderService;

    @GetMapping("")
    public ResponseEntity<List<PolicyHolder>> getAllPolicyHolder(){
        return policyHolderService.getAllPolicyHolder();
    }

    @GetMapping("/{policyHolderId}")
    public ResponseEntity<PolicyHolder> getPolicyHolderById(@PathVariable Integer policyHolderId){
        return policyHolderService.getPolicyHolderById(policyHolderId);
    }

    @PostMapping("")
    public ResponseEntity<String> createPolicyHolder(@RequestBody PolicyHolder policyHolder){
        return policyHolderService.createPolicyHolder(policyHolder);
    }

    @PutMapping("/{policyHolderId}")
    public ResponseEntity<String> updatePolicyHolder(@PathVariable Integer policyHolderId, @RequestBody PolicyHolder policyHolder) {
        return policyHolderService.updatePolicyHolderService(policyHolderId, policyHolder);
    }

    @DeleteMapping("/{policyHolderId}")
    public ResponseEntity<Void> deletePolicyHolder(@PathVariable Integer policyHolderId) {
        return policyHolderService.deletePolicyHolder(policyHolderId);
    }

}
