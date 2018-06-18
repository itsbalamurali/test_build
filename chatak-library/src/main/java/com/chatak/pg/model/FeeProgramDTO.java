package com.chatak.pg.model;

import java.util.List;
import java.util.Map;

import org.springframework.util.AutoPopulatingList;

import com.chatak.pg.bean.SearchRequest;

public class FeeProgramDTO extends SearchRequest {

  private static final long serialVersionUID = 5945548991394946247L;

  private Long feeProgramId;

  private String feeProgramName;

  private String feeProgramDescription;

  private Map<Long, String> selectedFeeCodes;

  private Map<Long, String> availableFeeCodes;

  private String status;

  private List<FeeValue> feeValueList = new AutoPopulatingList<FeeValue>(FeeValue.class);

  private String reason;

  private Long accountProgramId;

  private String accountProgramName;

  private Long partnerId;

  private String partnerName;

  private String processor;

  private OtherFeesDTO otherFee;

  /**
   * @return the feeProgramId
   */
  public Long getFeeProgramId() {
    return feeProgramId;
  }
  
  /**
   * @return the feeProgramDescription
   */
  public String getFeeProgramDescription() {
    return feeProgramDescription;
  }

  /**
   * @param feeProgramId
   *          the feeProgramId to set
   */
  public void setFeeProgramId(Long feeProgramId) {
    this.feeProgramId = feeProgramId;
  }

  /**
   * @param feeProgramDescription
   *          the feeProgramDescription to set
   */
  public void setFeeProgramDescription(String feeProgramDescription) {
    this.feeProgramDescription = feeProgramDescription;
  }

  /**
   * @param feeProgramName
   *          the feeProgramName to set
   */
  public void setFeeProgramName(String feeProgramName) {
    this.feeProgramName = feeProgramName;
  }

  /**
   * @return the selectedFeeCodes
   */
  public Map<Long, String> getSelectedFeeCodes() {
    return selectedFeeCodes;
  }

  /**
   * @param selectedFeeCodes
   *          the selectedFeeCodes to set
   */
  public void setSelectedFeeCodes(Map<Long, String> selectedFeeCodes) {
    this.selectedFeeCodes = selectedFeeCodes;
  }

  /**
   * @return the availableFeeCodes
   */
  public Map<Long, String> getAvailableFeeCodes() {
    return availableFeeCodes;
  }

  /**
   * @param availableFeeCodes
   *          the availableFeeCodes to set
   */
  public void setAvailableFeeCodes(Map<Long, String> availableFeeCodes) {
    this.availableFeeCodes = availableFeeCodes;
  }

  /**
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * @param status
   *          the status to set
   */
  public void setStatus(String status) {
    this.status = status;
  }
  
  /**
   * @return the feeProgramName
   */
  public String getFeeProgramName() {
    return feeProgramName;
  }

  /**
   * @return the feeValueList
   */
  public List<FeeValue> getFeeValueList() {
    return feeValueList;
  }

  /**
   * @param feeValueList
   *          the feeValueList to set
   */
  public void setFeeValueList(List<FeeValue> feeValueList) {
    this.feeValueList = feeValueList;
  }

  /**
   * @return the reason
   */
  public String getReason() {
    return reason;
  }

  /**
   * @param reason
   *          the reason to set
   */
  public void setReason(String reason) {
    this.reason = reason;
  }

  /**
   * @return the accountProgramId
   */
  public Long getAccountProgramId() {
    return accountProgramId;
  }

  /**
   * @param accountProgramId
   *          the accountProgramId to set
   */
  public void setAccountProgramId(Long accountProgramId) {
    this.accountProgramId = accountProgramId;
  }

  /**
   * @return the accountProgramName
   */
  public String getAccountProgramName() {
    return accountProgramName;
  }

  /**
   * @param accountProgramName
   *          the accountProgramName to set
   */
  public void setAccountProgramName(String accountProgramName) {
    this.accountProgramName = accountProgramName;
  }

  /**
   * @return the partnerId
   */
  public Long getPartnerId() {
    return partnerId;
  }

  /**
   * @param partnerId
   *          the partnerId to set
   */
  public void setPartnerId(Long partnerId) {
    this.partnerId = partnerId;
  }

  /**
   * @return the partnerName
   */
  public String getPartnerName() {
    return partnerName;
  }

  /**
   * @param partnerName
   *          the partnerName to set
   */
  public void setPartnerName(String partnerName) {
    this.partnerName = partnerName;
  }

  /**
   * @return the processor
   */
  public String getProcessor() {
    return processor;
  }

  /**
   * @param processor
   *          the processor to set
   */
  public void setProcessor(String processor) {
    this.processor = processor;
  }

  /**
   * @return the otherFee
   */
  public OtherFeesDTO getOtherFee() {
    return otherFee;
  }

  /**
   * @param otherFee the otherFee to set
   */
  public void setOtherFee(OtherFeesDTO otherFee) {
    this.otherFee = otherFee;
  }

}
