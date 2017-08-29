package com.capgemini.dao;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TransactionsDetailsTests {

	@Autowired
	TransactionsDetailsDao detailsDao;
	
	@Test
	public void testShouldCountWholePrice() {

		//given
		Long idFirst = 2L;
		Long idSecond = 3L;
		// when
		double wholeAmountA = detailsDao.countWholePrice(idFirst);
		double wholeAmountB = detailsDao.countWholePrice(idSecond);
		// then
		assertEquals(16695, wholeAmountA, 0.1);
		assertEquals(212110, wholeAmountB, 0.1);
	}
	
	@Test
	public void testShouldReturnThreeClientsWhoSpendMostAmountMoney() {

		//given
		String firstDate = "2017-01-05";
		String secondDate = "2017-12-01";
		//when
		List<Long> result = detailsDao.getThreeClientsWithMostAmountMoney(Date.valueOf(firstDate), Date.valueOf(secondDate));
		//then
		System.out.println(result);
        assertEquals(3, result.size());
        assertTrue(result.contains(6L));
        assertTrue(result.contains(9L));
        assertTrue(result.contains(13L));
        
	}
	
	@Test
	public void testShouldGetProfitOnDate(){
		
		//given
		String firstDate = "2017-01-05";
		String secondDate = "2017-12-01";
		//when
		double profit = detailsDao.getProfitOnDate(Date.valueOf(firstDate), Date.valueOf(secondDate));
		//then
		assertEquals(1899795, profit, 1);
	}
}
