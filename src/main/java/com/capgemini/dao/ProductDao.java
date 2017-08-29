package com.capgemini.dao;

import java.util.List;
import java.util.Map;

import com.capgemini.domain.ProductEntity;

public interface ProductDao extends Dao<ProductEntity, Long> {

	List<Long> findUniqueBoughtProductsOfClient(Long clientId);
	List<Long> findTenTheBestOfProducts();
	Map<String,Integer>findProductsInProgress();
	
}
