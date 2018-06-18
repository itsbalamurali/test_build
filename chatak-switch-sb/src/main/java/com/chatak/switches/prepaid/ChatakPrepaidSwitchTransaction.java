/**
 * 
 */
package com.chatak.switches.prepaid;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import com.chatak.pg.constants.ActionErrorCode;
import com.chatak.pg.constants.ISOConstants;
import com.chatak.pg.util.Constants;
import com.chatak.pg.util.LogHelper;
import com.chatak.pg.util.LoggerMessage;
import com.chatak.switches.jpos.SwitchISOPackager;
import com.chatak.switches.sb.SwitchTransaction;
import com.chatak.switches.sb.channel.ChatakSwitchChannel;
import com.chatak.switches.sb.exception.ChatakSwitchException;
import com.chatak.switches.sb.util.ThreadPool;
import com.chatak.switches.services.TransactionService;

/**
 *
 * << Add Comments Here >>
 *
 * @author Girmiti Software
 * @date 24-Jan-2015 2:44:05 PM
 * @version 1.0
 */
public class ChatakPrepaidSwitchTransaction implements SwitchTransaction {
  
  private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(TransactionService.class);

  private final static String SWITCH_NAME = "Ipsidy Prepaid";
  
  private String hostIp;
  private Integer port;
  
  @Override
  public void initConfig(String hostIp, Integer port) {
  	this.hostIp=hostIp;
  	this.port=port;
  }

  @Override
  public ISOMsg auth(ISOMsg isoMsg) throws ChatakSwitchException {
    ISOMsg isoMsgResponse = null;
    try {
      isoMsgResponse = sendMsgToChatakSwitchChannel(isoMsg);
    }
    catch(Exception e) {
      LogHelper.logError(log, LoggerMessage.getCallerName(), e, e.getMessage());
      throw new ChatakSwitchException(ActionErrorCode.ERROR_CODE_91);
    }
    return isoMsgResponse;
  }

  @Override
  public ISOMsg authAdviceRepeat(ISOMsg isoMsg) throws ChatakSwitchException {
    ISOMsg isoMsgResponse = null;
    try {
      isoMsgResponse = sendMsgToChatakSwitchChannel(isoMsg);
    }
    catch(Exception e) {
      LogHelper.logError(log, LoggerMessage.getCallerName(), e, e.getMessage());
      throw new ChatakSwitchException(ActionErrorCode.ERROR_CODE_91);
    }
    return isoMsgResponse;
  }

  @Override
  public ISOMsg authAdvice(ISOMsg isoMsg) throws ChatakSwitchException {
    ISOMsg isoMsgResponse = null;
    try {
      isoMsgResponse = sendMsgToChatakSwitchChannel(isoMsg);
    }
    catch(Exception e) {
        LogHelper.logError(log, LoggerMessage.getCallerName(), e, e.getMessage());
      throw new ChatakSwitchException(ActionErrorCode.ERROR_CODE_91);
    }
    return isoMsgResponse;
  }

  @Override
  public ISOMsg financial(ISOMsg isoMsg) throws ChatakSwitchException {
    LogHelper.logEntry(log, LoggerMessage.getCallerName());
    ISOMsg isoMsgResponse = null;
    try {
      isoMsgResponse = sendMsgToChatakSwitchChannel(isoMsg);
    }
    catch(java.io.IOException e) {
        LogHelper.logError(log, LoggerMessage.getCallerName(), e, e.getMessage());
      throw new ChatakSwitchException("Unable to connect to HOST - Processor");
    }
    catch(Exception e) {
        LogHelper.logError(log, LoggerMessage.getCallerName(), e, e.getMessage());
      throw new ChatakSwitchException(ActionErrorCode.ERROR_CODE_91);
    }
    LogHelper.logExit(log, LoggerMessage.getCallerName());
    return isoMsgResponse;
  }

  @Override
  public ISOMsg financialAdvice(ISOMsg isoMsg) throws ChatakSwitchException {
    ISOMsg isoMsgResponse = null;
    try {
      isoMsgResponse = sendMsgToChatakSwitchChannel(isoMsg);
    }
    catch(Exception e) {
        LogHelper.logError(log, LoggerMessage.getCallerName(), e, e.getMessage());
      throw new ChatakSwitchException(ActionErrorCode.ERROR_CODE_91);
    }
    return isoMsgResponse;
  }

  @Override
  public ISOMsg financialAdviceRepeat(ISOMsg isoMsg) throws ChatakSwitchException {
    ISOMsg isoMsgResponse = null;
    try {
      isoMsgResponse = sendMsgToChatakSwitchChannel(isoMsg);
    }
    catch(Exception e) {
        LogHelper.logError(log, LoggerMessage.getCallerName(), e, e.getMessage());
    }
    return isoMsgResponse;
  }

  @Override
  public ISOMsg reversal(ISOMsg isoMsg) throws ChatakSwitchException {
    ISOMsg isoMsgResponse = null;
    try {
      isoMsgResponse = sendMsgToChatakSwitchChannel(isoMsg);
    }
    catch(Exception e) {
        LogHelper.logError(log, LoggerMessage.getCallerName(), e, e.getMessage());
    }
    return isoMsgResponse;
  }

  @Override
  public ISOMsg reversalAdvice(ISOMsg isoMsg) throws ChatakSwitchException {
    ISOMsg isoMsgResponse = null;
    try {
      isoMsgResponse = sendMsgToChatakSwitchChannel(isoMsg);
    }
    catch(Exception e) {
        LogHelper.logError(log, LoggerMessage.getCallerName(), e, e.getMessage());
    }
    return isoMsgResponse;
  }

  @Override
  public ISOMsg reversalAdviceRepeat(ISOMsg isoMsg) throws ChatakSwitchException {
    ISOMsg isoMsgResponse = null;
    try {
      isoMsgResponse = sendMsgToChatakSwitchChannel(isoMsg);
    }
    catch(Exception e) {
        LogHelper.logError(log, LoggerMessage.getCallerName(), e, e.getMessage());
    }
    return isoMsgResponse;
  }

  @Override
  public ISOMsg settlement(ISOMsg isoMsg) throws ChatakSwitchException {
    ISOMsg isoMsgResponse = null;
    try {
      isoMsgResponse = sendMsgToChatakSwitchChannel(isoMsg);
    }
    catch(Exception e) {
        LogHelper.logError(log, LoggerMessage.getCallerName(), e, e.getMessage());
    }
    return isoMsgResponse;
  }

  @Override
  public ISOMsg network(ISOMsg isoMsg) throws ChatakSwitchException {
    ISOMsg isoMsgResponse = null;
    try {
      isoMsgResponse = sendMsgToChatakSwitchChannel(isoMsg);
    }
    catch(Exception e) {
        LogHelper.logError(log, LoggerMessage.getCallerName(), e, e.getMessage());
    }
    return isoMsgResponse;
  }

  @Override
  public ISOMsg networkAdvice(ISOMsg isoMsg) throws ChatakSwitchException {
    ISOMsg isoMsgResponse = null;
    try {
      isoMsgResponse = sendMsgToChatakSwitchChannel(isoMsg);
    }
    catch(Exception e) {
        LogHelper.logError(log, LoggerMessage.getCallerName(), e, e.getMessage());
    }
    return isoMsgResponse;
  }
  
  /**
   * Init method
   * 
   * @param config
   */
  protected void initConfig() {
   new ThreadPool(Constants.FIVETHOUSAND, true);
  }
  
  /**
   * Method to send ISO Msg to Chatak Socket Channel
   * 
   * @return
   * @throws ISOException
   * @throws ChatakSwitchException
   * @throws IOException 
   */
  private ISOMsg sendMsgToChatakSwitchChannel(ISOMsg isoMsg) throws ISOException, ChatakSwitchException, IOException {
    LogHelper.logEntry(log, LoggerMessage.getCallerName());
	ChatakSwitchChannel chatakSwitchChannel = new ChatakSwitchChannel(hostIp, port, SwitchISOPackager.getChatakGenericPackager(), SWITCH_NAME);
    chatakSwitchChannel.connect();
    LogHelper.logInfo(log, LoggerMessage.getCallerName(), "Able to connect to processor..");
    LogHelper.logInfo(log, LoggerMessage.getCallerName(), "PAN Number in ISO Packet : " + isoMsg.getValue(ISOConstants.PAN));
    chatakSwitchChannel.send(isoMsg);
    LogHelper.logExit(log, LoggerMessage.getCallerName());
    return chatakSwitchChannel.receive();
  }
  
}
