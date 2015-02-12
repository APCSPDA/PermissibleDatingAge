package com.mrjaffesclass.apcs.mvc.template;

import com.mrjaffesclass.apcs.messenger.*;

/**
 * The model represents the data that the app uses.
 * @author Roger Jaffe
 * @version 1.0
 */
public class Model implements MessageHandler {

  // Messaging system for the MVC
  private final Messenger mvcMessaging;
  
  private double youngest;
  private double oldest;
  // Model's data variables

  /**
   * Model constructor: Create the data representation of the program
   * @param messages Messaging class instantiated by the Controller for 
   *   local messages between Model, View, and controller
   */
  public Model(Messenger messages) 
  {
    mvcMessaging = messages;
  }
  
  /**
   * Initialize the model here and subscribe to any required messages
   */
  public void init() 
  {
    mvcMessaging.subscribe("view:age", this);
  }
  
  @Override
  public void messageHandler(String messageName, Object messagePayload) {
    if (messagePayload != null) {
      System.out.println("RCV (model): "+messageName+" | "+messagePayload.toString());
    } else {
      System.out.println("RCV (model): "+messageName+" | No data sent");
    }
    MessagePayload payload = (MessagePayload)messagePayload;
    int age = payload.getAge();
    double age1 = age;
    youngest = ((age1 / 2) + 7);
    oldest = ((age1-7) * 2);
    mvcMessaging.notify("model:youngestAge",youngest,true);
    mvcMessaging.notify("model:oldestAge",oldest,true);
  }
  

}
