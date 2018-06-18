/**
 * 
 */
package com.chatak.pg.acq.dao.impl;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chatak.pg.acq.dao.BatchDao;
import com.chatak.pg.acq.dao.model.PGBatch;
import com.chatak.pg.acq.dao.repository.BatchRepository;
import com.chatak.pg.dao.util.StringUtil;
import com.chatak.pg.util.LogHelper;
import com.chatak.pg.util.LoggerMessage;

/**
 * @Author: Girmiti Software
 * @Date: May 28, 2018
 * @Time: 10:04:47 PM
 * @Version: 1.0
 * @Comments: 
 *
 */
@Repository
public class BatchDaoImpl implements BatchDao{

	private static Logger logger = Logger.getLogger(BatchDaoImpl.class);

	@PersistenceContext
	 private EntityManager entityManager;
	
	@Autowired
	private BatchRepository batchRepository;

	@Override
	public PGBatch findByProgramManagerId(Long programManagerId) {
		return batchRepository.findByProgramManagerId(programManagerId);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public PGBatch getBatchIdByProgramManagerId(Long programManagerId) {
		LogHelper.logEntry(logger, LoggerMessage.getCallerName()+"Program Manger Id " +programManagerId);
		PGBatch batch = new PGBatch();
		Query qry = entityManager
				.createNativeQuery("select PM_ID,max(BATCH_ID) as BATCH_ID,STATUS from PG_BATCH where PM_ID = :programManagerId group by PM_ID,STATUS");
		qry.setParameter("programManagerId", programManagerId);
		List<Object> list = qry.getResultList();
		if (StringUtil.isListNotNullNEmpty(list)) {
			Iterator it = list.iterator();
			while (it.hasNext()) {
				Object[] objs = (Object[]) it.next();
				batch.setProgramManagerId(StringUtil.isNull(objs[0]) ? null : ((BigInteger) objs[0]).longValue());
				batch.setBatchId(StringUtil.isNull(objs[1]) ? null : ((String) objs[1]));
				batch.setStatus(StringUtil.isNull(objs[2]) ? null : ((String) objs[2]));
			}
		}
		LogHelper.logExit(logger, LoggerMessage.getCallerName() + "Batch Id : " + batch.getBatchId() + "Batch Status : "
				+ batch.getStatus());
		return batch;
	}

	@Override
	public PGBatch save(PGBatch batch) {
		return batchRepository.save(batch);
	}

}
