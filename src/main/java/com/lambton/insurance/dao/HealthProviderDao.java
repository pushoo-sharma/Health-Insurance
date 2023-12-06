package com.lambton.insurance.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lambton.insurance.model.HealthProvider;

public interface HealthProviderDao extends JpaRepository<HealthProvider, Integer> {

}
