package com.accenture.aaft.excel.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

import com.accenture.aaft.propertyreader.PropertyFileReader;
import com.accenture.aaft.vo.ExcelTestDataVO;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

/**
 * Class is used to read the test data from excel
 *
 * @author vijay.venkatappa
 */
public class ExcelTestDataReader {

  /**
   * Method is used to read the test data from excel
   *
   * @param testName - represents script name
   * @return LinkedHashMap contains script name and test data
   */
  public LinkedHashMap<String, List<ExcelTestDataVO>> readTestData(String testName) {

	//CTLogger.writeToLog("ExcelTestDataReader", "readWorkbook()", "started");
	PropertyFileReader propertyFileReader = new PropertyFileReader();
	String filePath = System.getProperty("user.dir") +System.getProperty("file.separator") + propertyFileReader.getValue("TEST_DATA_FILE");

	LinkedHashMap<String, List<ExcelTestDataVO>> iterationDataMap = new LinkedHashMap<String, List<ExcelTestDataVO>>();
	WorkbookSettings workbookSettingsForTestData = null;
	Workbook workbookForTestData = null;

	File fileForTestData = null;

	FileInputStream fileInputStreamForTestData = null;

	try {
	  fileForTestData = new File(filePath);
	  fileInputStreamForTestData = new FileInputStream(fileForTestData);
	  workbookSettingsForTestData = new WorkbookSettings();
	  workbookSettingsForTestData.setLocale(new Locale("en", "EN"));
	  workbookForTestData = Workbook.getWorkbook(fileInputStreamForTestData, workbookSettingsForTestData);
	  Sheet sheetDetailsForTestData = workbookForTestData.getSheet(0);
	  int rowCount = sheetDetailsForTestData.getRows();

	  List<String> listIteration = new ArrayList<String>();
	  for (int i = 6; i < rowCount; i++) {

		String scriptName = sheetDetailsForTestData.getCell(1, i).getContents();
		String value = sheetDetailsForTestData.getCell(2, i).getContents();

		if (value.equalsIgnoreCase("yes") && scriptName.equals(testName)) {
		  String value1 = sheetDetailsForTestData.getCell(0, i).getContents();
		  listIteration.add(value1);
		}
	  }

	  int columnCount = sheetDetailsForTestData.getColumns();

	  for (String iteration : listIteration) {
		List<ExcelTestDataVO> listExcelTestDataVOs = new ArrayList<ExcelTestDataVO>();
		for (int i = 1; i < columnCount; i++) {
		  String rowData = sheetDetailsForTestData.getCell(i, (Integer.parseInt(iteration))+6 - 1).getContents();
		  ExcelTestDataVO excelTestDataVO = new ExcelTestDataVO();
		  if (i == 1) {
			excelTestDataVO.setName("testName");
			excelTestDataVO.setValue(rowData.trim());
			listExcelTestDataVOs.add(excelTestDataVO);
		  } else if (i == 2) {
		  } else {
			if (rowData.contains("=")) {
			  String[] nameValue = rowData.split("=");
			  excelTestDataVO.setName(nameValue[0].trim());
			  excelTestDataVO.setValue(nameValue[1].trim());
			  listExcelTestDataVOs.add(excelTestDataVO);
			}
		  }
		}
		iterationDataMap.put(iteration, listExcelTestDataVOs);
	  }
	} catch (Exception e) {
	  e.printStackTrace();
	} finally {
	  //CTLogger.writeToLog("ExcelTestDataReader", "readWorkbook()", "finally block called");
	  workbookSettingsForTestData = null;
	  workbookForTestData = null;
	  fileForTestData = null;

	  try {
		fileInputStreamForTestData.close();
	  } catch (IOException e) {
		e.printStackTrace();
	  }
	}

	return iterationDataMap;
  }

}
