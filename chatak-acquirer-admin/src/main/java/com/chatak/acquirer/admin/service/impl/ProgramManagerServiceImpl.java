package com.chatak.acquirer.admin.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chatak.acquirer.admin.constants.StatusConstants;
import com.chatak.acquirer.admin.controller.model.Option;
import com.chatak.acquirer.admin.exception.ChatakAdminException;
import com.chatak.acquirer.admin.service.ProgramManagerService;
import com.chatak.acquirer.admin.util.CommonUtil;
import com.chatak.acquirer.admin.util.DateUtils;
import com.chatak.acquirer.admin.util.JsonUtil;
import com.chatak.acquirer.admin.util.StringUtil;
import com.chatak.pg.acq.dao.BankDao;
import com.chatak.pg.acq.dao.CardProgramDao;
import com.chatak.pg.acq.dao.CountryDao;
import com.chatak.pg.acq.dao.CurrencyConfigDao;
import com.chatak.pg.acq.dao.ProgramManagerDao;
import com.chatak.pg.acq.dao.model.BankProgramManagerMap;
import com.chatak.pg.acq.dao.model.CardProgram;
import com.chatak.pg.acq.dao.model.PGBank;
import com.chatak.pg.acq.dao.model.PGCurrencyConfig;
import com.chatak.pg.acq.dao.model.PmCardProgamMapping;
import com.chatak.pg.acq.dao.model.ProgramManager;
import com.chatak.pg.acq.dao.model.ProgramManagerAccount;
import com.chatak.pg.bean.CountryRequest;
import com.chatak.pg.bean.Response;
import com.chatak.pg.bean.StateRequest;
import com.chatak.pg.bean.TimeZoneRequest;
import com.chatak.pg.constants.ActionCode;
import com.chatak.pg.constants.ActionErrorCode;
import com.chatak.pg.constants.PGConstants;
import com.chatak.pg.exception.HttpClientException;
import com.chatak.pg.model.CurrencyDTO;
import com.chatak.pg.user.bean.BankRequest;
import com.chatak.pg.user.bean.BankResponse;
import com.chatak.pg.user.bean.CardProgramRequest;
import com.chatak.pg.user.bean.CardProgramResponse;
import com.chatak.pg.user.bean.MerchantResponse;
import com.chatak.pg.user.bean.PartnerGroupPartnerMapRequest;
import com.chatak.pg.user.bean.ProgramManagerAccountRequest;
import com.chatak.pg.user.bean.ProgramManagerAccountResponse;
import com.chatak.pg.user.bean.ProgramManagerRequest;
import com.chatak.pg.user.bean.ProgramManagerResponse;
import com.chatak.pg.util.Constants;
import com.chatak.pg.util.DateUtil;
import com.chatak.pg.util.LogHelper;
import com.chatak.pg.util.LoggerMessage;
import com.chatak.pg.util.Properties;

@Service
@Transactional
public class ProgramManagerServiceImpl implements ProgramManagerService {

  private static Logger logger = Logger.getLogger(ProgramManagerServiceImpl.class);

  @Autowired
  ProgramManagerDao programManagerDao;
  
  @Autowired
  BankDao bankDao;
  
  @Autowired
  CardProgramDao cardProgramDao;
  
  @Autowired
  CurrencyConfigDao currencyConfigDao;
  
  @Autowired
  CountryDao countryDao;

  @Autowired
  MessageSource messageSource;
  
  private ObjectMapper mapper = new ObjectMapper();

  @Override
  @Transactional(rollbackFor=ChatakAdminException.class)
  public Response createProgramManager(ProgramManagerRequest programManagerRequest)
      throws ChatakAdminException {

    logger.info("Entering:: ProgramManagerServiceImpl :: createProgramManager method");
    Response response = new Response();
    Timestamp currentTimeStamp = getCurrentTimeStamp(programManagerRequest);

    // Check whether the program manager name already exists
    if (!StringUtil.isNull(programManagerRequest.getProgramManagerName())) {
      List<ProgramManager> listOfProgramManager =
          programManagerDao.findByProgramManagerName(programManagerRequest.getProgramManagerName());

      if (CommonUtil.isListNotNullAndEmpty(listOfProgramManager)) {
        if (programManagerRequest.getId() == null) {
          throw new ChatakAdminException(Constants.PROGRAM_MANAGER_ALREADY_EXISTS_WITH_NAME,Constants.PROGRAM_MANAGER_ALREADY_EXISTS_WITH_NAME); 
        }

        Boolean programManagerNameExists =
            isPmNameAlreadyExist(programManagerRequest, listOfProgramManager);

        if (programManagerNameExists) {
          throw new ChatakAdminException(Constants.PROGRAM_MANAGER_ALREADY_EXISTS_WITH_NAME,"Another Program manager with name "
                  + programManagerRequest.getProgramManagerName() + " already exist");
        }
      }
    }
    //Check whether PM already onboarded
    if(programManagerRequest.getProgramManagerType().equals(Constants.ONBOARDED)){
      List<ProgramManager> pmOnboarded = programManagerDao.findByIssuancePmid(programManagerRequest.getProgramManagerId());
      if(StringUtil.isListNotNullNEmpty(pmOnboarded)){
          throw new ChatakAdminException(Constants.PM_ALREADY_ONBOARDED,messageSource.getMessage(Constants.PM_ALREADY_ONBOARDED, null,LocaleContextHolder.getLocale()));
      }      
    }
    try {
    //PM details from issuance and save in Acquirer 
    	PGCurrencyConfig pGCurrencyConfig = new PGCurrencyConfig();
    ProgramManager pManager = new ProgramManager();
    pManager.setIssuancepmid(programManagerRequest.getProgramManagerId());
    pManager.setCompanyName(programManagerRequest.getCompanyName());
    pManager.setBusinessName(programManagerRequest.getBusinessName());
    pManager.setProgramManagerName(programManagerRequest.getProgramManagerName());
    pManager.setContactName(programManagerRequest.getContactName());
    pManager.setContactPhone(programManagerRequest.getContactPhone());
    pManager.setContactEmail(programManagerRequest.getContactEmail());
    pManager.setStatus(Constants.ACTIVE);
    pManager.setReason(programManagerRequest.getReason());
    pManager.setProgramManagerLogo(programManagerRequest.getProgramManagerLogo());
    pManager.setCreatedBy(programManagerRequest.getCreatedBy());
    pManager.setCreatedDate(new Timestamp(System.currentTimeMillis()));
    pManager.setUpdatedDate(currentTimeStamp);
    pManager.setUpdatedBy(programManagerRequest.getUpdatedBy());
    pManager.setExtension(programManagerRequest.getExtension());
			if (programManagerRequest.getProgramManagerType().equals(Constants.CREATE_INDEPENDENT)) {
				TimeZoneRequest timeZoneRequest = countryDao
						.findTimeZoneByID(Long.valueOf(programManagerRequest.getPmTimeZone()));
				CountryRequest countryRequest = countryDao
						.findCountryByID(Long.valueOf(programManagerRequest.getCountry()));
				StateRequest stateRequest = countryDao.findStateByID(Long.valueOf(programManagerRequest.getState()));
				String[] columns = programManagerRequest.getSchedulerRunTime().split(":");
				Calendar c = Calendar.getInstance();
				c.set(Calendar.HOUR, Integer.parseInt(columns[0]));
				c.set(Calendar.MINUTE, Integer.parseInt(columns[1]));
				if (columns.length == 3) {
					c.set(Calendar.SECOND, Integer.parseInt(columns[2]));
				} else {
					c.set(Calendar.SECOND, Integer.parseInt("00"));
				}
				Timestamp serverTime = new Timestamp(c.getTimeInMillis());
				String pmSchedulerRunTime = DateUtils.convertServerTimeToDeviceLocalTime(serverTime,
						timeZoneRequest.getStandardTimeOffset());
				String[] schedulerDate = pmSchedulerRunTime.split(" ");
				String pmSchedulerConvertedTime = DateUtils.convertSchedulerTimeToSystemTime(schedulerDate[1],
						programManagerRequest.getDeviceTimeZoneOffset());
				pManager.setPmSystemConvertedTime(pmSchedulerConvertedTime);
				pManager.setPmTimeZone(timeZoneRequest.getStandardTimeOffset());
				pManager.setCountry(countryRequest.getName());
				pManager.setState(stateRequest.getName());
			} else {
				pManager.setCountry(programManagerRequest.getCountry());
				pManager.setState(programManagerRequest.getState());
				pManager.setPmSystemConvertedTime(programManagerRequest.getStandardTimeOffset());
				pManager.setPmTimeZone(programManagerRequest.getPmTimeZone());
			}
    pManager.setBatchPrefix(programManagerRequest.getBatchPrefix());
    pManager.setSchedulerRunTime(programManagerRequest.getSchedulerRunTime());
    pManager.setDefaultProgramManager(programManagerRequest.getDefaultProgramManager());
    pManager.setAccountCurrency(programManagerRequest.getAccountCurrency()!=null ? programManagerRequest.getAccountCurrency() : programManagerRequest.getAcquirerCurrencyName());
    
    ProgramManager pmResponse = programManagerDao.saveOrUpdateProgramManager(pManager);
    PGCurrencyConfig pGCurrencyCode = null ;
    if(programManagerRequest.getProgramManagerType().equals(Constants.CREATE_INDEPENDENT)){
    	 pGCurrencyCode = currencyConfigDao.getCurrencyCodeNumeric(programManagerRequest.getAcquirerCurrencyName());
    }else{
    	 pGCurrencyCode = currencyConfigDao.getCurrencyCodeNumeric(programManagerRequest.getAccountCurrency());
    }
			if (StringUtil.isNull(pGCurrencyCode)) {
				ProgramManagerRequest currencyList = new ProgramManagerRequest();
				currencyList.setProgramManagerId(programManagerRequest.getProgramManagerId());
				ProgramManagerResponse programManagerResponse = getIssuanceProgramManagerById(currencyList);
				PGCurrencyConfig pgCurrencyConfig = new PGCurrencyConfig();
				CurrencyDTO currencyDTO = new CurrencyDTO();
				currencyDTO.setCurrencyName(programManagerResponse.getProgramManagersList().get(0)
						.getCurrencyConfigRequest().getCurrencyName());
				currencyDTO.setCurrencyCodeNumeric(programManagerResponse.getProgramManagersList().get(0)
						.getCurrencyConfigRequest().getCurrencyCodeNumeric());
				currencyDTO.setCurrencyCodeAlpha(programManagerResponse.getProgramManagersList().get(0)
						.getCurrencyConfigRequest().getCurrencyCodeAlpha().toUpperCase());
				currencyDTO.setCurrencyExponent(programManagerResponse.getProgramManagersList().get(0)
						.getCurrencyConfigRequest().getCurrencyExponent().intValue());
				currencyDTO.setCurrencySeparatorPosition(programManagerResponse.getProgramManagersList().get(0)
						.getCurrencyConfigRequest().getCurrencySeparatorPosition().intValue());
				currencyDTO.setCurrencyMinorUnit(programManagerResponse.getProgramManagersList().get(0)
						.getCurrencyConfigRequest().getCurrencyMinorUnit());
				currencyDTO.setCurrencyThousandsUnit(programManagerResponse.getProgramManagersList().get(0)
						.getCurrencyConfigRequest().getCurrencyThousandsUnit());
				currencyDTO.setCreatedBy(programManagerRequest.getCreatedBy());
				setPGCurrencyConfigDetails(currencyDTO, pgCurrencyConfig);
				pGCurrencyConfig = currencyConfigDao.saveCurrencyConfig(pgCurrencyConfig);
			}
    if(!programManagerRequest.getProgramManagerType().equals(Constants.CREATE_INDEPENDENT)){
    	 //Bank Details from issuance from issuance and save in acquirer
        BankRequest bankRequest = new BankRequest();
        List<Long> bankList = new ArrayList<>();
        String[] arrayList = programManagerRequest.getBankNames().split(",");
        for (int i = 0; i < arrayList.length; i++) {
          if (arrayList[i] != null) {
        	  bankList.add(Long.parseLong(arrayList[i]));
          }
        }
    bankRequest.setBankIds(bankList);
    BankResponse bankResponse = getBankDetailsByBankIds(bankRequest);

    BankRequest issuanceBankRequest = new BankRequest();
    BankResponse bankResp = new BankResponse();
    for( BankRequest bankReq : bankResponse.getBankRequests()){
  	  issuanceBankRequest.setIssuanceBankId(bankReq.getBankId());
  	  issuanceBankRequest.setBankName(bankReq.getBankName());
  	  issuanceBankRequest.setBankCode(bankReq.getBankCode());
  	  issuanceBankRequest.setStatus(bankReq.getStatus());
  	  issuanceBankRequest.setAddress1(bankReq.getAddress1());
  	  issuanceBankRequest.setAddress2(bankReq.getAddress2());
  	  issuanceBankRequest.setCity(bankReq.getCity());
  	  issuanceBankRequest.setState(bankReq.getState());
  	  issuanceBankRequest.setZip(bankReq.getZip());
  	  issuanceBankRequest.setCountry(bankReq.getCountry());
  	  issuanceBankRequest.setContactPersonCell(bankReq.getContactPersonCell());
  	  issuanceBankRequest.setContactPersonEmail(bankReq.getContactPersonEmail());
  	  issuanceBankRequest.setContactPersonFax(bankReq.getContactPersonFax());
  	  issuanceBankRequest.setContactPersonName(bankReq.getContactPersonName());
  	  issuanceBankRequest.setContactPersonPhone(bankReq.getContactPersonPhone());
  	  issuanceBankRequest.setCreatedBy(programManagerRequest.getCreatedBy());
  	  if(StringUtil.isNull(pGCurrencyCode)){
  		issuanceBankRequest.setCurrencyId(pGCurrencyConfig.getId());
  		issuanceBankRequest.setCurrencyCodeAlpha(pGCurrencyConfig.getCurrencyCodeAlpha());
  	  }else{
  		issuanceBankRequest.setCurrencyId(pGCurrencyCode.getId());
  		issuanceBankRequest.setCurrencyCodeAlpha(pGCurrencyCode.getCurrencyCodeAlpha());
  	  }
  	  issuanceBankRequest.setSettlAccountNumber(bankReq.getSettlAccountNumber());
  	  issuanceBankRequest.setSettlRoutingNumber(bankReq.getSettlRoutingNumber());
  	  List<PGBank> pgBank = bankDao.findByIssuanceBankId(bankReq.getBankId());
  	  if(StringUtil.isListNotNullNEmpty(pgBank)){
  	  bankResp.setErrorCode(ActionErrorCode.ERROR_CODE_B0);
  	  bankResp.setBankid(pgBank.get(0).getId());
  	  }else{
  	  bankResp = bankDao.createBank(issuanceBankRequest);  	    
  	  }
  	if(bankResp.getErrorCode().equals(ActionErrorCode.ERROR_CODE_B0)){
		 savePMBankMappingData( bankResp, pmResponse, response);
  	}else{
  		 response.setErrorCode(bankResp.getErrorCode());
         response.setErrorMessage(bankResp.getErrorMessage());
         throw new ChatakAdminException(bankResp.getErrorCode(),bankResp.getErrorMessage());
  	}
    }
    
   //Card Details from issuance and save in acquirer
    CardProgramRequest cardProgramRequest = new CardProgramRequest();
    List<Long> cardProgramList = new ArrayList<>();
    String[] cardProgramArrayLists = programManagerRequest.getCardProgramIds().split(",");
    for (int i = 0; i < cardProgramArrayLists.length; i++) {
      if (cardProgramArrayLists[i] != null) {
    	  cardProgramList.add(Long.parseLong(cardProgramArrayLists[i]));
      }
    }
    cardProgramRequest.setCardProgramIds(cardProgramList);
    CardProgramResponse cardProgramResponse = getCardProgramsDetailsByIds(cardProgramRequest);
    
    CardProgram issuanceCardProgramReq = null;
    CardProgram cardProgram = new CardProgram();
    for(CardProgramRequest cardProgramReq : cardProgramResponse.getCardProgramList()){
      issuanceCardProgramReq = new CardProgram();
  	  issuanceCardProgramReq.setIssuanceCradProgramId(cardProgramReq.getCardProgramId());
  	  issuanceCardProgramReq.setCardProgramName(cardProgramReq.getCardProgramName());
  	  issuanceCardProgramReq.setIin(cardProgramReq.getIin());
  	  issuanceCardProgramReq.setIinExt(cardProgramReq.getIinExt());
  	  issuanceCardProgramReq.setCurrency(programManagerRequest.getAccountCurrency());
  	  issuanceCardProgramReq.setStatus(cardProgramReq.getStatus());
  	  issuanceCardProgramReq.setPartnerId(cardProgramReq.getPartnerId());
  	  issuanceCardProgramReq.setPartnerName(cardProgramReq.getPartnerName());
  	  issuanceCardProgramReq.setCreatedDate(new Timestamp(System.currentTimeMillis()));
  	  issuanceCardProgramReq.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
  	  issuanceCardProgramReq.setCreatedBy(programManagerRequest.getCreatedBy());
  	  issuanceCardProgramReq.setPartnerIINCode(cardProgramReq.getPartnerCode());
  	  
  	  CardProgram existingCardProgram = cardProgramDao.findByIssuanceCardProgramId(cardProgramReq.getCardProgramId());
  	  if(existingCardProgram!=null){
  	  cardProgram.setCardProgramId(existingCardProgram.getCardProgramId());
  	  }else{
  	  cardProgram = cardProgramDao.createCardProgram(issuanceCardProgramReq);  	    
  	  }
  	  
		savePMCardProgramMappingData(cardProgram, pmResponse, response);
    }    
			} else {
				BankResponse bankResp = null;
				String[] arrayList = programManagerRequest.getAcquirerBankName().split(",");
				for (int i = 0; i < arrayList.length; i++) {
					bankResp = new BankResponse();
					if (arrayList[i] != null) {
						bankResp.setBankid(Long.parseLong(arrayList[i]));
						savePMBankMappingData(bankResp, pmResponse, response);
					}
				}

				CardProgram cardProgramReq = null;
				String[] cardProgramArrayLists = programManagerRequest.getAcquirerCardProgramIds().split(",");
				for (int i = 0; i < cardProgramArrayLists.length; i++) {
					cardProgramReq = new CardProgram();
					if (cardProgramArrayLists[i] != null) {
						cardProgramReq.setCardProgramId(Long.parseLong(cardProgramArrayLists[i]));
						savePMCardProgramMappingData(cardProgramReq, pmResponse, response);
					}
				}
			}
    
      if (StringUtil.isNull(programManagerRequest.getId())) {
        ProgramManagerAccount systemProgramManagerAccount = new ProgramManagerAccount();
        systemProgramManagerAccount.setProgramManagerId(pmResponse.getId());
        systemProgramManagerAccount.setCreatedBy(programManagerRequest.getCreatedBy());
        systemProgramManagerAccount.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        systemProgramManagerAccount
            .setAccountNumber(programManagerDao.getProgramManagerAccountNumber());
        systemProgramManagerAccount.setCurrentBalance(0l);
        systemProgramManagerAccount.setAvailableBalance(0l);
        systemProgramManagerAccount.setAccountType(Constants.ACCOUNT_NAME_SYSTEM);
        systemProgramManagerAccount.setStatus(Constants.ACTIVE);
        systemProgramManagerAccount.setUpdatedDate(currentTimeStamp);
        systemProgramManagerAccount.setAccountThresholdLimit(
            CommonUtil.getLongAmount(programManagerRequest.getAccountThresholdLimit()));
        systemProgramManagerAccount.setAutoReplenish(programManagerRequest.getAutoRepenish());
        systemProgramManagerAccount.setSendFundsMode(programManagerRequest.getSendFundsMode());
        programManagerDao.saveOrUpdateProgramManagerAccount(systemProgramManagerAccount);
        ProgramManagerAccount revenueProgramManagerAccount = new ProgramManagerAccount();
        revenueProgramManagerAccount.setProgramManagerId(pmResponse.getId());
        revenueProgramManagerAccount.setCreatedBy(programManagerRequest.getCreatedBy());
        revenueProgramManagerAccount.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        revenueProgramManagerAccount
            .setAccountNumber(programManagerDao.getRevenueProgramManagerAccountNumber());
        revenueProgramManagerAccount.setCurrentBalance(0l);
        revenueProgramManagerAccount.setAvailableBalance(0l);
        revenueProgramManagerAccount.setAccountType(Constants.REVENUE_ACCOUNT);
        revenueProgramManagerAccount.setStatus(Constants.ACTIVE);
        revenueProgramManagerAccount.setUpdatedDate(currentTimeStamp);
        revenueProgramManagerAccount.setAccountThresholdLimit(
            CommonUtil.getLongAmount(programManagerRequest.getAccountThresholdLimit()));
        revenueProgramManagerAccount.setAutoReplenish(programManagerRequest.getAutoRepenish());
        revenueProgramManagerAccount.setSendFundsMode(programManagerRequest.getSendFundsMode());
        programManagerDao.saveOrUpdateProgramManagerAccount(revenueProgramManagerAccount);
         
      }
      logger.info("info:: ProgramManagerServiceImpl :: createOrUpdateProgramManager method");
      response.setErrorCode(StatusConstants.STATUS_CODE_SUCCESS);
      response.setErrorMessage(StatusConstants.STATUS_MESSAGE_SUCCESS);
		} catch (ChatakAdminException e) {
			logger.error("ERROR:: ProgramManagerController:: processCreateProgramManager method2", e);
			response.setErrorCode(e.getErrorCode());
			response.setErrorMessage(e.getErrorMessage());
			throw new ChatakAdminException(e.getErrorCode(),e.getErrorMessage());
		} catch (Exception e) {
			logger.error("ERROR:: ProgramManagerServiceImpl :: createProgramManager method: ", e);
			throw new ChatakAdminException(Constants.PROGRAM_MANAGER_CREATION_ERROR);
		}
    return response;
  }

  @Transactional
  private void savePMBankMappingData(BankResponse bankResponse, ProgramManager pmResponse, Response response) throws ReflectiveOperationException , ChatakAdminException{
      try{
          BankProgramManagerMap bankProgramManagerMap = new BankProgramManagerMap();
          bankProgramManagerMap.setBankId(bankResponse.getBankid());
          bankProgramManagerMap.setProgramManagerId(pmResponse.getId());
          bankDao.createOrUpdateBankProgramManagerMapping(bankProgramManagerMap);
        } catch (Exception e) {
            response.setErrorCode(Constants.PROGRAM_MANAGER_CREATION_ERROR);
            response.setErrorMessage(Constants.BANK_PM_MAPPING_ERROR);
            throw new ChatakAdminException(response.getErrorCode(), response.getErrorMessage());
        }
  }
  
  @Transactional
  private void savePMCardProgramMappingData(CardProgram cardProgram, ProgramManager pmResponse, Response response) throws ReflectiveOperationException , ChatakAdminException{
      try{
            PmCardProgamMapping cardProgamMapping = new PmCardProgamMapping();
            cardProgamMapping.setCardProgramId(cardProgram.getCardProgramId());
            cardProgamMapping.setProgramManagerId(pmResponse.getId());
            cardProgramDao.createCardProgramMapping(cardProgamMapping);
        } catch (Exception e) {
            response.setErrorCode(Constants.PROGRAM_MANAGER_CREATION_ERROR);
            response.setErrorMessage(Constants.CARD_PROGRAM_ERROR);
            throw new ChatakAdminException(response.getErrorCode(), response.getErrorMessage());
        }
    }
  
  private Timestamp getCurrentTimeStamp(ProgramManagerRequest programManagerRequest) {
    programManagerRequest.setIsAuditable(Boolean.TRUE);
    programManagerRequest.setDataChange("Yes");
    return DateUtil.getCurrentTimestamp();
  }

  @Override
  public ProgramManagerResponse searchProgramManagerDetails(
      ProgramManagerRequest programManagerRequest) throws ChatakAdminException {

    programManagerRequest.setIsAuditable(Boolean.TRUE);
    programManagerRequest.setDataChange("No");
    try {
      List<ProgramManagerRequest> programManagerRequests =
          programManagerDao.searchProgramManagers(programManagerRequest);
      ProgramManagerResponse response = new ProgramManagerResponse();
      processSearchResult(programManagerRequest, programManagerRequests, response);
      logger.info("Exiting:: ProgramManagerServiceImpl :: searchProgramManager method: ");
      return response;
    } catch (Exception e) {
      logger.error("ERROR:: ProgramManagerServiceImpl :: searchProgramManager method.", e);
      throw new ChatakAdminException(messageSource.getMessage(Constants.CHATAK_GENERAL_ERROR, null,
          LocaleContextHolder.getLocale()), e);
    }
  }

  private void processSearchResult(ProgramManagerRequest programManagerRequest,
      List<ProgramManagerRequest> programManagerRequests, ProgramManagerResponse response) {
    if (StringUtil.isListNotNullNEmpty(programManagerRequests)) {
      response.setProgramManagersList(programManagerRequests);
      response.setTotalNoOfRows(programManagerRequest.getNoOfRecords());
    }
    response.setErrorCode(StatusConstants.STATUS_CODE_SUCCESS);
    response.setErrorMessage(StatusConstants.STATUS_MESSAGE_SUCCESS);
  }

  @Override
  public ProgramManagerResponse searchProgramManagerAccountDetails(
      ProgramManagerRequest programManagerRequest) throws ChatakAdminException {

    programManagerRequest.setIsAuditable(Boolean.TRUE);
    programManagerRequest.setDataChange("No");
    try {
      List<ProgramManagerRequest> programManagerRequests =
          programManagerDao.searchProgramManagersAccounts(programManagerRequest);
      ProgramManagerResponse response = new ProgramManagerResponse();
      processSearchResult(programManagerRequest, programManagerRequests, response);
      logger.info("Exiting:: ProgramManagerServiceImpl :: searchProgramManager method: ");
      return response;
    } catch (Exception e) {
      logger.error("ERROR:: ProgramManagerServiceImpl :: searchProgramManager method.", e);
      throw new ChatakAdminException(messageSource.getMessage(Constants.CHATAK_GENERAL_ERROR, null,
          LocaleContextHolder.getLocale()), e);
    }
  }


  @Override
  public ProgramManagerResponse searchSystemProgramManager(
      ProgramManagerRequest programManagerRequest) throws ChatakAdminException {
    logger.info("Entering:: ProgramManagerServiceImpl :: searchSystemProgramManager method: ");
    try {
      ProgramManagerResponse response = new ProgramManagerResponse();
      ProgramManager programManagerRequests =
          programManagerDao.searchSystemProgramManager(programManagerRequest);
      if (!StringUtil.isNull(programManagerRequests)) {
        List<ProgramManagerRequest> programManagerRequestList =
            new ArrayList<ProgramManagerRequest>();
        programManagerRequestList.add((ProgramManagerRequest) CommonUtil
            .copyBeanProperties(programManagerRequests, ProgramManagerRequest.class));
        response.setProgramManagersList(programManagerRequestList);
        response.setTotalNoOfRows(programManagerRequest.getNoOfRecords());
      }
      response.setErrorCode(StatusConstants.STATUS_CODE_SUCCESS);
      response.setErrorMessage(StatusConstants.STATUS_MESSAGE_SUCCESS);
      logger.info("Exiting:: ProgramManagerServiceImpl :: searchSystemProgramManager method: ");
      return response;
    } catch (Exception e) {
      logger.error("ERROR:: ProgramManagerServiceImpl :: searchSystemProgramManager method.", e);
      throw new ChatakAdminException(messageSource.getMessage(Constants.CHATAK_GENERAL_ERROR, null,
          LocaleContextHolder.getLocale()), e);
    }
  }

  @Override
  public ProgramManagerResponse editProgramManager(ProgramManagerRequest programManagerRequest)
      throws ChatakAdminException {
    programManagerRequest.setIsAuditable(Boolean.TRUE);
    programManagerRequest.setDataChange("No");
    logger.info("Entering:: ProgramManagerServiceImpl :: findProgramManagerById method: ");
    ProgramManagerResponse response = new ProgramManagerResponse();
    try {
      ProgramManagerRequest programManagerRequest2 =
          programManagerDao.findProgramManagerById(programManagerRequest);

      if (!StringUtil.isNull(programManagerRequest2)) {
        response.setProgramManagersList(Arrays.asList(programManagerRequest2));
      }
      response.setErrorCode(StatusConstants.STATUS_CODE_SUCCESS);
      response.setErrorMessage(StatusConstants.STATUS_MESSAGE_SUCCESS);

      logger.info("Exiting:: ProgramManagerServiceImpl :: findProgramManagerById method: ");
      return response;
    } catch (Exception e) {
      logger.error("ERROR:: ProgramManagerServiceImpl :: findProgramManagerById method: ", e);
      return (ProgramManagerResponse) CommonUtil.getResponse(response,
          Constants.PROGRAM_MANAGER_SEARCH_ERROR,
          Properties.getProperty(Constants.PROGRAM_MANAGER_SEARCH_ERROR));
    }
  }

  @Override
  public ProgramManagerAccountResponse findProgramManagerAccountByAccountId(
      ProgramManagerRequest programManagerRequest) throws ChatakAdminException {
    programManagerRequest.setIsAuditable(Boolean.TRUE);
    programManagerRequest.setDataChange("No");
    logger.info("Entering:: ProgramManagerServiceImpl :: findProgramManagerAccountById method: ");
    ProgramManagerAccountResponse response = new ProgramManagerAccountResponse();
    try {
      ProgramManagerAccountRequest programManagerAccountRequest =
          getAccountDetails(programManagerRequest);

      setResponseDetails(response, programManagerAccountRequest);

      logger.info("Exiting:: ProgramManagerServiceImpl :: findProgramManagerAccountById method: ");
      return response;
    } catch (Exception e1) {
      logger.error("ERROR:: ProgramManagerServiceImpl :: findProgramManagerAccountById method: ",
          e1);
    }
    return response;
  }

  private void setResponseDetails(ProgramManagerAccountResponse response,
      ProgramManagerAccountRequest programManagerAccountRequest) {
    response.setProgramManagerAccountRequestList(Arrays.asList(programManagerAccountRequest));
    response.setErrorCode(StatusConstants.STATUS_CODE_SUCCESS);
    response.setErrorMessage(StatusConstants.STATUS_MESSAGE_SUCCESS);
  }

  @Override
  public Response editProgramManagerAccount(ProgramManagerRequest programManagerRequest)
      throws ChatakAdminException {
    programManagerRequest.setIsAuditable(Boolean.TRUE);
    programManagerRequest.setDataChange("No");
    logger.info("Entering:: ProgramManagerServiceImpl :: findProgramManagerAccountById method: ");
    ProgramManagerAccountResponse response = new ProgramManagerAccountResponse();
    try {
      ProgramManagerAccountRequest programManagerAccountRequest =
          getAccountDetails(programManagerRequest);

      setResponseDetails(response, programManagerAccountRequest);

      logger.info("Exiting:: ProgramManagerServiceImpl :: findProgramManagerAccountById method: ");
      return response;
    } catch (Exception e) {
      logger.error("ERROR:: ProgramManagerServiceImpl :: findProgramManagerAccountById method: ",
          e);
    }
    return response;
  }

  private ProgramManagerAccountRequest getAccountDetails(
      ProgramManagerRequest programManagerRequest) throws ReflectiveOperationException {
    ProgramManagerAccountRequest programManagerAccountRequest = new ProgramManagerAccountRequest();
    ProgramManagerAccount programManagerAccount = null;
    if (!StringUtil.isNull(programManagerRequest.getProgramManagerAccountId())) {
      programManagerAccount = programManagerDao.getProgramManagerAccountByIdAndAccountType(
          programManagerRequest.getProgramManagerAccountId(),
          programManagerRequest.getAccountType());
      programManagerAccountRequest =
          CommonUtil.copyBeanProperties(programManagerAccount, ProgramManagerAccountRequest.class);
      programManagerAccountRequest.setProgramManagerId(programManagerAccount.getProgramManagerId());
      programManagerDao.findBankDetailsByPMId(programManagerAccountRequest);
    } else {
      programManagerAccount = programManagerDao.findByProgramManagerIdAndAccountType(
          programManagerRequest.getId(), programManagerRequest.getAccountType());
    }
    programManagerAccountRequest.setAvailableBalance(
        CommonUtil.getDoubleAmount(programManagerAccount.getAvailableBalance()));
    programManagerAccountRequest
        .setCurrentBalance(CommonUtil.getDoubleAmount(programManagerAccount.getCurrentBalance()));
    programManagerAccountRequest.setAccountThresholdAmount(
        CommonUtil.getDoubleAmount(programManagerAccount.getAccountThresholdLimit()));
    programManagerAccountRequest.setAccountType(programManagerAccount.getAccountType());
    return programManagerAccountRequest;
  }

  @Override
  @Transactional
  public Response updateProgramManager(ProgramManagerRequest programManagerRequest)
      throws ChatakAdminException {
    logger.info("Entering:: ProgramManagerServiceImpl :: updateProgramManager method: ");
    Response response = new Response();
    Timestamp currentTimeStamp = getCurrentTimeStamp(programManagerRequest);

    // Check whether the program manager name already exists
    ProgramManagerRequest existingProgramManager =
            programManagerDao.findProgramManagerById(programManagerRequest.getId());
    if(isPmNameAlreadyExist(programManagerRequest,existingProgramManager)){
        response.setErrorCode(Constants.PROGRAM_MANAGER_ALREADY_EXISTS_WITH_NAME);
        response.setErrorMessage("Another Program manager with name "
            + programManagerRequest.getProgramManagerName() + " already exist");
        return response;
    }

    try {
      CountryRequest countryRequest = countryDao.findCountryByID(Long.valueOf(programManagerRequest.getCountry()));
      programManagerRequest.setCountry(countryRequest.getName());
      setUpdatedValues(programManagerRequest, existingProgramManager);
      ProgramManager programManager =
          CommonUtil.copyBeanProperties(existingProgramManager, ProgramManager.class);

      // Delete all the child records if already mapped
      deleteCardProgramAndBankMap(programManager);
      
      setBankAndCpDetails(programManagerRequest, programManager);

      programManager.setUpdatedBy(programManagerRequest.getUpdatedBy());
      programManager.setUpdatedDate(currentTimeStamp);


      logger.info(
          "info:: ProgramManagerServiceImpl ::before updateProgramManager ::createOrUpdateProgramManager method: ");
      programManagerDao.saveOrUpdateProgramManager(programManager);

      logger.info("Exiting:: ProgramManagerServiceImpl :: updateProgramManager method: ");
      return CommonUtil.getSuccessResponse();
    } catch (Exception e) {
      logger.error("ERROR:: ProgramManagerServiceImpl :: updateProgramManager method: ", e);
      return CommonUtil.getResponse(response, Constants.PROGRAM_MANAGER_CREATION_ERROR,
          Constants.PROGRAM_MANAGER_CREATION_ERROR);
    }
  }

  private void deleteCardProgramAndBankMap(ProgramManager programManager) {
        programManagerDao.deleteBankProgramManagerMap(programManager.getId());
        programManagerDao.deleteCpProgramManagerMap(programManager.getId());
  }

  private void setBankAndCpDetails(ProgramManagerRequest programManagerRequest, ProgramManager programManager)
          throws ReflectiveOperationException {
        Set<BankProgramManagerMap> bankProgramManagerMaps = new HashSet<>();
        BankProgramManagerMap bankProgramManagerMap;
        String bankIdList[] = programManagerRequest.getBankNames().split(",");
        for(String bankId : bankIdList){
            bankProgramManagerMap = new BankProgramManagerMap();
            bankProgramManagerMap.setBankId(Long.valueOf(bankId));  
            bankProgramManagerMaps.add(bankProgramManagerMap);
        }
        programManager.setBankProgramManagerMaps(bankProgramManagerMaps);
        
        Set<PmCardProgamMapping> cardProgamMapping = new HashSet<>();
        PmCardProgamMapping cardProgamMap;
        String carProgramIdList[] =  programManagerRequest.getCardProgramIds().split(",");
        for(String carProgramId : carProgramIdList){
            cardProgamMap = new PmCardProgamMapping();
            cardProgamMap.setCardProgramId(Long.valueOf(carProgramId));
            cardProgamMapping.add(cardProgamMap);
        }
        programManager.setCardProgamMapping(cardProgamMapping);
  }

  private Boolean isPmNameAlreadyExist(ProgramManagerRequest programManagerRequest,
      List<ProgramManager> listOfProgramManager) {
    Boolean programManagerNameExists = Boolean.FALSE;
    for (ProgramManager programManager : listOfProgramManager) {
      if (programManager.getId().compareTo(programManagerRequest.getId()) != 0) {
        programManagerNameExists = Boolean.TRUE;
        break;
      }
    }
    return programManagerNameExists;
  }
  
  private Boolean isPmNameAlreadyExist(ProgramManagerRequest programManagerRequest,ProgramManagerRequest programManager) {
        Boolean programManagerNameExists = Boolean.FALSE;
          if(!programManager.getProgramManagerName().equals(programManagerRequest.getProgramManagerName().trim())){
            List<ProgramManager> pmList= programManagerDao.findByProgramManagerName(programManagerRequest.getProgramManagerName());
            if(StringUtil.isListNotNullNEmpty(pmList)){
                programManagerNameExists = Boolean.TRUE;
            }
          }
        return programManagerNameExists;
      }

  @Override
  public Response updateProgramManagerAccount(
      ProgramManagerAccountRequest programManagerAccountRequest) throws ChatakAdminException {
    logger.info("Entering:: ProgramManagerServiceImpl :: updateProgramManagerAccount method: ");
    Response response = new Response();
    try {
      ProgramManagerAccount programManagerAccount =
          programManagerDao.getProgramManagerAccountByIdAndAccountType(
              programManagerAccountRequest.getId(), programManagerAccountRequest.getAccountType());
      programManagerAccount.setNickName(programManagerAccountRequest.getNickName());
      programManagerAccount.setAccountType(programManagerAccountRequest.getAccountType());
      programManagerAccount.setAccountThresholdLimit(
          CommonUtil.getLongAmount(programManagerAccountRequest.getAccountThresholdAmount()));
      programManagerAccount.setSendFundsMode(programManagerAccountRequest.getSendFundsMode());
      programManagerAccount.setAutoReplenish(programManagerAccountRequest.getAutoRepenish());
      programManagerDao.saveOrUpdateProgramManagerAccount(programManagerAccount);

      logger.info("Exiting:: ProgramManagerServiceImpl :: updateProgramManagerAccount method: ");
      return CommonUtil.getSuccessResponse();
    } catch (Exception e) {
      logger.error("ERROR:: ProgramManagerServiceImpl :: updateProgramManagerAccount method: ", e);
      return CommonUtil.getResponse(response, Constants.PROGRAM_MANAGER_CREATION_ERROR,
          Constants.PROGRAM_MANAGER_CREATION_ERROR);
    }

  }

  @Override
  public Response updateProgramManagerStatus(ProgramManagerRequest programManagerRequest)
      throws ChatakAdminException {
    logger.info("Entering:: ProgramManagerServiceImpl :: changeProgramManagerStatus method: ");
    try {
      ProgramManagerRequest pmRequest =
          programManagerDao.findProgramManagerById(programManagerRequest.getId());
      Set<BankProgramManagerMap> map = programManagerDao
          .findBankProgramManagerMapByProgramManagerId(programManagerRequest.getId());
      List<ProgramManagerAccount> pmAccounts = programManagerDao
          .getProgramManagerAccountByProgramManagerId(programManagerRequest.getId());
      ProgramManagerResponse response = new ProgramManagerResponse();
      ProgramManager programManager =
          CommonUtil.copyBeanProperties(pmRequest, ProgramManager.class);
      programManager.setUpdatedBy(programManagerRequest.getUpdatedBy());
      programManager.setStatus(programManagerRequest.getStatus());
      programManager.setReason(programManagerRequest.getReason());
      programManager.setUpdatedDate(DateUtil.getCurrentTimestamp());
      programManager.setBankProgramManagerMaps(map);
      programManagerDao.saveOrUpdateProgramManager(programManager);

      for (ProgramManagerAccount programManagerAccount : pmAccounts) {
        programManagerAccount.setUpdatedBy(programManagerRequest.getUpdatedBy());
        programManagerAccount.setStatus(programManagerRequest.getStatus());
        programManagerAccount.setUpdatedDate(DateUtil.getCurrentTimestamp());
        programManagerDao.saveOrUpdateProgramManagerAccount(programManagerAccount);
      }

      response.setErrorCode(StatusConstants.STATUS_CODE_SUCCESS);
      response.setErrorMessage(StatusConstants.STATUS_MESSAGE_SUCCESS);
      logger.info("Exiting:: ProgramManagerServiceImpl :: changeProgramManagerStatus method: ");
      return response;
    } catch (Exception e) {
      logger.error("ERROR:: ProgramManagerServiceImpl :: changeProgramManagerStatus method.", e);
      throw new ChatakAdminException(messageSource.getMessage(Constants.CHATAK_GENERAL_ERROR, null,
          LocaleContextHolder.getLocale()), e);
    }
  }

  public ProgramManagerResponse getProgramManagersByBankId(
      ProgramManagerRequest programManagerRequest) throws ChatakAdminException {
    logger.info("Entering:: ProgramManagerServiceImpl :: getProgramManagersByBankId method: ");
    try {
      ProgramManagerResponse response = new ProgramManagerResponse();
      List<ProgramManagerRequest> programManagersList = new ArrayList<ProgramManagerRequest>();
      Set<BankProgramManagerMap> managerMaps = programManagerDao.findByBankId(
          programManagerRequest.getBankProgramManagerMaps().get(0).getBankId());
      if (CommonUtil.isSetNotNullNEmpty(managerMaps)) {
        for (BankProgramManagerMap managerMap : managerMaps) {
          ProgramManagerRequest managerRequest = new ProgramManagerRequest();
          managerRequest.setId(managerMap.getProgramManagerId());
          programManagersList.add(programManagerDao.findProgramManagerById(managerRequest));
        }
      }
      response.setProgramManagersList(programManagersList);
      response.setErrorCode(StatusConstants.STATUS_CODE_SUCCESS);
      response.setErrorMessage(StatusConstants.STATUS_MESSAGE_SUCCESS);
      logger.info("Exiting:: ProgramManagerServiceImpl :: getProgramManagersByBankId method: ");
      return response;
    } catch (Exception e) {
      logger.error("ERROR:: ProgramManagerServiceImpl :: getProgramManagersByBankId method.", e);
      throw new ChatakAdminException(messageSource.getMessage(Constants.CHATAK_GENERAL_ERROR, null,
          LocaleContextHolder.getLocale()), e);
    }
  }

  public ProgramManagerResponse getAllProgramManagers(ProgramManagerRequest programManagerRequest)
      throws ChatakAdminException {
    logger.info("Entering:: ProgramManagerServiceImpl :: getAllProgramManagers method: ");
    try {
      List<ProgramManagerRequest> programManagerRequests =
          programManagerDao.getAllProgramManagers(programManagerRequest);
      ProgramManagerResponse response = new ProgramManagerResponse();
      if (StringUtil.isListNotNullNEmpty(programManagerRequests)) {
        response.setProgramManagersList(programManagerRequests);
      }
      response.setErrorCode(StatusConstants.STATUS_CODE_SUCCESS);
      response.setErrorMessage(StatusConstants.STATUS_MESSAGE_SUCCESS);
      logger.info("Exiting:: ProgramManagerServiceImpl :: getAllProgramManagers method: ");
      return response;
    } catch (Exception e) {
      logger.error("ERROR:: ProgramManagerServiceImpl :: getAllProgramManagers method.", e);
      throw new ChatakAdminException(messageSource.getMessage(Constants.CHATAK_GENERAL_ERROR, null,
          LocaleContextHolder.getLocale()), e);
    }
  }


  public BankResponse findBankByProgramManagerId(ProgramManagerRequest programManagerRequest)
      throws ChatakAdminException {
    logger
        .info("Entering:: ProgramManagerServiceImpl :: getAllBankNamesForProgramManager method: ");
    try {
      BankResponse response = new BankResponse();
      List<BankRequest> bankRequests =
          programManagerDao.getAllBanksForProgramManager(programManagerRequest);
      if (StringUtil.isListNotNullNEmpty(bankRequests)) {
        response.setBankRequests(bankRequests);
        response.setTotalNoOfRows(programManagerRequest.getNoOfRecords());
      }
      response.setErrorCode(StatusConstants.STATUS_CODE_SUCCESS);
      response.setErrorMessage(StatusConstants.STATUS_MESSAGE_SUCCESS);
      logger.info("Exiting:: ProgramManagerServiceImpl :: getAllBanksForProgramManager method: ");
      return response;
    } catch (Exception e) {
      logger.error("ERROR:: ProgramManagerServiceImpl :: getAllBankNamesForProgramManager method.",
          e);
      throw new ChatakAdminException(messageSource.getMessage(Constants.CHATAK_GENERAL_ERROR, null,
          LocaleContextHolder.getLocale()), e);
    }
  }

  private static void setUpdatedValues(ProgramManagerRequest updatedRequest,
      ProgramManagerRequest existingProgramManagerRequest) {
    existingProgramManagerRequest.setProgramManagerName(updatedRequest.getProgramManagerName());
    existingProgramManagerRequest.setCompanyName(updatedRequest.getCompanyName());
    existingProgramManagerRequest.setBusinessName(updatedRequest.getBusinessName());
    existingProgramManagerRequest.setContactName(updatedRequest.getContactName());
    existingProgramManagerRequest.setContactPhone(updatedRequest.getContactPhone());
    existingProgramManagerRequest.setExtension(updatedRequest.getExtension());
    existingProgramManagerRequest.setContactEmail(updatedRequest.getContactEmail());
    existingProgramManagerRequest.setCountry(updatedRequest.getCountry());
    existingProgramManagerRequest.setState(updatedRequest.getState());
    existingProgramManagerRequest.setPmTimeZone(updatedRequest.getPmTimeZone());
    existingProgramManagerRequest.setBatchPrefix(updatedRequest.getBatchPrefix());
    existingProgramManagerRequest.setPmSystemConvertedTime(updatedRequest.getPmSystemConvertedTime());
    existingProgramManagerRequest.setSchedulerRunTime(updatedRequest.getSchedulerRunTime());
    existingProgramManagerRequest.setProgramManagerLogo(updatedRequest.getProgramManagerLogo());
    existingProgramManagerRequest
        .setDefaultProgramManager(updatedRequest.getDefaultProgramManager());
  }

  @Override
  public List<Option> getActiveProgramManagers() {
    List<ProgramManager> programManagers = programManagerDao.findAllProgramManagerDetails();
    List<Option> options = new ArrayList<>();
    if (null != programManagers) {
      for (ProgramManager programManager : programManagers) {
        Option option = new Option();
        option.setLabel(programManager.getId().toString());
        option.setValue(programManager.getProgramManagerName());
        options.add(option);
      }
    }
    Collections.sort(options, StringUtil.ALPHABETICAL_ORDER);
    return options;
  }
  
    public ProgramManagerResponse getAllIssuanceProgramManagers(ProgramManagerRequest programManagerRequest)
            throws ChatakAdminException {
        logger.info("Entering:: ProgramManagerServiceImpl :: getAllProgramManagers method: ");
        try {
            String output = JsonUtil.postIssuanceRequest(programManagerRequest,
                    "/setupServices/setupService/getAllProgramManagers",String.class);
            logger.info("Exiting:: ProgramManagerServiceImpl :: getAllIssuanceProgramManagers method: ");
            ProgramManagerResponse programManagerResponse=mapper.readValue(output, ProgramManagerResponse.class);
            return programManagerResponse;
        }catch (HttpClientException e) {
            logger.info("Entering:: ProgramManagerServiceImpl :: validateResponseToGetProgramManagers method: ");
            throw new ChatakAdminException(Properties.getProperty("prepaid.service.call.role.error.message"));
        } catch (Exception e1) {
            logger.error("ERROR:: ProgramManagerServiceImpl :: getAllIssuanceProgramManagers method.", e1);
        }
        return null;

    }

    public ProgramManagerResponse getIssuanceProgramManagerById(ProgramManagerRequest programManagerRequest)
            throws ChatakAdminException {
        logger.info("Entering:: ProgramManagerServiceImpl :: getIssuanceProgramManagerById method: ");
        try {
            String output=JsonUtil.postIssuanceRequest(programManagerRequest,
                    "/setupServices/setupService/getProgramManagerDetailsByProgramManagerId",String.class);
            logger.info("Exiting:: ProgramManagerServiceImpl :: getAllBanksForProgramManager method: ");
            ProgramManagerResponse programManagerResponse=mapper.readValue(output, ProgramManagerResponse.class);
            return programManagerResponse;
        }catch (HttpClientException e) {
            logger.info("Entering:: ProgramManagerServiceImpl :: validateResponseToGetProgramManagers method: ");
            throw new ChatakAdminException(Properties.getProperty("prepaid.service.call.role.error.message"));
        } catch (Exception e1) {
            logger.error("ERROR:: ProgramManagerServiceImpl :: getIssuanceProgramManagerById method.", e1);
        }
        return null;
    }

    public CardProgramResponse searchCardProgramByProgramManager(
            PartnerGroupPartnerMapRequest partnerGroupPartnerMapRequest) throws ChatakAdminException {
        logger.info("Entering:: ProgramManagerServiceImpl :: searchCardProgramByProgramManager method: ");
        try {
            String output = JsonUtil.postIssuanceRequest(partnerGroupPartnerMapRequest,
                    "/setupServices/setupService/searchCardProgramByProgramManager",String.class);
            logger.info("Exiting:: ProgramManagerServiceImpl :: searchCardProgramByProgramManager method: ");
            CardProgramResponse cardProgramResponse=mapper.readValue(output, CardProgramResponse.class);
            return cardProgramResponse;
        } catch (HttpClientException e) {
            logger.info("Entering:: ProgramManagerServiceImpl :: validateResponseToGetProgramManagers method: ");
            throw new ChatakAdminException(Properties.getProperty("prepaid.service.call.role.error.message"));
        } catch (Exception e1) {
            logger.error("ERROR:: ProgramManagerServiceImpl :: searchCardProgramByProgramManager method.", e1);
        }
        return null;
    }

    @Override
    public Response findProgramManagerNameByAccountCurrency(String currencyId) throws ChatakAdminException {
        List<ProgramManager> pmList = programManagerDao.getProgramManagerNameByAccountCurrency(currencyId);
        Response response = new Response();
        if (pmList != null) {
          List<Option> options = new ArrayList<Option>(pmList.size());
          Option option = null;
          for (ProgramManager pgProgramManagerList : pmList) {
            option = new Option();
            option.setValue(pgProgramManagerList.getId().toString());
            option.setLabel(pgProgramManagerList.getProgramManagerName());
            options.add(option);
          }

          response.setResponseList(options);
          response.setErrorCode("00");
          response.setTotalNoOfRows(options.size());

        } else {
          response.setErrorCode("99");
          response.setErrorMessage("failure");
        }
        return response;
    }
    
    public BankResponse getBankDetailsByBankIds(
            BankRequest bankRequest) throws ChatakAdminException {
        logger.info("Entering:: ProgramManagerServiceImpl :: searchCardProgramByProgramManager method: ");
        try {
            String output = JsonUtil.postIssuanceRequest(bankRequest,
                    "/bankManagementService/bank/getBankDetailsByBankIds",String.class);
            logger.info("Exiting:: ProgramManagerServiceImpl :: searchCardProgramByProgramManager method: ");
            BankResponse bankResponse=mapper.readValue(output, BankResponse.class);
            return bankResponse;
        }catch (HttpClientException e) {
            logger.info("Entering:: ProgramManagerServiceImpl :: validateResponseToGetProgramManagers method: ");
            throw new ChatakAdminException(Properties.getProperty("prepaid.service.call.role.error.message"));
        } catch (Exception e1) {
            logger.error("ERROR:: ProgramManagerServiceImpl :: searchCardProgramByProgramManager method.", e1);
        }
        return null;
    }
    
    public CardProgramResponse getCardProgramsDetailsByIds(
            CardProgramRequest cardProgramRequest) throws ChatakAdminException {
        logger.info("Entering:: ProgramManagerServiceImpl :: getCardProgramsDetailsByIds method: ");
        try {
            String output = JsonUtil.postIssuanceRequest(cardProgramRequest,
                    "/bankManagementService/bank/getCardProgramsDetailsByIds",String.class);
            logger.info("Exiting:: ProgramManagerServiceImpl :: getCardProgramsDetailsByIds method: ");
            CardProgramResponse cardProgramResponse=mapper.readValue(output, CardProgramResponse.class);
            return cardProgramResponse;
        }catch (HttpClientException e) {
            logger.info("Entering:: ProgramManagerServiceImpl :: validateResponseToGetProgramManagers method: ");
            throw new ChatakAdminException(Properties.getProperty("prepaid.service.call.role.error.message"));
        }  catch (Exception e1) {
            logger.error("ERROR:: ProgramManagerServiceImpl :: getCardProgramsDetailsByIds method.", e1);
        }
        return null;
    }
    
    @Override
    public List<CardProgramRequest> findCardProgramByPmId(Long programManagerId) throws ChatakAdminException {
        Response response = new Response();
        try {
            List<CardProgramRequest> cardProgramRequestList = cardProgramDao.findCardProgramByPmId(programManagerId);
            response.setErrorCode(StatusConstants.STATUS_CODE_SUCCESS);
            response.setErrorMessage(StatusConstants.STATUS_MESSAGE_SUCCESS);
            logger.info("Exiting:: ProgramManagerServiceImpl :: findCardProgramByPmId method: ");
            return cardProgramRequestList;
        } catch (Exception e) {
            logger.error("ERROR:: ProgramManagerServiceImpl :: findCardProgramByPmId method.", e);
            throw new ChatakAdminException(
                    messageSource.getMessage(Constants.CHATAK_GENERAL_ERROR, null, LocaleContextHolder.getLocale()), e);
        }
    }
    
    private void setPGCurrencyConfigDetails(CurrencyDTO currencyDTO, PGCurrencyConfig pgCurrencyConfig) {
        pgCurrencyConfig.setCurrencyName(currencyDTO.getCurrencyName().toUpperCase());
        pgCurrencyConfig.setCurrencyCodeNumeric(currencyDTO.getCurrencyCodeNumeric());
        pgCurrencyConfig.setCurrencyCodeAlpha(currencyDTO.getCurrencyCodeAlpha().toUpperCase());
        pgCurrencyConfig.setCurrencyExponent(currencyDTO.getCurrencyExponent());
        pgCurrencyConfig.setCurrencySeparatorPosition(currencyDTO.getCurrencySeparatorPosition());
        pgCurrencyConfig.setCurrencyMinorUnit(currencyDTO.getCurrencyMinorUnit());
        pgCurrencyConfig.setCurrencyThousandsUnit(currencyDTO.getCurrencyThousandsUnit());
        pgCurrencyConfig.setStatus(PGConstants.STATUS_SUCCESS);
        pgCurrencyConfig.setCreatedDate(DateUtil.getCurrentTimestamp());
        pgCurrencyConfig.setCreatedBy(currencyDTO.getCreatedBy());
        pgCurrencyConfig.setModifiedDate(DateUtil.getCurrentTimestamp());
    }
    @Override
    public Response findProgramManagerNameByCurrencyAndId(Long id, String currencyId) {
        MerchantResponse merchantResponse = programManagerDao.getProgramManagerNameByCurrencyAndId(id,currencyId);
        Response response = new Response();
        if (merchantResponse != null && !StringUtil.isNull(merchantResponse.getProgramManagerRequests())) {
            List<Option> options = new ArrayList<>(merchantResponse.getProgramManagerRequests().size());
            Option option = null;
            for (ProgramManagerRequest manager : merchantResponse.getProgramManagerRequests()) {
                option = new Option();
                option.setValue(manager.getId().toString());
                option.setLabel(manager.getProgramManagerName());
                options.add(option);
            }
            response.setResponseList(options);
            response.setErrorCode(PGConstants.SUCCESS);
            response.setTotalNoOfRows(options.size());

        } else {
            response.setErrorCode(ActionCode.ERROR_CODE_99);
            response.setErrorMessage(StatusConstants.STATUS_MESSAGE_FAILED);
        }
        LogHelper.logExit(logger, LoggerMessage.getCallerName());
        return response;
    }
  @Override
  public Response findByProgramManagerIdAndAccountCurrency(Long pmId, String currencyId)
      throws ChatakAdminException {
    List<ProgramManager> pmList = programManagerDao.findByProgramManagerIdAndAccountCurrency(pmId, currencyId);
    Response response = new Response();
    if (pmList != null) {
      List<Option> options = new ArrayList<>(pmList.size());
      Option option = null;
      for (ProgramManager pgProgramManagerList : pmList) {
        option = new Option();
        option.setValue(pgProgramManagerList.getId().toString());
        option.setLabel(pgProgramManagerList.getProgramManagerName());
        options.add(option);
      }

      response.setResponseList(options);
      response.setErrorCode("00");
      response.setTotalNoOfRows(options.size());

    } else {
      response.setErrorCode("99");
      response.setErrorMessage("failure");
    }
    return response;
  }

	@Override
	public CardProgramResponse findPMCardprogramByMerchantId(Long merchantId) {
		LogHelper.logEntry(logger, LoggerMessage.getCallerName());
		CardProgramResponse response = new CardProgramResponse();
		try {
			response = programManagerDao.fetchPMCardProgramByMerchantId(merchantId);
			response.setErrorCode(PGConstants.SUCCESS);
			response.setErrorMessage(StatusConstants.STATUS_MESSAGE_SUCCESS);
		} catch (Exception e) {
			LogHelper.logError(logger, LoggerMessage.getCallerName(), e, Constants.EXCEPTION);
			response.setErrorCode(StatusConstants.STATUS_CODE_FAILED);
			response.setErrorMessage(StatusConstants.STATUS_MESSAGE_FAILED);
		}
		LogHelper.logExit(logger, LoggerMessage.getCallerName());
		return response;
	}
}
