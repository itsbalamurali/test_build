/**
 * 
 */
package com.chatak.pg.acq.dao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: Girmiti Software
 * @Date: May 8, 2018
 * @Time: 4:46:15 PM
 * @Version: 1.0
 * @Comments: 
 *
 */
@Entity
@Table(name = "PG_PM_ISO_MAPPING")
public class IsoPmMap implements Serializable{
	  /**
	 * 
	 */
	private static final long serialVersionUID = -8342765383270380298L;

	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Column(name = "ID")
	  private Long id;
	  
	  @Column(name = "ISO_ID")
	  private Long isoId;
	  
	  @Column(name = "PM_ID")
	  private Long pmId;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the isoId
	 */
	public Long getIsoId() {
		return isoId;
	}

	/**
	 * @param isoId the isoId to set
	 */
	public void setIsoId(Long isoId) {
		this.isoId = isoId;
	}

	/**
	 * @return the pmId
	 */
	public Long getPmId() {
		return pmId;
	}

	/**
	 * @param pmId the pmId to set
	 */
	public void setPmId(Long pmId) {
		this.pmId = pmId;
	}
	  
}
