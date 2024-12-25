package com.tcs.spring.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCOntroll

{
	
	
	// this is model calss for Porduct;
	private Long id;
	 private String name;
	    private String brand;
	    private int quantity;
	    private int price;
	    private  String madein;
	    
     

//    public static void main(String[] args) {
////    	ProductCOntroll tl = ProductCOntroll.builder()
////                                  .name("hi")
////                                  .brand("hihi")
////                                  .quantity(6)
////                                  .price(10)
////                                  .madein("india")
////                                  .build();
////
////        System.out.println(tl);
//    }
}
