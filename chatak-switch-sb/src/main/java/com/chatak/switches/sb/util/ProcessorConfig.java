/**
 * 
 */
package com.chatak.switches.sb.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.chatak.pg.acq.dao.model.PGParams;
import com.chatak.pg.util.EncryptionUtil;
import com.chatak.pg.util.Properties;

/**
 * << Add Comments Here >>
 * 
 * @author Girmiti Software
 * @date 29-Aug-2015 12:34:30 PM
 * @version 1.0
 */
public final class ProcessorConfig {
  
  private static Logger logger = Logger.getLogger(ProcessorConfig.class);

  public static final String LITLE_PREFIX = "LITLE_";
  
  public static final String PRELIVE = "PRELIVE";

  public static final String DEMO = "DEMO";

  public static final String LIVE = "LIVE";
  
  public static final String PASS = "PASS_";

  public static final String USER = "USER_";

  public static final String URL = "URL_";
  
  public static final String MAG_TEK_KEY = "MAG_TEK_KEY";

  public static final String MID = "MID_";

  protected static Map<String, String> processorConfiguration = new HashMap<String, String>();
  
  public static final String FEE_SERVICE = "FEE_SERVICE_";


  public static void setProcessorConfiguration(List<PGParams> pgParams) {
    for(PGParams pgParam : pgParams) {
      if(MAG_TEK_KEY.equals(pgParam.getParamName())) {
        try {
          processorConfiguration.put(pgParam.getParamName(),
                              EncryptionUtil.decrypt(pgParam.getParamValue(), Properties.getProperty("chatak.pay.salt.key")));
        }
        catch(Exception e) {
          logger.error("ERROR:: ProcessorConfig:: setProcessorConfig method", e);
        }
      }
      else {
        processorConfiguration.put(pgParam.getParamName(), pgParam.getParamValue());
      }
    }

  }

  public static String get(String key) {
    return processorConfiguration.get(key);
  }
  
  private ProcessorConfig() {
  }

}
