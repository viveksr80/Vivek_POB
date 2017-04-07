package com.accenture.runner.vo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Locale;

import com.accenture.aaft.logger.CTLogger;
import com.accenture.aaft.propertyreader.PropertyFileReader;
import com.accenture.runner.vo.RunnerRepoVO;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

/**
 * Class is used to read the runner classes from excel
 *
 * 
 * @author vijay.venkatappa
 */
public class ExcelRunnerRepoReader {

  /**
   * Method is used to read the runner classes from excel
   *
   * 
   * @return LinkedHashMap contains serial no and RunnerRepoVO
   */
  public LinkedHashMap<String, RunnerRepoVO> readRunnerRepo(String runnerType) {
	
	if(runnerType.equalsIgnoreCase("selenium")){
      runnerType="SELENIUM_REPO_PATH";
    }
    else if(runnerType.equalsIgnoreCase("platform")){
      runnerType="PLATFORM_REPO_PATH";
    }
    else if(runnerType.equalsIgnoreCase("api")){
      runnerType="API_REPO_PATH";
    }
    else if(runnerType.equalsIgnoreCase("bdd")){
      runnerType="BDD_REPO_PATH";
    }
	CTLogger.writeToLog("RunnerRepoReader", "readRunnerRepo()", "started");
	PropertyFileReader propertyFileReader = new PropertyFileReader();
	String filePath = System.getProperty("user.dir") + propertyFileReader.getValue(runnerType);
	
	LinkedHashMap<String, RunnerRepoVO> map = new LinkedHashMap<String, RunnerRepoVO>();

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

		RunnerRepoVO runnerRepoVO = new RunnerRepoVO();
		runnerRepoVO.setSlName(sheetDetailsForScript.getCell(0, i).getContents().trim());
		runnerRepoVO.setRunnerClassName(sheetDetailsForScript.getCell(1, i).getContents().trim());
		runnerRepoVO.setExecute(sheetDetailsForScript.getCell(2, i).getContents().trim());
		
		map.put(sheetDetailsForScript.getCell(0, i).getContents().trim(), runnerRepoVO);

	  }

	} catch (Exception e) {
	  e.printStackTrace();
	} finally {
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
