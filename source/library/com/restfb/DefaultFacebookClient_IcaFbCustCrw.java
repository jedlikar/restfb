package com.restfb;

import java.io.IOException;

import com.restfb.WebRequestor.Response;

public class DefaultFacebookClient_IcaFbCustCrw extends DefaultFacebookClient {

	public DefaultFacebookClient_IcaFbCustCrw() {
	}

	public DefaultFacebookClient_IcaFbCustCrw(String accessToken) {
		super(accessToken);
//		this(accessToken, new DefaultWebRequestor(), new DefaultJsonMapper_DateraFBCrawler());
	}

	public DefaultFacebookClient_IcaFbCustCrw(String accessToken,
			WebRequestor webRequestor, JsonMapper jsonMapper) {
		super(accessToken, webRequestor, jsonMapper);
	}
	
	/**
	 * @see com.restfb.FacebookClient#fetchConnection(java.lang.String, java.lang.Class, com.restfb.Parameter[])
	 */
	public <T> Connection_IcaFbCustCrw<T> fetchConnection(String connection, Class<T> connectionType, Parameter... parameters) {
	    verifyParameterPresence("connection", connection);
	    verifyParameterPresence("connectionType", connectionType);
	    return new Connection_IcaFbCustCrw<T>(this, makeRequest(connection, parameters), connectionType);
	}
	
	/**
	 * @see com.restfb.FacebookClient#fetchConnectionPage(java.lang.String, java.lang.Class)
	 */
	public <T> Connection_IcaFbCustCrw<T> fetchConnectionPage(final String connectionPageUrl, Class<T> connectionType) {
	    String connectionJson = makeRequestAndProcessResponse(new Requestor() {
	        /**
	         * @see com.restfb.DefaultFacebookClient.Requestor#makeRequest()
	         */
	    	public Response makeRequest() throws IOException {
	    		return webRequestor.executeGet(connectionPageUrl);
	    	}
	    });
	
	  return new Connection_IcaFbCustCrw<T>(this, connectionJson, connectionType);
	}

}
