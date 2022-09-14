package com.catalogue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.catalogue.bean.Product;
import com.catalogue.dao.ProductDao;
import com.catalogue.service.ProductService;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
	@InjectMocks
	@Autowired
	private ProductService productService;
	
	@Mock
	private ProductDao productDao;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetAllProducts_T001() {
		List<Product> products = new ArrayList<>();
		products.add(new Product(1L,"11##34$","Monte Carlo Hat","blue flary hat for a sunny day", 300)); 
		
		Mockito.when(productDao.findAll()).thenReturn(products);
		
		assertIterableEquals(products, productService.getAllProducts());
	}
	
	@Test
	void testGetAllProducts_T002() {
		List<Product> products = new ArrayList<>();
		
		Mockito.when(productDao.findAll()).thenReturn(products);
		
		assertIterableEquals(products, productService.getAllProducts());
	}
	
	@Test
	void testgetProductByCode_T001() {
		Optional<Product> product = Optional.ofNullable(new Product(1L,"11##34$","Monte Carlo Hat","blue flary hat for a sunny day", 300)); 
		
		Mockito.when(productDao.findByCode("11##34$")).thenReturn(product);
		
		assertEquals(product, productService.searchProductByCode("11##34$"));
	}
//	@Test
//	void testgetProductByCode_T002() {
//		Product product = new Product(); 
//		
//		Mockito.when(productDao.findByCode("1134")).thenReturn(new Product());
//		
//		assertEquals(product, productService.searchProductByCode("1134"));
//	}
//}
}
