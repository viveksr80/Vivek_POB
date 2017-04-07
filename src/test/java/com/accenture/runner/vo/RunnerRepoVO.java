package com.accenture.runner.vo;

/**
 * Class is used to store function runner info values
 *
 * @author vijay.venkatappa
 *
 */
public class RunnerRepoVO {
  
  String slName;
  String runnerClassName;
  String execute;
  
  
  /**
   * @return the runnerClassName
   */
  public String getRunnerClassName() {
    return runnerClassName;
  }
  /**
   * @param runnerClassName the runnerClassName to set
   */
  public void setRunnerClassName(String runnerClassName) {
    this.runnerClassName = runnerClassName;
  }
 
  /**
   * @return the slName
   */
  public String getSlName() {
    return slName;
  }
  /**
   * @param slName the slName to set
   */
  public void setSlName(String slName) {
    this.slName = slName;
  }
  /**
   * @return the execute
   */
  public String getExecute() {
    return execute;
  }
  /**
   * @param execute the execute to set
   */
  public void setExecute(String execute) {
    this.execute = execute;
  }
  
  
}
