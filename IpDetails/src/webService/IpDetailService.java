package webService;

// IP Intelligence REST Web Service
// @author www.quova.com
//Copyright 2010 Quova, Inc.
//This example illustrates how to execute a web service request via HTTP GET. 08
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import util.ConfigReader;
import bean.GeoPointResponseBean;

import com.google.gson.Gson;

public class IpDetailService {

	private static final String FORMAT_JSON = "&format=json";
	private static final String SIG_PARAM = "&sig=";
	private static final String APIKEY_PARAM = "?apikey=";
	private static final String MD5 = "MD5";
	private static final String HEX_FORMAT = "%032x";
	private static Logger log = Logger.getLogger(IpDetailService.class.getName());


	public static GeoPointResponseBean getIpData(String ipAddr) throws ParseException, IOException, NoSuchAlgorithmException {
		HttpResponse response = null;
		GeoPointResponseBean ipResponse = null;
		DefaultHttpClient httpclient = new DefaultHttpClient();
		try {
			String url = getEndpointUrl(ipAddr);
			
			// Create an HTTP GET request
			HttpGet httpget = new HttpGet(url);
			
			// Execute the request
			httpget.getRequestLine();
			response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			// Print the response
			StatusLine statusLine = response.getStatusLine();
			log.info(String.format("ipAddr: %s, status: %s", ipAddr, statusLine));
			
			if (entity != null) {
				String jsonStr = EntityUtils.toString(entity);
				ipResponse = new Gson().fromJson(jsonStr, GeoPointResponseBean.class);
			}
			
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		
		return ipResponse;
	}

	public static String getEndpointUrl(String publicIpAddr) throws NoSuchAlgorithmException {
		
		StringBuffer url = new StringBuffer();
		
		MessageDigest md = MessageDigest.getInstance(MD5);
		long timeInSeconds = (long) (System.currentTimeMillis() / 1000);
		String apiKey = ConfigReader.getApiKey();
		String input = apiKey + ConfigReader.getSecret() + timeInSeconds;
		md.update(input.getBytes());
		String sig = String.format(HEX_FORMAT, new BigInteger(1, md.digest()));

		
		url.append(ConfigReader.getServiceUrl());
		url.append(ConfigReader.getServiceVersion());
		url.append(ConfigReader.getServiceMethod());
		url.append(publicIpAddr);
		url.append(APIKEY_PARAM);
		url.append(apiKey);
		url.append(SIG_PARAM);
		url.append(sig);
		url.append(FORMAT_JSON);
		
		log.debug("URL=" + url.toString());
		return url.toString();
	}
	
}
