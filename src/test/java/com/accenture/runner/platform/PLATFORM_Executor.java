package com.accenture.runner.platform;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.accenture.aaft.logger.CTLogger;
import com.accenture.aaft.propertyreader.PropertyFileReader;
import com.accenture.runner.utility.ListAllRunner;

/**
 * Class is used to execute multiple platform based tests in parallel
 *
 * @author vijay.venkatappa
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class PLATFORM_Executor {

  static List<Class> testCases = new ArrayList();

  /**
   * Method is used to distribute the tests
   *
   * @param testCaseCount - represents test case count
   * @throws Exception - represents exception
   */
  public void distributeTests(List<Class> testCases) throws Exception {
	  
		ExecutorService executorService = Executors.newFixedThreadPool(testCases.size());
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
  public static void main(String[] args) throws Exception {System.out.println("Curr dir - " + System.getProperty("user.dir"));
	PLATFORM_Executor aaftExecutor = new PLATFORM_Executor();
    ListAllRunner listAllRunner = new ListAllRunner();
	PropertyFileReader propertyFileReader = new PropertyFileReader();
	String parallelExecution = propertyFileReader.getValue("PARALLEL_EXECUTION");
	
    testCases = listAllRunner.getAllRunnerClasses("platform");
	
	if(null != parallelExecution && parallelExecution.equalsIgnoreCase("Yes")){
		aaftExecutor.distributeTests(testCases);
	}else{
		for (Class clazz : listAllRunner.getAllRunnerClasses("platform")) {
			JUnitCore junit = new JUnitCore();
			Result result = junit.run(clazz);
			for (Failure failure : result.getFailures()) {
				System.out.println(failure.toString());
			}
		}
	}
 	}

}
