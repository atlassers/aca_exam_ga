package it.euris.academy.six.exception;



public class HallFullException extends RuntimeException{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  

  public HallFullException() {
    super("The Hall is Full, There are no tickets left");
   }
  
  public HallFullException(String message) {
    super(message);
  }
}
