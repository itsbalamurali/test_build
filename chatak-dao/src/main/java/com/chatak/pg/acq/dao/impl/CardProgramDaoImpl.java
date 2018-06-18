/**
 * 
 */
package com.chatak.pg.acq.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chatak.pg.acq.dao.CardProgramDao;
import com.chatak.pg.acq.dao.model.CardProgram;
import com.chatak.pg.acq.dao.model.PmCardProgamMapping;
import com.chatak.pg.acq.dao.model.QBankProgramManagerMap;
import com.chatak.pg.acq.dao.model.QCardProgram;
import com.chatak.pg.acq.dao.model.QPGBank;
import com.chatak.pg.acq.dao.model.QPmCardProgamMapping;
import com.chatak.pg.acq.dao.model.QProgramManager;
import com.chatak.pg.acq.dao.repository.CardProgramRepository;
import com.chatak.pg.acq.dao.repository.PmCardProgramMappingRepository;
import com.chatak.pg.user.bean.CardProgramRequest;
import com.mysema.query.Tuple;
import com.mysema.query.jpa.impl.JPAQuery;

/**
 * @Author: Girmiti Software
 * @Date: May 10, 2018
 * @Time: 8:31:23 PM
 * @Version: 1.0
 * @Comments: 
 *
 */
@Repository
public class CardProgramDaoImpl implements CardProgramDao{
	
	
	@Autowired
	private CardProgramRepository cardProgramRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	  
	@Autowired
	private PmCardProgramMappingRepository cardProgamMappingRepository;

	@Override
    public CardProgram createCardProgram(CardProgram cardProgramRequest)
            throws DataAccessException {
        return cardProgramRepository.save(cardProgramRequest);
    }
	
	@Override
	@Transactional
    public PmCardProgamMapping createCardProgramMapping(PmCardProgamMapping cardProgramRequest)
            throws DataAccessException {
        return cardProgamMappingRepository.save(cardProgramRequest);
    }

	/**
	 * @param cardProgramId
	 * @return
	 */
	@Override
	public CardProgram findByCardProgramId(Long cardProgramId) {
		return cardProgramRepository.findByCardProgramId(cardProgramId);
	}
	/**
	 * @param programManagerId
	 * @return
	 */
	@Override
	public List<CardProgramRequest> findCardProgramByPmId(Long programManagerId) {
		List<CardProgramRequest> cardProgramRequestList = new ArrayList<>();
		JPAQuery query = new JPAQuery(entityManager);
		List<Tuple> list = query
				.from(QProgramManager.programManager, QPmCardProgamMapping.pmCardProgamMapping, QCardProgram.cardProgram)
				.where(QProgramManager.programManager.id.eq(programManagerId),
						QPmCardProgamMapping.pmCardProgamMapping.programManagerId.eq(QProgramManager.programManager.id),
						QCardProgram.cardProgram.cardProgramId.eq(QPmCardProgamMapping.pmCardProgamMapping.cardProgramId))
				.distinct().list(QCardProgram.cardProgram.cardProgramId, QCardProgram.cardProgram.cardProgramName);
		for (Tuple tuple : list) {
			CardProgramRequest cardProgramRequest = new CardProgramRequest();
			cardProgramRequest.setCardProgramId(tuple.get(QCardProgram.cardProgram.cardProgramId));
			cardProgramRequest.setCardProgramName(tuple.get(QCardProgram.cardProgram.cardProgramName));
			cardProgramRequestList.add(cardProgramRequest);
		}
		return cardProgramRequestList;
	}
	
	/**
	 * @param bankId
	 * @return
	 */
	@Override
	public List<CardProgramRequest> findByBankId(Long bankId) {
		List<CardProgramRequest> cardProgramRequestList = new ArrayList<>();
		JPAQuery query = new JPAQuery(entityManager);
		List<Tuple> list = query
				.from(QProgramManager.programManager, QPmCardProgamMapping.pmCardProgamMapping, QCardProgram.cardProgram,QPGBank.pGBank,QBankProgramManagerMap.bankProgramManagerMap)
				.where(QPGBank.pGBank.id.eq(bankId),
						QBankProgramManagerMap.bankProgramManagerMap.bankId.eq(QPGBank.pGBank.id),
						QProgramManager.programManager.id.eq(QBankProgramManagerMap.bankProgramManagerMap.programManagerId),
						QPmCardProgamMapping.pmCardProgamMapping.programManagerId.eq(QProgramManager.programManager.id),
						QCardProgram.cardProgram.cardProgramId.eq(QPmCardProgamMapping.pmCardProgamMapping.cardProgramId))
				.distinct().list(QCardProgram.cardProgram.cardProgramId, QCardProgram.cardProgram.cardProgramName);
		for (Tuple tuple : list) {
			CardProgramRequest cardProgramRequest = new CardProgramRequest();
			cardProgramRequest.setCardProgramId(tuple.get(QCardProgram.cardProgram.cardProgramId));
			cardProgramRequest.setCardProgramName(tuple.get(QCardProgram.cardProgram.cardProgramName));
			cardProgramRequestList.add(cardProgramRequest);
		}
		return cardProgramRequestList;
	}
	
	@Override
	public CardProgram findByIssuanceCardProgramId(Long issuanceCardProgramId){
	  return cardProgramRepository.findByIssuanceCradProgramId(issuanceCardProgramId);
	}

	@Override
	public CardProgram findCardProgramByIIN(Long iin, String partnerIINCode, String iinExt) {
		return cardProgramRepository.findByIinAndPartnerIINCodeAndIinExt(iin, partnerIINCode, iinExt);
	}
 }
