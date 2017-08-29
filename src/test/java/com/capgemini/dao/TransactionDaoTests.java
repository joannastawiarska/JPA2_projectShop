package com.capgemini.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
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
public class TransactionDaoTests {
	
	@Autowired
	TransactionDao transactionDao;
	
	@Test
	public void testShouldReturnListClientWithTransactionInDeliver(){
		
		//given
		List<Long> listExpected = Arrays.asList(1L, 3L, 4L, 5L, 6L, 9L, 10L, 11L, 12L, 13L, 16L, 17L, 20L);
		//when
		List<Long> resultList = transactionDao.returnListClientWithTransactionInDeliver();
		//then
		assertEquals(13, resultList.size());
		assertTrue(resultList.contains(11L));
		assertTrue(resultList.contains(9L));
		assertTrue(resultList.contains(13L));
		assertTrue(resultList.contains(17L));
	}
}
