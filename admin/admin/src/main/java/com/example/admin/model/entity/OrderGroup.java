package com.example.admin.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class OrderGroup {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String status;

    private String orderType;

    private String revAddress;

    private String revName;

    private String paymentType;
    private BigDecimal totalPrice;
    private Integer totalQuantity;
    private LocalDateTime orderAt;
    private LocalDateTime arrivalDate;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;


    //OrderGroup N:1 User
    @ManyToOne
    private User user;
    //변수명은 OrderGroup MappedBy와 일치해야함



}
