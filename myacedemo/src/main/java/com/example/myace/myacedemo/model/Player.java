package com.example.myace.myacedemo.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@EqualsAndHashCode
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;

    String type;

    int grade;

    String position;

    Double record;
}
