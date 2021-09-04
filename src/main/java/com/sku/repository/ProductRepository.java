package com.sku.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sku.entities.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value="SELECT p FROM Product p WHERE p.sku = :sku")
	Product findProductBySku(@Param("sku") int sku);
	
	@Query("SELECT p FROM Product p WHERE p.sku IN (:skus)")
    List<Product> getListofProducts(@Param("skus")List<Integer> skus);

}
