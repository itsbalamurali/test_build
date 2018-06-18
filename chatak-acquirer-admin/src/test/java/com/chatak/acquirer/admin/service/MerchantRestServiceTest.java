package com.chatak.acquirer.admin.service;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.chatak.acquirer.admin.exception.ChatakAdminException;
import com.chatak.acquirer.admin.service.impl.MerchantValidateServiceImpl;
import com.chatak.acquirer.admin.util.JsonUtil;
import com.chatak.acquirer.admin.util.ProcessorConfig;
import com.chatak.pg.exception.HttpClientException;
import com.chatak.pg.model.CIEntityDetailsResponse;
import com.chatak.pg.model.VirtualAccGetAgentsRequest;


@RunWith(PowerMockRunner.class)
@PrepareForTest({JsonUtil.class, ProcessorConfig.class})
public class MerchantRestServiceTest {

  @InjectMocks
  MerchantValidateServiceImpl merchantValidateService = new MerchantValidateServiceImpl();
  @Mock
  ObjectMapper mapper;

  @Mock
  String response;

  @Mock
  CIEntityDetailsResponse ciEntityDetailsResponse;

  @Test
  public void getPartnerList() throws ChatakAdminException, IOException, HttpClientException {
    String live = null;
    PowerMockito.mockStatic(JsonUtil.class);
    PowerMockito.mockStatic(ProcessorConfig.class);
    PowerMockito.when(ProcessorConfig.get("FEE_SERVICE_LIVE")).thenReturn(live);
    PowerMockito.when(JsonUtil.sendToIssuance(Matchers.any(VirtualAccGetAgentsRequest.class),
        Matchers.anyString(),Matchers.anyString(),Matchers.any())).thenReturn(response);
    Mockito.when(mapper.readValue("responseMessage", CIEntityDetailsResponse.class))
        .thenReturn(ciEntityDetailsResponse);
    CIEntityDetailsResponse ciEntityDetailsResponses = merchantValidateService.getPartnerList(live);
    Assert.assertNotNull(ciEntityDetailsResponses);


  }

}

