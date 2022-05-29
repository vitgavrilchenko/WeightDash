package com.example.application.data.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Weight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String weight;
    private LocalDateTime dateTime;
}
