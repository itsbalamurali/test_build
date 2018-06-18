/**
 * 
 */
package com.chatak.switches.sb.util;

import org.springframework.context.ApplicationContext;


/**
 *
 * << Add Comments Here >>
 *
 * @author Girmiti Software
 * @date 08-Dec-2014 4:24:58 pm
 * @version 1.0
 */
public class SpringDAOBeanFactory {
  
  private SpringDAOBeanFactory() {
 // Do nothing
  }

  private static ApplicationContext appContext;
  
  public static ApplicationContext getSpringContext() {
    return appContext;
  }

public static ApplicationContext getAppContext() {
	return appContext;
}

public static void setAppContext(ApplicationContext appContext) {
	SpringDAOBeanFactory.appContext = appContext;
}
}
