package cucumber.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import org.apache.commons.io.FilenameUtils;

import com.accenture.runner.vo.RunnerRepoVO;

import jxl.Cell;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * Class is used to generate the runner and step definition
 *
 * @author vijay.venkatappa
 *
 */
public class FeatureDefinitionGenerator {
  static PrintStream printStream = null;
  static FileOutputStream fileOutputStream = null;
  static String tag="";
  public static void main(String[] args) {
	// generate(".\\Features");
	//generate("C:\\CitrusBookStoreWorkSpace\\ContinuousTest");
	generate(System.getProperty("user.dir"));
  }

  private static void generateLogic(File currentFile, String projLocation) throws IOException {
	Scanner scanner;
	String fileName = FilenameUtils.removeExtension(currentFile.getName());
	fileName = (String.valueOf(fileName.charAt(0)).toUpperCase()) + fileName.substring(1);
	scanner = new Scanner(currentFile);
	createScriptFile(fileName, projLocation);
	while (scanner.hasNextLine()) {
	  String currentLine = scanner.nextLine();
	  currentLine = currentLine.trim();
	  if (currentLine.length() > 0) {
		if (currentLine.contains("@")) {
		  tag = currentLine;
		  System.out.println("Tag - "+tag);
		}
		if (currentLine.contains("Feature:") || currentLine.contains("Scenario:")) {
		  continue;
		}
		try {
		  String keyword = currentLine.substring(0, currentLine.indexOf(" "));
		  currentLine = currentLine.trim().substring(keyword.length() + 1);
		  String featureLine = currentLine.trim().replaceAll(" ", "_");
		  createMethod(keyword.trim(), currentLine, featureLine);
		} catch (IndexOutOfBoundsException exp) {
		  // no code;
		}
	  }
	}
	closeFile();
	String runnerFileName = createRunner(fileName, projLocation);
	RunnerRepoVO runnerRepoVO = new RunnerRepoVO();
	runnerRepoVO.setRunnerClassName(runnerFileName);
	runnerRepoVO.setExecute("Yes");
	updateRunner(runnerRepoVO);
	
	closeFile();
	scanner.close();
  }

  public static void generate(String projLocation, String fileName) throws IOException {

	if (fileName != null) {
	  if (fileName.contains(",")) {
		String[] fileNames = fileName.split(",");
		for (String thisFile : fileNames) {
		  thisFile = thisFile.trim();
		  File file = new File(projLocation + "\\src\\test\\resources\\cucumber\\features\\newfeature\\" + thisFile);
		  generateLogic(file, projLocation);
		}
	  } else {
		File file = new File(projLocation + "\\src\\test\\resources\\cucumber\\features\\newfeature\\" + fileName);
		generateLogic(file, projLocation);
	  }
	}

  }

  public static void generate(String projLocation) {
	System.out.println("generate");
	File file = new File(projLocation + "\\src\\test\\resources\\cucumber\\features\\newfeature");
	File[] files = file.listFiles();
	for (File currentFile : files) {
	  System.out.println("");
	  try {
		generateLogic(currentFile, projLocation);
	  } catch (IOException e) {
		e.printStackTrace();
	  }
	}
  }

  public static String createRunner(String fileName, String folder) {
	String runnerFileName = folder + "\\src\\test\\java\\com\\accenture\\runner\\bdd\\" + fileName + "Runner.java";
	String runnerFileNameWithPackage= "com.accenture.runner.bdd."+fileName + "Runner";
	File runnerFile = new File(runnerFileName);

	try {
	  fileOutputStream = new FileOutputStream(runnerFile);
	  printStream = new PrintStream(fileOutputStream);

	  printStream.println("package com.accenture.runner.bdd;\n");
	  printStream.println("import org.junit.runner.RunWith;");
	  printStream.println("import cucumber.api.CucumberOptions;");
	  printStream.println("import cucumber.api.junit.Cucumber; \n");
	  printStream.println("import org.junit.AfterClass;");
	  printStream.println("import org.junit.BeforeClass;");
	  printStream.println("import com.accenture.aaft.logger.CTLogger;");
	  printStream.println("import com.accenture.aaft.report.ExtentManager;");
	  printStream.println("import com.accenture.aaft.report.ExtentTestManager;");
	  printStream.println("import com.relevantcodes.extentreports.ExtentReports;");
	  printStream.println("\n");
	  printStream.println("@RunWith(Cucumber.class) ");
	  printStream.println("@CucumberOptions(features = \"target/test-classes/cucumber/features/\", tags = { \""+tag+"\" }, format = { \"html:target/cucumber-report/step\" },");
	  printStream.println("glue = { \"cucumber.stepdefs\", \"cucumber.stepdefs." + fileName + "\" })");
	  printStream.println("public class " + fileName + "Runner {");

	  printStream.println("\tstatic ExtentReports extent;");
	  printStream.println("\tstatic String scriptName = \"" + fileName + "\";");
	  printStream.println("\n");
	  printStream.println("@BeforeClass");
	  printStream.println("public static void runOnceBeforeClass() {");

	  printStream.println("\textent = ExtentManager.getExtentManager();");
	  printStream.println("\tExtentTestManager.startTest(\"Cucumber Test : \" + scriptName, \"" + fileName + "\");");
	  printStream.println("\tCTLogger.writeToLog(\"@BeforeClass " + fileName + " extent - \"+extent);");
	  printStream.println(" }");

	  printStream.println("\n");
	  printStream.println("@AfterClass");
	  printStream.println("public static void runOnceAfterClass() {");
	  printStream.println("\tCTLogger.writeToLog(\"@AfterClass " + fileName + " extent - \"+extent);");
	  printStream.println("\tExtentManager.getReporter().endTest(ExtentTestManager.getTest());");
	  printStream.println("\tExtentManager.getReporter().flush();");
	  printStream.println(" }");

	} catch (FileNotFoundException exp) {
	  exp.printStackTrace();
	}
	return runnerFileNameWithPackage;
  }

  public static void createScriptFile(String fileName, String folder) {

	String scriptFileName = folder + "\\src\\test\\java\\cucumber\\stepdefs\\" + fileName + ".java";
	
	File scriptFile = new File(scriptFileName);
	try {
	  fileOutputStream = new FileOutputStream(scriptFile);
	  printStream = new PrintStream(fileOutputStream);

	  printStream.println("package cucumber.stepdefs;");
	  printStream.println("");

	  printStream.println("import cucumber.api.PendingException;");
	  printStream.println("import cucumber.api.java.en.Given;");
	  printStream.println("import cucumber.api.java.en.When;");
	  printStream.println("import cucumber.api.java.en.Then;");
	  printStream.println("import cucumber.api.junit.Cucumber;");
	  printStream.println("import org.junit.runner.RunWith;");
	  printStream.println("import com.accenture.aaft.report.ExtentTestManager;");
	  printStream.println("import com.relevantcodes.extentreports.ExtentTest;");
	  printStream.println("import com.relevantcodes.extentreports.LogStatus;");
	  printStream.println("import com.accenture.aaft.logger.CTLogger;");

	  printStream.println("");

	  printStream.println("/**");
	  printStream.println("* Step Definitions for running tests using Cucumber");
	  printStream.println("* ");
	  printStream.println("* @author      Lalitha Yengaldas");
	  printStream.println("* @version     1.0");
	  printStream.println("*/");

	  printStream.println("@RunWith(Cucumber.class)");
	  printStream.println("public class " + fileName + " {");
	  printStream.println("");
	  printStream.println("static ExtentTest extentTest;");
	  printStream.println("public " + fileName + "() {");
	  printStream.println("try{");

	  printStream.println("\textentTest = ExtentTestManager.getTest();");
	  printStream.println("\textentTest.log(LogStatus.INFO, \"Starting test "+fileName+"\");");
	  printStream.println("\tCTLogger.writeToLog(\"" + fileName + " extentTest - \"+extentTest);");

	  printStream.println("}catch(Exception ex){");
	  printStream.println("\ttry {	");
	  printStream.println("\t\tex.printStackTrace();");
	  printStream.println("\tCTLogger.writeToLog(\"" + fileName + "\",\"constructor called\",\" exception occured\");");
	  printStream.println("} finally{");
	  printStream.println("\tString[] err = ex.getMessage().split(\"\\n\");");
	  printStream.println("\tString status = \"Exception \" +err[0].replaceAll(\"'\", \"\") + \" Occurred\";");
	  printStream.println("\textentTest.log(LogStatus.FAIL, \"failed to load dependency classes \"+status);");
	  printStream.println("}");
	  printStream.println("}");
	  printStream.println("}");

	} catch (FileNotFoundException e) {
	  printStream.println("e.printStackTrace();");
	  printStream.println("} catch (IOException e) {");
	  printStream.println("	e.printStackTrace();");
	}
  }

  private static void createMethod(String keyword, String currentLine, String featureLine) {

	printStream.println("/**");
	printStream.println("* Step definition for " + currentLine);
	printStream.println("*");
	printStream.println("* @param keyword  the keyword to display. ");
	printStream.println("* @param currentLine  description of step definition. ");
	printStream.println("* @param featureLine  the step definition to be invoked. ");
	printStream.println("*/");

	printStream.println("\t@" + keyword + "(\"^" + currentLine + "$\")");
	printStream.println("\t public void " + featureLine.toLowerCase() + "() throws Throwable {");

	printStream.println("\t extentTest.log(LogStatus.PASS, \"Entered " + featureLine.toLowerCase() + "\");");

	printStream.println("\t CTLogger.writeToLog(\"" + featureLine.toLowerCase() + "\");");

	printStream.println("\t extentTest.log(LogStatus.INFO, \"Coming out of " + featureLine.toLowerCase() + "\");");

	printStream.println("\t  throw new PendingException();");
	printStream.println("\t } ");
	printStream.println("");
  }

  /**
   * Method is used to update the runner to excel file
   *
   * @param runnerRepoVO - represents RunnerRepoVO
   */
  private static void updateRunner(RunnerRepoVO runnerRepoVO ) {
	//Creates a writable workbook with the given file name
    
    File oldFile = new File(System.getProperty("user.dir")+"/RunnerRepository/BDDRunnerRepo/BDDRunner-repo.xls");
    File oldTempFile = new File(System.getProperty("user.dir")+"/RunnerRepository/BDDRunnerRepo/temp/BDDRunner-repo.xls");
    File newFile = new File(System.getProperty("user.dir")+"/RunnerRepository/BDDRunnerRepo/BDDRunner-repo_new.xls");
    
    try {
	  Workbook existingWorkbook = Workbook.getWorkbook(oldFile);
	  if(oldTempFile.exists()){
    	oldTempFile.delete();
      }
	  Workbook.createWorkbook(oldTempFile, existingWorkbook);
      WritableWorkbook workbookCopy = Workbook.createWorkbook(newFile, existingWorkbook);
      WritableSheet sheetToEdit = workbookCopy.getSheet("Sheet1");
      
      int rowCount = sheetToEdit.getRows();
	  
	  Cell lastRow = sheetToEdit.getCell(0, rowCount-1);
	  runnerRepoVO.setSlName(lastRow.getContents());
      
      int slNo = Integer.parseInt(lastRow.getContents())+1;
	  sheetToEdit.addCell(new Label (0, rowCount, String.valueOf(slNo)));
	  sheetToEdit.addCell(new Label (1, rowCount, runnerRepoVO.getRunnerClassName()));
	  sheetToEdit.addCell(new Label (2, rowCount, runnerRepoVO.getExecute()));
	  
      workbookCopy.write();
      workbookCopy.close();
      existingWorkbook.close();
      oldFile.delete();
      newFile.renameTo(oldFile);
	  
    } catch (Exception e) {
	   
	    e.printStackTrace();
    } 
  }
  private static void closeFile() throws IOException {
	printStream.println("}");
	fileOutputStream.flush();
	printStream.flush();
	fileOutputStream.close();
	printStream.close();
  }

}
