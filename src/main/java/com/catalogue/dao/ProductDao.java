package com.catalogue.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.catalogue.bean.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long>{

	List<Product> findAll();
	
	Optional<Product> findByCode(String productCode);
	
}
