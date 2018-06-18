/**
 * 
 */
package com.chatak.pg.acq.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.chatak.pg.acq.dao.model.PGMerchantCardProgramMap;

/**
 * @Author: Girmiti Software
 * @Date: May 10, 2018
 * @Time: 7:11:30 PM
 * @Version: 1.0
 * @Comments: 
 *
 */
public interface MerchantCardProgramMapRepository extends JpaRepository<PGMerchantCardProgramMap,Long>, QueryDslPredicateExecutor<PGMerchantCardProgramMap> {

	public List<PGMerchantCardProgramMap> findByMerchantId(Long merchantId);
	
	@Modifying
	@Transactional
	@Query("delete from PGMerchantCardProgramMap merchantCpMap where merchantCpMap.merchantId = :merchantId")
	public void deleteMerchantCpMapByMerchantId(@Param("merchantId")Long merchantId);
	
	public PGMerchantCardProgramMap findByMerchantIdAndCardProgramId(Long merchantId, Long cardProgramId);
	
}
