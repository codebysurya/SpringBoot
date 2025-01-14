package com.tcs.spring.controller;

import java.util.List;
//import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tcs.spring.entity.ProductEntity;
import com.tcs.spring.lombok.ProductCOntroll;
import com.tcs.spring.service.ProductService;


@Controller
public class TestController {
	
//	this belongs to productControll
	
	@Autowired
	ProductService proService;
	
	@GetMapping("/test")
	public String greet() {
		return "add-product";
	}
	
	
	
	
	@PostMapping("/saveProduct")
	public String saveProduct(  ProductCOntroll productcontroll) {
		
		proService.saveProductDetails( productcontroll);
		
		System.out.println(productcontroll);
//		TODO: process POST request
		
		return "success";
	}
	
	
	@GetMapping("/getproducts")
	public String getAllProducts(Model model) {
		
		List<ProductEntity> products=proService.getAllProducts();

		model.addAttribute("products",products);
		return "ProductList";
		
	}
	
	@GetMapping("/search")
	public String serachById() {
		return "search-Product";
	}
	
	@PostMapping("/searchById")
	public String searchById(@RequestParam Long id,Model model) {
		ProductEntity product=proService.searchById(id);
		model.addAttribute("product", product);
		return "search-Product";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteProductById(@PathVariable("id") Long id) {
	    proService.deleteProductById(id);
	    return "redirect:/getproducts"; // Corrected the syntax by removing the space
	}
	
	
	
	@GetMapping("/edit/{id}")
	public String editProductById(@PathVariable("id") Long id, Model model) {
		
		ProductCOntroll product= proService.editProductById(id);
		
		model.addAttribute("product", product);
		model.addAttribute("id",id);
		
		return "edit-product";
	}
	
	
	
	@PostMapping("/editproductsave/{id}")
	public String afterProductEdit(@PathVariable ("id") Long id,ProductCOntroll product) {
		proService.updateProduct(id,product);
		return "redirect:/getproducts"; 
		
	}

	
	
	

}





