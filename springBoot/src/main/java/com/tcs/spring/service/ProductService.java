package com.tcs.spring.service;

import java.util.*; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.spring.entity.ProductEntity;
import com.tcs.spring.lombok.ProductCOntroll;
import com.tcs.spring.repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	ProductRepository repository;
	
	public void saveProductDetails(ProductCOntroll productcontroll) {
		double discountPrice;
		discountPrice=productcontroll.getPrice()*10;
		double offerPrice;
		offerPrice=discountPrice-productcontroll.getPrice();
		double taxPrice;
		taxPrice=offerPrice*0.18;
		double finalPrice;
		finalPrice=offerPrice+taxPrice;
		double stockValue;
		stockValue=finalPrice*productcontroll.getQuantity();
		ProductEntity productEntity=new ProductEntity();
		productEntity.setName(productcontroll.getName());
		productEntity.setBrand(productcontroll.getBrand());
		productEntity.setMadein(productcontroll.getMadein());
		productEntity.setPrice(productcontroll.getPrice());
		productEntity.setQuantity(productcontroll.getQuantity());
//		productEntity.setDiscountrate(productcontroll.getDiscountrate());
		productEntity.setDiscountprice(discountPrice);
		productEntity.setOfferprice(offerPrice);
		productEntity.setTaxrate(taxPrice);
		productEntity.setFinalprice(finalPrice);
		productEntity.setStockvalue(stockValue);
		repository.save(productEntity);
	}
	
	
	public List<ProductEntity> getAllProducts(){
	
	 List<ProductEntity> products=repository.findAll();
	 
	
	return products;
	
	
	}
	
	
	public ProductEntity searchById(Long id) {
		
		Optional<ProductEntity> optionalData=repository.findById(id);
		
		if(optionalData.isPresent()) {
			ProductEntity product=optionalData.get();
			return product;
		}
		
		else {
			return null;
		}
		
		
	}
	
	public void deleteProductById(Long id) {
		
		repository.deleteById(id);
		
	}
	
	
//	****************************************PRODUCT EDIT*************************************
	
	public ProductCOntroll editProductById(Long id) {
		
		
Optional<ProductEntity> optionalData=repository.findById(id);
		
		if(optionalData.isPresent()) {
			ProductEntity productEntity = optionalData.get();
	        // Convert ProductEntity to ProductCOntroll
	        ProductCOntroll product = convertToProductCOntroll(productEntity);// THIS is a method with out direct creating
	        
	        return product;
		}
		
		else {
			return null;
		}
		
		
		
	}


	private ProductCOntroll convertToProductCOntroll(ProductEntity productEntity) {
	    ProductCOntroll product = new ProductCOntroll();
//	    product.setid(productEntity.getId());
	    product.setName(productEntity.getName());
	    product.setBrand(productEntity.getBrand());
	    product.setQuantity(productEntity.getQuantity());
	    product.setPrice(productEntity.getPrice());
	    product.setMadein(productEntity.getMadein());
	    return product;
	}


	
//	***********************************************************************************************************
	
                                                //PROODUCT UPDATE
	
	
	public void updateProduct(Long id, ProductCOntroll productCOntroll) {
	    // Fetch the existing product entity from the repository
	    Optional<ProductEntity> existingProductOpt = repository.findById(id);

	    if (existingProductOpt.isPresent()) {
	        ProductEntity existingProduct = existingProductOpt.get();

	        // Update the fields of the existing product entity
	        existingProduct.setName(productCOntroll.getName());
	        existingProduct.setBrand(productCOntroll.getBrand());
	        existingProduct.setQuantity(productCOntroll.getQuantity());
	        existingProduct.setPrice(productCOntroll.getPrice());
	        existingProduct.setMadein(productCOntroll.getMadein());

	        // Save the updated entity back to the database
	        repository.save(existingProduct);
	    } 
	}

	
	
	

}
