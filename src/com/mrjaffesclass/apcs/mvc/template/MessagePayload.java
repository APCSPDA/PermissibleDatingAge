package com.mrjaffesclass.apcs.mvc.template;

/**
 * This is the message payload class.  Instantiate this class when sending
 * field / value message data for the up/down buttons
 * 
 * @author Roger Jaffe
 * @version 1.0
 */
public class MessagePayload {
  
  private final int age;
  
  
  /**
   * Class constructor
   * @param _age 
   */
  public MessagePayload(int _age) 
  {
    age = _age;
    
  }
 
  /**
   * Getter method for the 
   * @return 
   */
  public int getAge() {
    return age;
  }
  
}
