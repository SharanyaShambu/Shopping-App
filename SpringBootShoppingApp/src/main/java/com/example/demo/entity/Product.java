package com.example.demo.entity;

import java.util.Date;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

@Entity
@Table
@Data
public class Product {
    @Id
    @Min(value = 1, message = "Product ID must be greater than or equal to 1")
    private int productId;

    @NotBlank(message = "Product name cannot be blank")
    private String productName;

    @Min(value = 0, message = "Product price must be greater than or equal to 0")
    private int productPrice;

    @NotBlank(message = "Product category cannot be blank")
    private String productCategory;

    @NotNull(message = "Product validity date cannot be null")
    private Date productValidity;
    
    @ManyToOne
    @JoinColumn(name = "cart_id",referencedColumnName = "cartId")
    @JsonBackReference
    private Cart cart;
}
