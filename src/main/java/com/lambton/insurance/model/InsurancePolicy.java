package com.lambton.insurance.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "insurancepolicy")
public class InsurancePolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "policy_id")
    private Long policyId;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "coverage_type")
    private String coverageType;

    @Column(name = "premium_amount")
    private double premiumAmount;

    @Column(name = "deductible_amount")
    private double deductibleAmount;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "policyholder_id", nullable = false)
    private PolicyHolder policyHolder;

}
