package com.sku.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sku.entities.Product;
import com.sku.repository.ProductRepository;
import com.sku.service.ProductService;

public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product findProductBySku(int sku) {
		// TODO Auto-generated method stub
		return productRepository.findProductBySku(sku);
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public List<Product> getListofProductsBySkus(List<Integer> skus) {
		
		return productRepository.getListofProducts(skus);
	}

}
