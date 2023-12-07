package com.lambton.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("")
    public ResponseEntity<Claim> createClaim(@RequestBody Claim claim){
        return claimsProviderService.createClaim(claim);
    }

    @PutMapping("/{claimId}")
    public ResponseEntity<Claim> updateClaim(@PathVariable Integer claimId, @RequestBody Claim claim) {
        return claimsProviderService.updateClaim(claimId, claim);
    }

    @DeleteMapping("/{claimId}")
    public ResponseEntity<Void> deleteClaim(@PathVariable Integer claimId) {
        return claimsProviderService.deleteClaim(claimId);
    }
}
