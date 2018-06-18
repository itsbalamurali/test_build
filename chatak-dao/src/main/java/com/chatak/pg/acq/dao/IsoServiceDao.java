/**
 * 
 */
package com.chatak.pg.acq.dao;

import java.util.List;

import com.chatak.pg.acq.dao.model.Iso;
import com.chatak.pg.acq.dao.model.IsoAccount;
import com.chatak.pg.acq.dao.model.IsoPmMap;
import com.chatak.pg.user.bean.CardProgramRequest;
import com.chatak.pg.user.bean.CardProgramResponse;
import com.chatak.pg.user.bean.IsoRequest;
import com.chatak.pg.user.bean.IsoResponse;
import com.chatak.pg.user.bean.MerchantResponse;

/**
 * @Author: Girmiti Software
 * @Date: May 7, 2018
 * @Time: 7:25:08 PM
 * @Version: 1.0
 * @Comments: 
 *
 */
public interface IsoServiceDao {

	public CardProgramResponse fetchCardProgramByPm(Long id);
	public Iso saveIso(Iso iso);
	public IsoResponse getISONameByAccountCurrency(String currencyId);
	public CardProgramResponse fetchCardProgramByIso(Long id, String currencyId);
	public IsoResponse searchIso(IsoRequest isoRequest);
	public IsoAccount saveIsoAccount(IsoAccount isoAccount);
	public Long getAccountNumberSeries(String accountNumber);
	public List<Iso> findByIsoName(String isoName);
	public List<Iso> findByIsoId(Long isoId) ;
	public IsoResponse getIsoById(IsoRequest isoRequest) ;
	public Iso updateIso(Iso iso);
	public void deleteIsoPmMappingByIsoId(Long isoId);	
	public void deleteIsoCardProgramMappingByIsoId(Long isoId);
	public List<CardProgramRequest> fetchCardProgramByIso(Long isoId);
	public IsoResponse fetchProgramManagerByIsoCurrency(Long isoId,String currency);
	public List<IsoRequest> getAllIso(IsoRequest isoRequest);
	public List<IsoPmMap> findByPmId(Long pmId);
	public MerchantResponse getIsoNameByCurrencyAndId(Long id,String currencyId);
	public MerchantResponse findByMerchantId(Long merchantId);
	public CardProgramResponse fetchIsoCardProgramByMerchantId(Long merchantId);
}
