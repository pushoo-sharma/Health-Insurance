package com.lambton.insurance.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    private char gender;

    private String contactNumber;

    private String email;

    private String address;

    //    @Column(name = "user_type", columnDefinition = "smallint")
    //    @Enumerated(EnumType.STRING)
    //    private UserType userType;

    @Column(name = "user_type", length = 20)
    private String userType;


}
