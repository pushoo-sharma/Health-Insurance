package com.lambton.insurance.dao;

import com.lambton.insurance.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClaimsProviderDao extends JpaRepository<Claim, Integer> {
    List<Claim> findByInsurancePolicy_PolicyHolder_User_UserId(Long userId);

    @Query("SELECT c FROM Claim c WHERE c.insurancePolicy.policyHolder.user.userId = :userId")
    List<Claim> findClaimsByUserId(Long userId);
}
