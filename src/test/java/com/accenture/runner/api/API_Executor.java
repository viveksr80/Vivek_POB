package com.accenture.runner.api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.accenture.aaft.logger.CTLogger;
import com.accenture.runner.utility.ListAllRunner;

/**
 * Class is used to execute multiple API tests in parallel
 *
 * @author vijay.venkatappa
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class API_Executor {

  static List<Class> testCases = new ArrayList();

  /**
   * Method is used to distribute the tests
   *
   * @param testCaseCount - represents test case count
   * @throws Exception - represents exception
   */
  public void distributeTests(int testCaseCount) throws Exception {

	ExecutorService executorService = Executors.newFixedThreadPool(testCaseCount);
	for (final Class testCase : testCases) {
	  CTLogger.writeToLog("testCase - " + testCase.getName());
	  executorService.submit(new Runnable() {
		public void run() {
		  System.out.println("Running test file: " + testCase + Thread.currentThread().getId());
		  runTestCase(testCase);

		}
	  });
	}
	executorService.shutdown();
	try {
	  executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
	} catch (InterruptedException e) {
	  e.printStackTrace();
	}
	try {
	  Thread.sleep(3000);
	} catch (InterruptedException e) {
	  e.printStackTrace();
	}
  }

  /**
   * Method is used to run test cases
   *
   * @param testCase - represents test case
   */
  public void runTestCase(Class testCase) {
	Result result = JUnitCore.runClasses(testCase);
	for (Failure failure : result.getFailures()) {
	  System.out.println(failure.toString());
	}
  }

  /**
   * Main method
   *
   * @param args - represents command line arguments
   * @throws Exception - represents exception
   */
  public static void main(String[] args) throws Exception {
	API_Executor aaftExecutor = new API_Executor();
	System.out.println("Curr dir - " + System.getProperty("user.dir"));
	
	ListAllRunner listAllRunner = new ListAllRunner();
    testCases = listAllRunner.getAllRunnerClasses("api");
    
	CTLogger.writeToLog("Running no. of tests - " + testCases.size());
	aaftExecutor.distributeTests(testCases.size());
  }

}
