package com.chatak.pg.user.bean;

import java.io.Serializable;
import java.util.List;

import com.chatak.pg.acq.dao.model.PGUserRoles;

public class GetRoleOnRoleLevelResponse extends Response implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -21891352926347309L;

	private List<PGUserRoles> userRoleList;
	/**
	 * @return the userRoleList
	 */
	public List<PGUserRoles> getUserRoleList() {
		return userRoleList;
	}
	/**
	 * @param userRoleList the userRoleList to set
	 */
	public void setUserRoleList(List<PGUserRoles> userRoleList) {
		this.userRoleList = userRoleList;
	}
	
	
}
