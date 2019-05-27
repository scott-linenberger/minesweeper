package com.scottlinenberger.minesweeper.log;

import java.util.Map;

public class Logger {

  private static final String format = "[%s]: %s";
  private String classname;
  
  private boolean isLogging;
  
  public Logger(Class<?> clazz) {
    isLogging = isDebugEnabled();
    this.classname = clazz.getSimpleName();
  }
  
  public void log(String msg) {
    if (!isLogging) {
      return;
    }
    
    System.out.println(
        String.format(
            format,
            this.classname,
            msg));
  }
  
  private static boolean isDebugEnabled() {
    Map<String, String> environment = System.getenv();
    
    String debugProperty = environment.get("debug.enabled");
    
    if (debugProperty == null) {
      return false;
    }
    
    /* it debug isn't enabled, do nothing */
    if (debugProperty.equals("true")) {
      return true;
    }
    
    
    if (debugProperty.equals("1")) {
      return true;
    }
    
    return false;
  }
  
}
