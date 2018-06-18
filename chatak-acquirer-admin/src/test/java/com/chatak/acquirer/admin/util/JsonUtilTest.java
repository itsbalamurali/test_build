package com.chatak.acquirer.admin.util;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectWriter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.chatak.acquirer.admin.exception.ChatakAdminException;
import com.chatak.pg.exception.HttpClientException;

@RunWith(MockitoJUnitRunner.class)
public class JsonUtilTest {

	private static Logger logger = Logger.getLogger(JsonUtil.class);

	@InjectMocks
	JsonUtil jsonUtil;

	@Mock
	ObjectWriter objectWriter;

	@Test(expected = ChatakAdminException.class)
	public void testConvertObjectToJSON() throws ChatakAdminException {
		Object object = new Object();
		jsonUtil.convertObjectToJSON(object);
	}

	@Test(expected = NullPointerException.class)
	public void testConvertJSONToObject() throws ChatakAdminException {
		Class<?> c = null;
		jsonUtil.convertJSONToObject("jsonData", c);
	}

	@Test
	public void testPostRequest() {
		Object request = new Object();
		try {
			jsonUtil.postRequest(request,String.class, "serviceEndPoint");
		} catch (Exception e) {
			logger.error("JsonUtilTest | testPostRequest | Exception ", e);

		}
	}

	@Test(expected = ChatakAdminException.class)
	public void testPostRequestString() throws HttpClientException, ChatakAdminException {
		jsonUtil.postRequest("serviceEndPoint",String.class);
	}

	@Test(expected = NullPointerException.class)
	public void testSendToIssuance() throws ChatakAdminException, HttpClientException {
		Object request = new Object();
		jsonUtil.sendToIssuance(request, "serviceEndPoint", "m",String.class);
	}

	@Test
	public void testPostDCCRequest() {
		Object request = new Object();
		try {
			jsonUtil.postDCCRequest(request, "serviceEndPoint",String.class);
		} catch (Exception e) {
			logger.error("JsonUtilTest | testPostDCCRequest | Exception ", e);

		}
	}

	@Test(expected = IOException.class)
	public void testPostDCCRequestString() {
		try {
		jsonUtil.postDCCRequest("5435",String.class);
		}catch(Exception e) {
			logger.error("ERROR:: JsonUtilTest::testPostDCCRequestString ", e);
		}
	}

	@Test(expected = HttpClientException.class)
	public void testGetRequest() throws HttpClientException {
		jsonUtil.getRequest("111",String.class);
	}

	@Test
	public void testPostIssuanceRequest() {
		Object request = new Object();
		try {
			jsonUtil.postIssuanceRequest(request, "435435",String.class);
		} catch (Exception e) {
			logger.error("JsonUtilTest | testPostIssuanceRequest | Exception ", e);

		}
	}

}
