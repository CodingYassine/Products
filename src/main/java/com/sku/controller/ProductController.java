package com.sku.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sku.entities.Product;
import com.sku.service.ProductService;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/sku", method = RequestMethod.POST)
	public ResponseEntity<?> saveProduct(@RequestBody Product newProduct){
		try {
			Product product = productService.save(newProduct);
			if(product != null) {
				return new ResponseEntity<>(product, HttpStatus.OK);
			}else {
				return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			LOGGER.error("Problem occored in /product/sku : {} ", e);
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RequestMapping(value = "/sku", params = "skus", method = RequestMethod.GET)
	public ResponseEntity<?> getListofProducts(@RequestParam List<Integer> skus){
		try {
			
			if(skus.isEmpty() != true) {		
				return new ResponseEntity<>(productService.getListofProductsBySkus(skus), HttpStatus.OK);
			}else {
				return new ResponseEntity<>("The list is empty", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			LOGGER.error("Problem occored in /product/sku : {} ", e);
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/sku", method = RequestMethod.PUT)
	public ResponseEntity<?> updateProduct(@RequestBody Product newProduct){
		try {
			Product product = productService.findProductBySku(newProduct.getSku());
			if(product != null) {
				productService.update(newProduct);
				return new ResponseEntity<>(product, HttpStatus.OK);
			}else {
				return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			LOGGER.error("Problem occored in /product/sku : {} ", e);
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
