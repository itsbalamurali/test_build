package com.chatak.switches.sb.util;

import org.apache.http.Header;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectWriter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.chatak.pg.exception.PrepaidAdminException;
import com.chatak.pg.util.HttpClient;
import com.chatak.switches.sb.exception.ServiceException;

@RunWith(MockitoJUnitRunner.class)
public class JsonUtilTest {

	private static Logger logger = Logger.getLogger(JsonUtil.class);

	@InjectMocks
	JsonUtil jsonUtil;

	@Mock
	ObjectWriter objectWriter;
	
	@Mock
	HttpClient httpClient;
	
	@Mock
	String output;

	@Test(expected = ServiceException.class)
	public void testConvertObjectToJSON() throws ServiceException {
		Object object = new Object();
		jsonUtil.convertObjectToJSON(object);
	}

	@Test
	public void testConvertObjectToJSONElse() throws ServiceException {
		Object object = null;
		jsonUtil.convertObjectToJSON(object);
	}

	@Test(expected = NullPointerException.class)
	public void testConvertJSONToObject() throws ServiceException {
		Class<?> c = null;
		jsonUtil.convertJSONToObject("111", c);
	}

	@Test
	public void testSendToIssuance() throws PrepaidAdminException {
		Header[] headers = new Header[] {};	
		Object request = new Object();
		Mockito.when(httpClient.invokePost(Matchers.any(Object.class), String.class, headers));
		try {
			jsonUtil.sendToIssuance(request, "123", "543",String.class);
		} catch (Exception e) {
			logger.error("ERROR:: JsonUtilTest:: testSendToIssuance method", e);

		}
	}
}
