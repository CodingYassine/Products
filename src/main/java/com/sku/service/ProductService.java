package com.sku.service;

import java.util.List;

import com.sku.entities.Product;

public interface ProductService {
	
	Product findProductBySku(int skus);

	Product save(Product product);
	
	Product update(Product product);
	
	List<Product> getListofProductsBySkus(List<Integer> skus);
}
