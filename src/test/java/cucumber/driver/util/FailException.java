package cucumber.driver.util;

/**
 * Class is used for Exception
 *
 * @author vijay.venkatappa
 *
 */
public class FailException extends Exception {

  private static final long serialVersionUID = 1L;
  String message;

  /**
   * @param message - represents fail message
   */
  public FailException(String message) {
	this.message = message;
  }

  @Override
  public String getMessage() {
	return message;
  }
}