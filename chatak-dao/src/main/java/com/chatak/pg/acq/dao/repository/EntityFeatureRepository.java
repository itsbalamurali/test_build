/**
 * 
 */
package com.chatak.pg.acq.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.chatak.pg.acq.dao.model.PGEntityFeature;

/**
 * @Author: Girmiti Software
 * @Date: May 11, 2018
 * @Time: 1:33:01 PM
 * @Version: 1.0
 * @Comments: 
 *
 */
public interface EntityFeatureRepository extends JpaRepository<PGEntityFeature, Long>,QueryDslPredicateExecutor<PGEntityFeature> {
	
	public PGEntityFeature findById(Long entityFeatureId);

}
