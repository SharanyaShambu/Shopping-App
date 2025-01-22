package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Product {
	@Id
	private int productId;
	private String productName;
	private int productPrice;
	private String productCategory;
	private Date productValidity;

}
