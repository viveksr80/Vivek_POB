package com.accenture.aaft.excel.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Locale;

import com.accenture.aaft.propertyreader.PropertyFileReader;
import com.accenture.aaft.vo.ObjectMapVO;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

/**
 * Class is used to read the object map from excel
 *
 * 
 * @author vijay.venkatappa
 */
public class ObjectMapReader {

  /**
   * Method is used to read the object map
   *
   * @param fileName - represents object map excel
   * @return LinkedHashMap contains logical name of the UI object and path value
   */
  public LinkedHashMap<String, ObjectMapVO> readObjectMap(String fileName) {

	//CTLogger.writeToLog("ObjectMapReader", "readObjectMap()", "started");
	PropertyFileReader propertyFileReader = new PropertyFileReader();
	String filePath = System.getProperty("user.dir") +System.getProperty("file.separator") + propertyFileReader.getValue("OBJECT_MAP_FILE");
	filePath = filePath + fileName;
	LinkedHashMap<String, ObjectMapVO> map = new LinkedHashMap<String, ObjectMapVO>();

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

	  for (int i = 6; i < rows; i++) {

		ObjectMapVO objectMapVO = new ObjectMapVO();
		objectMapVO.setControlName(sheetDetailsForScript.getCell(0, i).getContents().trim());
		objectMapVO.setObjectPath(sheetDetailsForScript.getCell(1, i).getContents().trim());
		objectMapVO.setSelector(sheetDetailsForScript.getCell(2, i).getContents().trim());

		map.put(sheetDetailsForScript.getCell(0, i).getContents().trim(), objectMapVO);

	  }

	} catch (Exception e) {
	  e.printStackTrace();
	} finally {
	  //CTLogger.writeToLog("ObjectMapReader", "readObjectMap()", "finally block called");
	  workbookSettingsForScript = null;
	  workbookForScript = null;
	  fileForScript = null;

	  try {
		fileInputStreamForScript.close();

	  } catch (IOException e) {
		e.printStackTrace();
	  }
	}

	return map;

  }

}
