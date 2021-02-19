package com.restapi.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {


	//GET Method

	public void getMethod(String url ) throws ClientProtocolException, IOException {	

		//createDefault() will create client connection and returns CloseableHttpClient object
		CloseableHttpClient clientObj = HttpClients.createDefault(); 

		//create get connection with url
		HttpGet httpGet = new HttpGet(url);

		//execute() will hit the http get request and returns CloseableHttpResponse object
		CloseableHttpResponse httpResponse = clientObj.execute(httpGet); 


		int statusCode = httpResponse.getStatusLine().getStatusCode();

		//printing status code for JSON response.
		System.out.println("Status code: " + statusCode);

		//getEntity() method will return complete response entity and toString() method convert entity into string.
		String stringEntity = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
		System.out.println(stringEntity);

		//String entity will be converted into JSON object in key-value pair
		JSONObject responseJSON = new JSONObject(stringEntity);
		System.out.println(responseJSON);

		//getAllHeaders() method will return Header array
		Header[] allHeaders = httpResponse.getAllHeaders();

		HashMap<String, String> headers = new HashMap<String, String>();
		for(Header header:allHeaders) {
			headers.put(header.getName(), header.getValue());
		}
		System.out.println(headers);
	}
}
