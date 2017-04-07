package com.accenture.aaft.excel.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.accenture.aaft.logger.CTLogger;
import com.accenture.aaft.propertyreader.PropertyFileReader;
import com.accenture.aaft.vo.ExcelTestScriptVO;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

/**
 * Class is used to read script from excel
 *
 * @author vijay.venkatappa
 */
public class ExcelTestScriptReader {

  /**
   * Method is used to read script from excel
   *
   * @param scriptName - represents script name
   * @return List of ExcelTestScriptVO instances
   */

  public List<ExcelTestScriptVO> readWorkbook(String scriptName) {

	//CTLogger.writeToLog("ExcelTestScriptReader", "readWorkbook()", "started");
	PropertyFileReader propertyFileReader = new PropertyFileReader();
	String filePath =  System.getProperty("user.dir") +System.getProperty("file.separator") + propertyFileReader.getValue("TEST_SCRIPT_FOLDER");
	filePath = filePath + scriptName + ".xls";
	List<ExcelTestScriptVO> excelTestScriptVOsList = new ArrayList<ExcelTestScriptVO>();

	WorkbookSettings workbookSettingsForScript = null;
	Workbook workbookForScript = null;
	File fileForScript = null;
	FileInputStream fileInputStreamForScript = null;

	try {
	  fileForScript = new File(filePath);
	  fileInputStreamForScript = new FileInputStream(fileForScript);
	  workbookSettingsForScript = new WorkbookSettings();
	  workbookSettingsForScript.setLocale(new Locale("en", "EN"));
	  workbookForScript = Workbook.getWorkbook(fileInputStreamForScript, workbookSettingsForScript);
	  Sheet sheetDetailsForScript = workbookForScript.getSheet(0);
	  int rows = sheetDetailsForScript.getRows();

	  for (int i = 7; i < rows; i++) {
		ExcelTestScriptVO excelTestScriptVO = new ExcelTestScriptVO();
		excelTestScriptVO.setTestStepNo(sheetDetailsForScript.getCell(0, i).getContents().trim());
		excelTestScriptVO.setTestStepDetails(sheetDetailsForScript.getCell(1, i).getContents().trim());
		excelTestScriptVO.setMainWindow(sheetDetailsForScript.getCell(2, i).getContents().trim());
		excelTestScriptVO.setScreen(sheetDetailsForScript.getCell(3, i).getContents().trim());
		excelTestScriptVO.setKeyword(sheetDetailsForScript.getCell(4, i).getContents().trim());
		excelTestScriptVO.setControlName(sheetDetailsForScript.getCell(5, i).getContents().trim());
		excelTestScriptVO.setParam1(sheetDetailsForScript.getCell(6, i).getContents().trim());
		excelTestScriptVO.setParam2(sheetDetailsForScript.getCell(7, i).getContents().trim());
		excelTestScriptVO.setParam3(sheetDetailsForScript.getCell(8, i).getContents().trim());
		excelTestScriptVO.setCondition(sheetDetailsForScript.getCell(9, i).getContents().trim());
		excelTestScriptVOsList.add(excelTestScriptVO);
	  }

	} catch (Exception e) {
	  e.printStackTrace();
	} finally {
	  //CTLogger.writeToLog("ExcelTestScript", "readWorkbook()", "finally block called");
	  workbookSettingsForScript = null;
	  workbookForScript = null;
	  fileForScript = null;

	  try {
		fileInputStreamForScript.close();

	  } catch (IOException e) {
		e.printStackTrace();
	  }
	}

	return excelTestScriptVOsList;
  }

  /**
   * Main method
   *
   * @param args - arguments
   */
  public static void main(String[] args) {
	ExcelTestScriptReader excelTestScript = new ExcelTestScriptReader();
	excelTestScript.readWorkbook(".\\testscriptrepository\\testscripts\\HotelReservationTestScript.xls");
  }
}
