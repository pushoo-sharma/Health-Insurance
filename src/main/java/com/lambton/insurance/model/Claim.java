package com.lambton.insurance.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "claim")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "claim_id")
    private Long claimId;

    @ManyToOne
    @JoinColumn(name = "policy_id", nullable = false)
    private InsurancePolicy insurancePolicy;

    @Column(name = "claim_date")
    private String claimDate;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "treatment_cost")
    private double treatmentCost;

    @Column(name = "status")
    private String status;

}
