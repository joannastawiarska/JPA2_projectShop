package com.capgemini.dao;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProductDaoTests {

	@Autowired
	ProductDao productDao;

	@Test
	public void shouldTestReturnTheBestOfProducts() {

		// given
		List<Long> listExpected = Arrays.asList(50L, 17L, 11L, 24L, 29L, 3L, 22L, 31L, 38L, 18L);
		// when
		List<Long> resultList = productDao.findTenTheBestOfProducts();
		// then
		System.out.println(resultList);
		assertEquals(10, resultList.size());
		assertTrue(resultList.get(0).equals(50L));
		assertTrue(resultList.get(3).equals(24L));
		assertTrue(resultList.get(9).equals(18L));
		}

	@Test
	public void shouldTestReturnProductsInProgress() {

		// when
		Map<String, Integer> result = productDao.findProductsInProgress();
		// then
		assertEquals(30, result.size());
		Assertions.assertThat(result).containsKey("Sausage - Chorizo");
		Assertions.assertThat(result).containsValue(16);
		Assertions.assertThat(result).containsKey("Sandwich Wrap");
		Assertions.assertThat(result).containsValue(1);
		
	}

	@Test
	public void shouldTestReturnUniqueBoughtProductsOfClient() {

		//given
		Long id = 1L;
		List<Long> listExpected = Arrays.asList(42L, 14L, 28L, 16L, 22L, 6L, 43L, 45L, 37L, 24L, 1L, 21L);
		//when
		List<Long> resultList = productDao.findUniqueBoughtProductsOfClient(id);
		//then
		assertEquals(12, resultList.size());
		assertTrue(resultList.contains(42L));
		assertTrue(resultList.contains(14L));
		assertTrue(resultList.contains(28L));
		assertTrue(resultList.contains(16L));
	}

}
