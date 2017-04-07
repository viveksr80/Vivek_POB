package com.accenture.aaft.selenium.library.utility;

import java.io.IOException;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.accenture.aaft.propertyreader.PropertyFileReader;

/**
 * Class is used to send the status of the Testcase to the Touchless database
 *
 * @author vijay.venkatappa
 *
 */
public class RestCall {
	
	static String REST_URL = null;
	static String PROJECT_NAME = null;

	public String simpleGet(String tc, String rslt) {
		String returnString = null;
		
		if (REST_URL == null || PROJECT_NAME == null) {
			PropertyFileReader propertyFileReader = new PropertyFileReader();
			REST_URL = propertyFileReader.getValue("LIVE_REPORTING_URL");
			PROJECT_NAME = propertyFileReader.getValue("LIVE_REPORTING_PROJECT");
			REST_URL = (REST_URL != null && !REST_URL.trim().isEmpty()) ? REST_URL : "";
			PROJECT_NAME = (PROJECT_NAME != null && !PROJECT_NAME.trim().isEmpty()) ? PROJECT_NAME : "";
		}
		
		if (tc != null && rslt != null && (REST_URL != null && !REST_URL.trim().isEmpty()) && (PROJECT_NAME != null && !PROJECT_NAME.trim().isEmpty())) {		
			try {
				String baseUrl = REST_URL + "/platform/rest/pipelineresult?ty=update";
				baseUrl += "&tc=" + tc + "&r=" +  rslt + "&pid=" + PROJECT_NAME;
				CloseableHttpClient client = HttpClients.custom().build();
				try {
					HttpGet httpget = new HttpGet(baseUrl);
					CloseableHttpResponse response = client.execute(httpget);
					try {
						returnString = EntityUtils.toString(response.getEntity());
					} finally {
						response.close();
					}
				} finally {
					client.close();
				}
			} catch (ParseException | IOException e) {
				e.printStackTrace();
			}
		}
		
		return returnString;
	}

}
