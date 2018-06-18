package com.chatak.acquirer.admin.service;

import java.util.List;

import com.chatak.acquirer.admin.exception.ChatakAdminException;
import com.chatak.pg.user.bean.CardProgramRequest;

public interface CardProgramServices {

	public List<CardProgramRequest> getCardProgramByBankId(Long bankId) throws ChatakAdminException;
}
