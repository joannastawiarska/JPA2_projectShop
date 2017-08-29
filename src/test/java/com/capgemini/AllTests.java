package com.capgemini;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.dao.ProductDaoTests;
import com.capgemini.dao.TransactionDaoTests;
import com.capgemini.dao.TransactionsDetailsTests;

@RunWith(SpringRunner.class)
@SuiteClasses({ProductDaoTests.class, TransactionDaoTests.class, TransactionsDetailsTests.class})
public class AllTests {
	
}
