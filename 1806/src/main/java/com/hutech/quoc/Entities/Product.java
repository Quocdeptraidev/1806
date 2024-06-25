package com.hutech.quoc.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String ROM;
    private String RAM;
    private String CPU;
    private String GPU;
    private String brand;
    private Double price;
    private Boolean enabled;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}