package com.chatak.pg.acq.dao.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PG_FEE_PROGRAM")
public class PGFeeProgram implements Serializable {

  /**
	 * 
	 */
  private static final long serialVersionUID = 4296871773725079101L;

  @Id
  /*@SequenceGenerator(name = "seq_pg_fee_program_id", sequenceName = "SEQ_PG_FEE_PROGRAM")
  @GeneratedValue(generator = "seq_pg_fee_program_id")*/
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "FEE_PROGRAM_ID")
  private Long feeProgramId;

  @Column(name = "FEE_PROGRAM_NAME")
  private String feeProgramName;

  @Column(name = "FEE_PROGRAM_DESC")
  private String feeProgramDescription;

  @Column(name = "STATUS")
  private String status;

  @Column(name = "REASON")
  private String reason;

  @Column(name = "PROCESSOR")
  private String processor;

  @Column(name = "CREATED_DATE", updatable = false)
  private Timestamp createdDate;

  @Column(name = "UPDATED_DATE")
  private Timestamp updatedDate;

  @Column(name = "CREATED_BY", updatable = false)
  private String createdBy;

  @Column(name = "UPDATED_BY")
  private String updatedBy;
  
  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name="PG_OTHER_FEE_VALUE_ID")
  private PGOtherFeeValue pgOtherFeeValue;
  
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "FEE_PROGRAM_ID")
  private List<PGAcquirerFeeValue> acquirerFeeValueList;

  /**
   * @return the feeProgramId
   */
  public Long getFeeProgramId() {
    return feeProgramId;
  }

  /**
   * @param feeProgramId
   *          the feeProgramId to set
   */
  public void setFeeProgramId(Long feeProgramId) {
    this.feeProgramId = feeProgramId;
  }

  /**
   * @return the feeProgramName
   */
  public String getFeeProgramName() {
    return feeProgramName;
  }

  /**
   * @param feeProgramName
   *          the feeProgramName to set
   */
  public void setFeeProgramName(String feeProgramName) {
    this.feeProgramName = feeProgramName;
  }

  /**
   * @return the feeProgramDescription
   */
  public String getFeeProgramDescription() {
    return feeProgramDescription;
  }

  /**
   * @param feeProgramDescription
   *          the feeProgramDescription to set
   */
  public void setFeeProgramDescription(String feeProgramDescription) {
    this.feeProgramDescription = feeProgramDescription;
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
   * @return the createdDate
   */
  public Timestamp getCreatedDate() {
    return createdDate;
  }

  /**
   * @param createdDate
   *          the createdDate to set
   */
  public void setCreatedDate(Timestamp createdDate) {
    this.createdDate = createdDate;
  }

  /**
   * @return the updatedDate
   */
  public Timestamp getUpdatedDate() {
    return updatedDate;
  }

  /**
   * @param updatedDate
   *          the updatedDate to set
   */
  public void setUpdatedDate(Timestamp updatedDate) {
    this.updatedDate = updatedDate;
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
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * @param createdBy
   *          the createdBy to set
   */
  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  /**
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
  }

  /**
   * @param updatedBy
   *          the updatedBy to set
   */
  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }

  /**
   * @return the acquirerFeeValueList
   */
  public List<PGAcquirerFeeValue> getAcquirerFeeValueList() {
    return acquirerFeeValueList;
  }

  /**
   * @param acquirerFeeValueList the acquirerFeeValueList to set
   */
  public void setAcquirerFeeValueList(List<PGAcquirerFeeValue> acquirerFeeValueList) {
    this.acquirerFeeValueList = acquirerFeeValueList;
  }

  /**
   * @return the pgOtherFeeValue
   */
  public PGOtherFeeValue getPgOtherFeeValue() {
    return pgOtherFeeValue;
  }

  /**
   * @param pgOtherFeeValue the pgOtherFeeValue to set
   */
  public void setPgOtherFeeValue(PGOtherFeeValue pgOtherFeeValue) {
    this.pgOtherFeeValue = pgOtherFeeValue;
  }

}
