package com.sku.controller;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.sku.entities.Product;
import com.sku.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
class ProductControllerTest {
	
	@InjectMocks
	ProductController productController; 
	
	@Mock
	private ProductService productService;
	
	List<Product> products = null;

	
	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		
		Product product1 = new Product(123, "test", "test", 10.0);
		Product product2 = new Product(4567, "test", "test", 10.0);
		Product product3 = new Product(8901, "test", "test", 10.0);
		Product product4 = new Product(2345, "test", "test", 10.0);
		Product product5 = new Product(67789, "test", "test", 10.0);
		
		products.add(product1);
		products.add(product2);
		products.add(product3);
		products.add(product4);
		products.add(product5);
		
	}

	@Test
	void testGetListofProducts() {
		List<Integer> skus = null;
		skus.add(123);
		skus.add(4567);
		skus.add(8901);
		skus.add(2345);
		skus.add(67789);
		when(productService.getListofProductsBySkus(skus)).thenReturn(products);
	}

}
