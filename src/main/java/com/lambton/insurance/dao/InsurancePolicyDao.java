package com.lambton.insurance.dao;


import com.lambton.insurance.model.InsurancePolicy;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface InsurancePolicyDao extends JpaRepository<InsurancePolicy, Integer> {

}