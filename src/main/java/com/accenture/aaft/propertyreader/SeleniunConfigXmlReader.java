package com.accenture.aaft.propertyreader;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Set;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.accenture.aaft.vo.SeleniunConfigXmlReaderVO;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class SeleniunConfigXmlReader {

	 public  LinkedHashMap<String, SeleniunConfigXmlReaderVO> read(String xml) throws Exception {
		    LinkedHashMap<String, SeleniunConfigXmlReaderVO> map = new LinkedHashMap<>();
	        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	        Document doc =  builder.parse(xml);
	        Element css =doc.getDocumentElement();
	        NodeList nodeList = css.getElementsByTagName("name");
	    	
	          for(int i=0; i<nodeList.getLength(); i++) {
	        	Node node = nodeList.item(i);
	        	NamedNodeMap attribute =  node.getAttributes();
	        	Node nodeValue = attribute.getNamedItem("value");
	        	Node nodeValue1 = attribute.getNamedItem("for");
	        	Node nodeValue2 = attribute.getNamedItem("type");
	        	String value= nodeValue.getNodeValue();
	        	
	            Element rule = (Element)nodeList.item(i);
	            if(null !=rule.getElementsByTagName("os").item(0) && null !=rule.getElementsByTagName("browserVersion").item(0) && null!=rule.getElementsByTagName("browserVersion").item(0)){
	            	String os = rule.getElementsByTagName("os").item(0).getTextContent();
		            String browserVersion = rule.getElementsByTagName("browserVersion").item(0).getTextContent();
		            String browserName = rule.getElementsByTagName("browserName").item(0).getTextContent();
		            
		            SeleniunConfigXmlReaderVO seleniunConfigXmlReaderVO = new SeleniunConfigXmlReaderVO();
		            seleniunConfigXmlReaderVO.setBrowserName(browserName);
		            seleniunConfigXmlReaderVO.setOs(os);
		            seleniunConfigXmlReaderVO.setBrowserVersion(browserVersion);
		            
		            if(nodeValue1.getNodeValue().equalsIgnoreCase("browser") && nodeValue2.getNodeValue().equalsIgnoreCase("saucelabs")){
		            if(!os.equals("") && !browserVersion.equals("") && !browserName.equals("")){
		            map.put(value, seleniunConfigXmlReaderVO);
		            }   
	           }
	          }
	        }
	       			
	        return map;
	    }
	 
	 /**
	 * @return
	 */
	public LinkedList<String[]> getBrowserList() {
			LinkedList<String[]> browsers = new LinkedList<String[]>();
	    	LinkedHashMap<String, SeleniunConfigXmlReaderVO> map = null;
	    	SeleniunConfigXmlReader seleniunConfigXmlReader = new SeleniunConfigXmlReader();	
	    	try {
				map = seleniunConfigXmlReader.read(System.getProperty("user.dir")+"\\selenium-config.xml");
				Set<String> keyset = map.keySet();
		    	Iterator<String> it =  keyset.iterator();
		    	while(it.hasNext()){
		    		String key= it.next();
		    		SeleniunConfigXmlReaderVO vo =map.get(key);
		    		browsers.add(new String[]{vo.getOs(), vo.getBrowserVersion(), vo.getBrowserName()});
		    	}
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
	       return browsers;
		}
	 

public static void main(String[] args) throws Exception {
	SeleniunConfigXmlReader configXmlReader = new SeleniunConfigXmlReader();
	configXmlReader.read(System.getProperty("user.dir")+"\\selenium-config.xml");
	
}
}
