package com.tcs.spring.entity;

//import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product")
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
    private String brand;
    private int quantity;
    private int price;
    private  String madein;
//    private  int discountrate;
    private double taxrate;
    @Column(name="dr")
    private double discountprice;
    private double offerprice;
    private  double finalprice;
    private double stockvalue;
    
	

}
