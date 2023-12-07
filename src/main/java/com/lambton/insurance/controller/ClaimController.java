package com.lambton.insurance.controller;

import com.lambton.insurance.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.lambton.insurance.model.Claim;
import com.lambton.insurance.service.ClaimProviderService;


@RestController
@RequestMapping("claims")
public class ClaimController {

    @Autowired
    ClaimProviderService claimsProviderService;

    @GetMapping("")
    public ResponseEntity<List<Claim>> getAllClaims() {
        return claimsProviderService.getAllClaims();
    }

    @GetMapping("/user/{userId}")
    public List<Claim> getClaimsByUserId(@PathVariable Long userId) {
        return claimsProviderService.getClaimsByUserId(userId);
    }

    @GetMapping("/{claimId}")
    public ResponseEntity<Claim> getClaimById(@PathVariable Integer claimId) {
        return claimsProviderService.getClaimById(claimId);
    }
}
