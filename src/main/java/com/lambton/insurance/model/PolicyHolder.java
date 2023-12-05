package com.lambton.insurance.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
@Table(name = "policyholders")
public class PolicyHolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "policyholder_id")
    private Long policyholderId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
