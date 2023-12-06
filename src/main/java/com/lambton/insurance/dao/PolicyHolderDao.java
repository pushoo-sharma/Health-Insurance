package com.lambton.insurance.dao;

import com.lambton.insurance.model.PolicyHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyHolderDao extends JpaRepository<PolicyHolder, Integer> {
}