package com.accenture.aaft.vo;

/**
 * Value Object class
 * 
 * @author vijay.venkatappa
 *
 */
public class SeleniumConfigXmlReaderVO {

	String os;
	String browserVersion;
	String browserName;
	String execute;
	String appiumVersion;
	String deviceName;
	String deviceOrientation;
	String platformVersion;
	String platformName;
	String app;
	
	public String getExecute() {
		return execute;
	}
	public void setExecute(String execute) {
		this.execute = execute;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getBrowserVersion() {
		return browserVersion;
	}
	public void setBrowserVersion(String browserVersion) {
		this.browserVersion = browserVersion;
	}
	public String getBrowserName() {
		return browserName;
	}
	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}
	public String getAppiumVersion() {
		return appiumVersion;
	}
	public void setAppiumVersion(String appiumVersion) {
		this.appiumVersion = appiumVersion;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getDeviceOrientation() {
		return deviceOrientation;
	}
	public void setDeviceOrientation(String deviceOrientation) {
		this.deviceOrientation = deviceOrientation;
	}
	public String getPlatformVersion() {
		return platformVersion;
	}
	public void setPlatformVersion(String platformVersion) {
		this.platformVersion = platformVersion;
	}
	public String getPlatformName() {
		return platformName;
	}
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	public String getApp() {
		return app;
	}
	public void setApp(String app) {
		this.app = app;
	}
	

}
