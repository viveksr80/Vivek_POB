package com.accenture.aaft.util;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.accenture.aaft.propertyreader.PropertyFileReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ToscaToExtentReportConverter {

  public static void main(String[] args) {
	String fileName = System.getProperty("user.dir")+"\\report"+"\\result.xml";
	System.out.println("Tosca result file - "+fileName);
	String xpath = "/testsuites/testsuite";
	convertToscaToExtentReport(fileName, xpath);
  }
  private static void convertToscaToExtentReport(String fileName, String xpath) {
	Document document;
	NodeList testSuiteNodes = null;
	NodeList testCaseNodes = null;
	System.out.println("convertToscaToExtentReport");

	try {
	  document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(fileName));
	  XPath xPath = XPathFactory.newInstance().newXPath();

	  // get all test suites
	  testSuiteNodes = (NodeList) xPath.evaluate(xpath, document.getDocumentElement(), XPathConstants.NODESET);
	  if (null != testSuiteNodes) {
		System.out.println("No. of Test Suites - " + testSuiteNodes.getLength());

		if (null != testSuiteNodes && testSuiteNodes.getLength() > 0) {
		  PropertyFileReader propertyFileReader = new PropertyFileReader();
		 String filePath = propertyFileReader.getValue("SELENIUM_REPORT_FILENAME");
		 System.out.println("selenium report file name - "+filePath);
			
		  ExtentReports extentManager = new ExtentReports(filePath, false);

		  for (int i = 0; i < testSuiteNodes.getLength(); i++) {

			Node testSuite = testSuiteNodes.item(i);
			String testSuiteName = null;
			if (testSuite instanceof Element) {
			  testSuiteName = ((Element) testSuite).getAttribute("name");
			  System.out.println("Test suite name - " + testSuiteName);
			}

			String testCaseXpath = "testcase";
			XPathFactory.newInstance().newXPath();
			testCaseNodes = (NodeList) xPath.evaluate(testCaseXpath, testSuite, XPathConstants.NODESET);
			System.out.println("No. of Test Cases - " + testCaseNodes);

			// get all test cases
			if (null != testCaseNodes) {
			  String testCaseName = null;
			  for (int j = 0; j < testCaseNodes.getLength(); j++) {
				Node testCase = testCaseNodes.item(j);
				if (testCase instanceof Element) {
				  testCaseName = ((Element) testCase).getAttribute("name");
				  System.out.println("Test case name - " + testCaseName);
				  System.out.println("value - " + testCase.getTextContent());

				  ExtentTest extentTest = extentManager.startTest("Tosca Test : " + testSuiteName + "-" + testCaseName, testCaseName);
				  
				  extentTest.log(LogStatus.INFO, testCaseName);
				  extentTest.log(LogStatus.PASS, testCaseName + " executed successfully!");
				  extentTest.log(LogStatus.INFO, testCase.getTextContent());
				  extentManager.endTest(extentTest);
				  extentManager.flush();
				}
			  }
			}
		  }

		}
	  }
	} catch (SAXException e) {
	  // TODO Auto-generated catch block
	  e.printStackTrace();
	} catch (IOException e) {
	  // TODO Auto-generated catch block
	  e.printStackTrace();
	} catch (ParserConfigurationException e) {
	  // TODO Auto-generated catch block
	  e.printStackTrace();
	} catch (XPathExpressionException e) {
	  // TODO Auto-generated catch block
	  e.printStackTrace();
	}
  }
}
