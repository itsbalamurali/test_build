/**
 * 
 */
package com.chatak.acquirer.admin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.chatak.acquirer.admin.constants.FeatureConstants;
import com.chatak.acquirer.admin.constants.URLMappingConstants;
import com.chatak.acquirer.admin.controller.model.Option;
import com.chatak.acquirer.admin.exception.ChatakAdminException;
import com.chatak.acquirer.admin.model.TransactionResponse;
import com.chatak.acquirer.admin.service.BankService;
import com.chatak.acquirer.admin.service.CurrencyConfigService;
import com.chatak.acquirer.admin.service.IsoService;
import com.chatak.acquirer.admin.service.MerchantUpdateService;
import com.chatak.acquirer.admin.service.MerchantValidateService;
import com.chatak.acquirer.admin.service.PartnerService;
import com.chatak.acquirer.admin.service.ProgramManagerService;
import com.chatak.acquirer.admin.service.ResellerService;
import com.chatak.acquirer.admin.service.TransactionService;
import com.chatak.acquirer.admin.service.UserService;
import com.chatak.acquirer.admin.util.CommonUtil;
import com.chatak.acquirer.admin.util.ProcessorConfig;
import com.chatak.pg.acq.dao.PGParamsDao;
import com.chatak.pg.acq.dao.model.PGParams;
import com.chatak.pg.bean.Response;
import com.chatak.pg.constants.AccountTransactionCode;
import com.chatak.pg.constants.PGConstants;
import com.chatak.pg.model.AccountTransactionDTO;
import com.chatak.pg.model.AdminUserDTO;
import com.chatak.pg.model.GenericUserDTO;
import com.chatak.pg.model.Merchant;
import com.chatak.pg.user.bean.GetTransactionsListRequest;
import com.chatak.pg.user.bean.GetTransactionsListResponse;
import com.chatak.pg.user.bean.MerchantResponse;
import com.chatak.pg.util.Constants;

/**
 *
 * << Add Comments Here >>
 *
 * @author Girmiti Software
 * @date 06-Jan-2015 8:48:01 PM
 * @version 1.0
 */
@SuppressWarnings({"rawtypes", "unchecked"})
@Controller
public class DashboardController implements URLMappingConstants {

  private static Logger logger = Logger.getLogger(MerchantController.class);

  @Autowired
  private TransactionService transactionService;

  @Autowired
  private PGParamsDao paramsDao;

  @Autowired
  private MerchantUpdateService merchantUpdateService;

  @Autowired
  private BankService bankService;

  @Autowired
  private ResellerService resellerService;

  @Autowired
  private CurrencyConfigService currencyConfigService;

  @Autowired
  UserService userService;

  @Autowired
  MessageSource messageSource;
  @Autowired
  private MerchantValidateService merchantValidateService;
  
  @Autowired
  private PartnerService partnerService;
  
  @Autowired
  RoleController roleController;
  
  @Autowired
  private ProgramManagerService programManagerService;
  
  @Autowired
  private IsoService isoService;

  @PostConstruct
  private void loadConfiguration() {
    List<PGParams> pgParams = paramsDao.getAllPGParams();
    ProcessorConfig.setProcessorConfig(pgParams);
  }

  /**
   * Method to show login page
   * 
   * @param model
   * @param session
   * @return
   */
  @RequestMapping(value = CHATAK_ADMIN_HOME, method = RequestMethod.GET)
  public ModelAndView showLogin(HttpServletRequest request, Map model, HttpSession session) {
    logger.info("Entering:: DashboardController:: showLogin method");
    ModelAndView modelAndView = new ModelAndView(CHATAK_ADMIN_HOME);
    String existingFeature = (String) session.getAttribute(Constants.EXISTING_FEATURES);
    String userType = (String) session.getAttribute(Constants.LOGIN_USER_TYPE);
    if ("admin".equalsIgnoreCase(userType)) {
      modelAndView = showLoginCondition(session, modelAndView, existingFeature, userType);
    }
    List<Merchant> merchants = merchantUpdateService.getMerchantByStatusPendingandDecline();
    setMerchantSubList(modelAndView, merchants);
    GetTransactionsListRequest transaction = new GetTransactionsListRequest();
    TransactionResponse transactionResponse = new TransactionResponse();
    List<AccountTransactionDTO> transactionList = new ArrayList<>();

    try {

      List<String> txnCodeList = new ArrayList<>(Constants.ELEVEN);
      txnCodeList.add(AccountTransactionCode.CC_AMOUNT_CREDIT);
      txnCodeList.add(AccountTransactionCode.CC_AMOUNT_DEBIT);
      txnCodeList.add(AccountTransactionCode.CC_FEE_CREDIT);
      txnCodeList.add(AccountTransactionCode.CC_FEE_DEBIT);
      txnCodeList.add(AccountTransactionCode.ACCOUNT_CREDIT);
      txnCodeList.add(AccountTransactionCode.ACCOUNT_DEBIT);
      txnCodeList.add(AccountTransactionCode.EFT_DEBIT);
      txnCodeList.add(AccountTransactionCode.FT_BANK);
      txnCodeList.add(AccountTransactionCode.FT_CHECK);

      transaction.setTransactionCodeList(txnCodeList);

      transaction.setSettlementStatus(PGConstants.PG_SETTLEMENT_PROCESSING);
      GetTransactionsListResponse processingTxnList =
          transactionService.searchAccountTransactions(transaction);

      transaction.setSettlementStatus(PGConstants.PG_SETTLEMENT_EXECUTED);
      GetTransactionsListResponse executedTxnList =
          transactionService.searchAccountTransactions(transaction);

      if (null != processingTxnList && null != processingTxnList.getAccountTransactionList()) {

        int listSize = processingTxnList.getAccountTransactionList().size();
        transactionResponse
            .setAccountTxnList(listSize < Constants.TEN ? processingTxnList.getAccountTransactionList()
                : processingTxnList.getAccountTransactionList().subList(0, Constants.TEN));
        transactionResponse.setErrorCode(processingTxnList.getErrorCode());
        transactionResponse.setErrorMessage(processingTxnList.getErrorMessage());
        transactionResponse.setTotalNoOfRows(processingTxnList.getTotalResultCount());
        transactionList = transactionResponse.getAccountTxnList() != null
            ? transactionResponse.getAccountTxnList() : new ArrayList<AccountTransactionDTO>();
        modelAndView.addObject("processingListSize", listSize);
        session.setAttribute("processingListSize", listSize);
        modelAndView.addObject(Constants.PROCESSING_TXN_LIST, transactionList);
        session.setAttribute(Constants.PROCESSING_TXN_LIST, transactionList);
      }

      if (null != executedTxnList && null != executedTxnList.getAccountTransactionList()) {

        int listSize = executedTxnList.getAccountTransactionList().size();
        transactionResponse
            .setAccountTxnList(listSize < Constants.TEN ? executedTxnList.getAccountTransactionList()
                : executedTxnList.getAccountTransactionList().subList(0, Constants.TEN));
        transactionList = transactionResponse.getAccountTxnList() != null
            ? transactionResponse.getAccountTxnList() : new ArrayList<AccountTransactionDTO>();
        modelAndView.addObject("executedListSize", listSize);
        session.setAttribute("executedListSize", listSize);
        modelAndView.addObject(Constants.EXECUTED_TXN_LIST, transactionList);
        session.setAttribute(Constants.EXECUTED_TXN_LIST, transactionList);
      }

    } catch (Exception e) {
      logger.error("ERORR:: DashboardController:: showLogin method",e);
      modelAndView.setViewName(INVALID_REQUEST_PAGE);
    }
    model.put("transaction", new GetTransactionsListRequest());
    logger.info("Exiting:: DashboardController:: showLogin method");
    return modelAndView;
  }

  private void setMerchantSubList(ModelAndView modelAndView, List<Merchant> merchants) {
    if (CommonUtil.isListNotNullAndEmpty(merchants) && merchants.size() > Constants.TEN) {
      modelAndView.addObject("merchantSubList", merchants.subList(0, Constants.TEN));
    } 
    else {
      modelAndView.addObject("merchantSubList", merchants);
    }
  }

  private ModelAndView showLoginCondition(HttpSession session, ModelAndView modelAndView,
      String existingFeature, String userType) {
    if ((!existingFeature.contains(FeatureConstants.ADMIN_SERVICE_DASHBOARD_FEATURE_ID)) || ("reseller".equalsIgnoreCase(userType)
            && !existingFeature.contains(FeatureConstants.RESELLER_SERVICE_DASHBOARD_FEATURE_ID))) {
      session.invalidate();
      modelAndView.setViewName(INVALID_REQUEST_PAGE);
      return modelAndView;
    } 
    return modelAndView;
  }

  @RequestMapping(value = PENDING_MERCHANT_SHOW, method = RequestMethod.POST)
  public ModelAndView showViewSubMerchant(HttpServletRequest request, HttpServletResponse response,
      @FormParam("merchantViewId") final Long merchantViewId, HttpSession session, Map model) {
    logger.info("Entering :: MerchantController :: showViewSubMerchant method ");
    ModelAndView modelAndView = new ModelAndView(PENDING_MERCHANT_SHOW);
    Merchant merchant = new Merchant();
    modelAndView.addObject(Constants.ERROR, null);
    modelAndView.addObject(Constants.SUCESS, null);
    List<Option> processorNames = null;
    try {

      List<Option> countryList = merchantUpdateService.getCountries();
      modelAndView.addObject("countryList", countryList);
      session.setAttribute("countryList", countryList);
      merchant.setId(merchantViewId);
      merchant = merchantValidateService.getMerchant(merchant);
      if (null == merchant) {
        throw new ChatakAdminException();
      } else {
    	  validateMerchant(model, merchant);
        List<Option> options =
            merchantValidateService.getFeeProgramNamesForEdit(merchant.getFeeProgram());
        modelAndView.addObject("feeprogramnames", options);
        session.setAttribute("feeprogramnames", options);

        fetchState(session, modelAndView, merchant);

        String bankCurrencyCode = merchant.getBankCurrencyCode();
        Response currencyCodeAlpha = currencyConfigService.getcurrencyCodeAlpha(bankCurrencyCode);
        merchant.setCurrencyId(currencyCodeAlpha.getCurrencyCodeAlpha());

        Response agentnamesList = merchantUpdateService.getAgentNames(merchant.getLocalCurrency());
        if (agentnamesList != null) {
          modelAndView.addObject("agentnamesList", agentnamesList.getResponseList());
          session.setAttribute("agentnamesList", agentnamesList.getResponseList());
        }
        session.setAttribute("updateMerchantId", merchantViewId);
        merchant.setMerchantFlag(true);
        modelAndView.addObject("merchant", merchant);
        processorNames = merchantValidateService.getProcessorNames();
        List<Option> bankOptions = bankService.getBankData();
        modelAndView.addObject("bankList", bankOptions);
        List<Option> resellerOptions = resellerService.getResellerData();
        modelAndView.addObject("resellerList", resellerOptions);
        
        List<Option> partnersList = partnerService.getActivePartners();
        modelAndView.addObject("partnerList", partnersList);
        session.setAttribute("partnerList", partnersList);
      }
    } catch (ChatakAdminException e) {
      logger.error("ERORR:: DashboardController:: showViewSubMerchant method",e);
      modelAndView.setViewName(INVALID_REQUEST_PAGE);
    }
    modelAndView.addObject("processorNames", processorNames);
    model.put("merchant", merchant);
    session.setAttribute("parentMerchantId", merchant.getParentMerchantId());
    logger.info("EXITING :: MerchantController :: showViewSubMerchant");
    return modelAndView;
  }

private void validateMerchant(Map model, Merchant merchant) {
	try {
		MerchantResponse selectedCurrencyList = merchantUpdateService.findByMerchantId(merchant.getId());
		if (selectedCurrencyList != null) {
			merchant.setAssociatedTo(selectedCurrencyList.getMerchant().getAssociatedTo());
			if (merchant.getAssociatedTo() != null
					&& merchant.getAssociatedTo().equals(PGConstants.PROGRAM_MANAGER_NAME)) {
				 Response  programManagerResponse = programManagerService.findProgramManagerNameByCurrencyAndId(merchant.getId(),merchant.getLocalCurrency());
				model.put("selectedCardProgramList", selectedCurrencyList.getCardProgramRequests());
				model.put("selectedEntityList", selectedCurrencyList.getProgramManagerRequests());
				model.put(Constants.MERCHANT, selectedCurrencyList.getMerchant());
				model.put("EntityList", programManagerResponse.getResponseList());
			} else {
				Response  programManagerResponse = isoService.findIsoNameByCurrencyAndId(merchant.getId(), merchant.getLocalCurrency());
				model.put("selectedCardProgramList", selectedCurrencyList.getCardProgramRequests());
				model.put("selectedEntityList", selectedCurrencyList.getIsoRequests());
				model.put(Constants.MERCHANT, selectedCurrencyList.getMerchant());
				model.put("EntityList", programManagerResponse.getResponseList());
			}
		}
		} catch (InstantiationException e) {
			logger.error("ERORR:: DashboardController:: showViewSubMerchant method : InstantiationException",
					e);
		} catch (IllegalAccessException e) {
			logger.error("ERORR:: DashboardController:: showViewSubMerchant method :IllegalAccessException", e);
		}
}

  private void fetchState(HttpSession session, ModelAndView modelAndView, Merchant merchant) throws ChatakAdminException {
	Response stateList = merchantUpdateService.getStatesByCountry(merchant.getCountry());
	modelAndView.addObject("stateList", stateList.getResponseList());
	session.setAttribute("stateList", stateList.getResponseList());

	stateList = merchantUpdateService.getStatesByCountry(merchant.getBankCountry());
	modelAndView.addObject("bankStateList", stateList.getResponseList());
	session.setAttribute("bankStateList", stateList.getResponseList());

	stateList = merchantUpdateService.getStatesByCountry(merchant.getLegalCountry());
	modelAndView.addObject("legalStateList", stateList.getResponseList());
	session.setAttribute("legalStateList", stateList.getResponseList());
  }

  @RequestMapping(value = CHATAK_ADMIN_UNBLOCK_USERS, method = RequestMethod.GET)
  public ModelAndView showUnblockUsers(HttpServletRequest request, Map model, HttpSession session,
      GenericUserDTO userDataDto) {
    ModelAndView modelAndView = new ModelAndView(CHATAK_ADMIN_UNBLOCK_USERS);
    logger.info("Entering :: DashboardController :: showUnblockUsers method");
    String existingFeature = (String) session.getAttribute(Constants.EXISTING_FEATURES);
    if (!existingFeature.contains(FeatureConstants.ADMIN_SERVICE_UNBLOCKUSERS_FEATURE_ID)) {
      session.invalidate();
      modelAndView.setViewName(INVALID_REQUEST_PAGE);
      return modelAndView;
    }
    roleController.getRoleListForRoles(session, model);
    modelAndView.addObject("flag", false);
    modelAndView.addObject(Constants.USERDATA_DTO, userDataDto);
    logger.info("Exiting :: DashboardController :: showUnblockUsers method");
    return modelAndView;
  }

  @RequestMapping(value = CHATAK_ADMIN_UNBLOCK_USERS_SEARCH, method = RequestMethod.POST)
  public ModelAndView searchAdminUser(HttpServletRequest request, HttpServletResponse response,
      Map model, HttpSession session, GenericUserDTO userDataDto, BindingResult bindingResult) {
    logger.info("Entering:: DashboardController:: searchAdminUser method");

    ModelAndView modelAndView = new ModelAndView(CHATAK_ADMIN_UNBLOCK_USERS);
    String existingFeature = (String) session.getAttribute(Constants.EXISTING_FEATURES);
    if (!existingFeature.contains(FeatureConstants.ADMIN_SERVICE_UNBLOCKUSERS_FEATURE_ID)) {
      session.invalidate();
      modelAndView.setViewName(INVALID_REQUEST_PAGE);
      return modelAndView;
    }
    try {
    	roleController.getRoleListForRoles(session, model);
      List<AdminUserDTO> adminUserList;
      if (userDataDto.getUserType().equals(PGConstants.ADMIN) 
    		  || userDataDto.getUserType().equals(Constants.PM_USER_TYPE)
    		  || userDataDto.getUserType().equals(Constants.ISO_USER_TYPE)) {
        adminUserList = userService.searchAdminUserList();
      } else {
        adminUserList = userService.searchMerchantUserList();
      }
      if (null != adminUserList) {
        modelAndView.addObject("blockedUserList", adminUserList);
        session.setAttribute("blockedUserList", adminUserList);
      } else {
        model.put(Constants.ERROR, messageSource.getMessage(Constants.CHATAK_NORMAL_ERROR_MESSAGE,
            null, LocaleContextHolder.getLocale()));
      }

    } catch (Exception e) {
      logger.error("ERROR:: DashboardController:: searchAdminUser method", e);
      model.put(Constants.ERROR, messageSource.getMessage(Constants.CHATAK_NORMAL_ERROR_MESSAGE,
          null, LocaleContextHolder.getLocale()));
    }
    modelAndView.addObject(Constants.USERDATA_DTO, userDataDto);
    model.put("userType", userDataDto.getUserType());
    logger.info("Exit:: DashboardController:: searchAdminUser method");
    return modelAndView;

  }

  @RequestMapping(value = CHATAK_ADMIN_DO_UNBLOCK_USERS, method = RequestMethod.POST)
  public ModelAndView unblockUser(HttpServletRequest request, HttpServletResponse response,
      Map model, HttpSession session, GenericUserDTO userDataDto) {
    logger.info("Exit:: DashboardController:: unblockUser method");

    ModelAndView modelAndView = new ModelAndView(CHATAK_ADMIN_UNBLOCK_USERS);
    String existingFeature = (String) session.getAttribute(Constants.EXISTING_FEATURES);
    if (!existingFeature.contains(FeatureConstants.ADMIN_SERVICE_UNBLOCKUSERS_FEATURE_ID)) {
      session.invalidate();
      modelAndView.setViewName(INVALID_REQUEST_PAGE);
      return modelAndView;
    }
    String userName = request.getParameter("userName");
    String entityType = request.getParameter("entityType");
    Response responseval = new Response();
    try {
      if (userName != null && entityType.equals(PGConstants.ADMIN)
    		  || entityType.equals(Constants.PM_USER_TYPE)
    		  || entityType.equals(Constants.ISO_USER_TYPE)) {
        responseval = userService.unblockAdminUser(userName);
      } else {
        responseval = userService.unblockMerchantUser(userName);
      }
      if (responseval != null && responseval.getErrorCode() == "00") {
        modelAndView = showUnblockUsers(request, model, session, new GenericUserDTO());
        model.put(Constants.SUCESS, messageSource.getMessage("chatak.unblockuser.success.message",
            null, LocaleContextHolder.getLocale()));
      } else {
        model.put(Constants.ERROR, messageSource.getMessage(Constants.CHATAK_NORMAL_ERROR_MESSAGE,
            null, LocaleContextHolder.getLocale()));

      }

    } catch (ChatakAdminException e) {
      logger.error("ERROR:: DashboardController:: unblockUser method", e);
      model.put(Constants.ERROR, messageSource.getMessage(Constants.CHATAK_NORMAL_ERROR_MESSAGE,
          null, LocaleContextHolder.getLocale()));
    }
    modelAndView.addObject(Constants.USERDATA_DTO, new GenericUserDTO());
    logger.info("Exit:: DashboardController:: searchAdminUser method");
    return modelAndView;
  }
}
