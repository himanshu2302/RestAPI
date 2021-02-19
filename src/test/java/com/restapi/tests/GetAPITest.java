package com.restapi.tests;

import java.io.IOException;
import java.util.Properties;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.restapi.base.BaseClass;
import com.restapi.client.RestClient;

public class GetAPITest extends BaseClass{


	BaseClass baseClass;
	String serviceURL;
	String apiURL;
	String url;

	@BeforeMethod
	public void setUp() {
		baseClass = new BaseClass();
		serviceURL = prop.getProperty("url");
		apiURL=prop.getProperty("serviceUrl");

		url = serviceURL+apiURL;
	}

	@Test
	public void getTest() throws ClientProtocolException, IOException {
		RestClient restClient = new RestClient();
		restClient.getMethod(url);
	}

}
