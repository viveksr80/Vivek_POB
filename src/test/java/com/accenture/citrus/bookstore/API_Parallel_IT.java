package com.accenture.citrus.bookstore;

import java.util.Date;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class API_Parallel_IT {

	TestNG testNG = new TestNG();
	static Date startTime = null, endTime = null;

	// 500 times 200 threads - 15 mins - 2508 tests
	// 500 times 300 threads - 18 mins - 2507 tests
	// @Test(invocationCount=30,threadPoolSize=10)
	//@Test(invocationCount = 110, threadPoolSize = 50 )//2min 21 sec 556 tests
	//@Test(invocationCount = 125, threadPoolSize = 50 ) //3 min 12 sec 631 tests
	@SuppressWarnings("deprecation")
	@Test(invocationCount = 95, threadPoolSize = 55 )
	public void runTest() throws Exception {
		testNG.setVerbose(0);
		testNG.setParallel("classes");
		testNG.setUseDefaultListeners(false);
		TestListenerAdapter tla = new TestListenerAdapter();
		testNG.addListener(tla);

		synchronized (API_Parallel_IT.class) {
			testNG.setTestClasses(new Class[] { AddBook_Ok_3_IT.class, GetBook_Detail_IT.class, AddBook_Ok_2_IT.class,
					ListBook_IT.class
					// ,
					// AddBook_Ok_1_IT.class
			});

			testNG.run();

			System.out.println("No. of tests passed - " + tla.getPassedTests().size());
			System.out.println("No. of tests failed - " + tla.getFailedTests().size());
		}
	}

	@BeforeClass
	public static void runOnceBeforeClass() {
		startTime = new Date();
		System.out.println("START TIME - " + startTime.getTime());
		System.out.println();
	}

	@AfterClass
	public static void runOnceAfterClass() {
		endTime = new Date();
		System.out.println("END TIME - " + endTime.getTime());
		long diff = (endTime.getTime() - startTime.getTime());
		System.out.println("Total TIME in Milliseconds--------- " + diff);
		System.out.println("Total TIME in Seconds--------- " + diff / 1000);
	}
}
