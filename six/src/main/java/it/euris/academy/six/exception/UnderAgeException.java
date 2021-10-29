package it.euris.academy.six.exception;



public class UnderAgeException extends RuntimeException{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  

  public UnderAgeException() {
    super("The Film is forbidden for this user");
   }
  
  public UnderAgeException(String message) {
    super(message);
  }
}
