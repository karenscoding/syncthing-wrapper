package com.karens.coding.syncthing.wrapper.api;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.karens.coding.syncthing.wrapper.http.BaseHttpResponse;

/**
 * 
 * @author karen
 *
 */
public class SyncthingRestAPIConnector {

	/** Logger */
	private static final Logger logger = LogManager.getLogger(SyncthingRestAPIConnector.class);
	
	private Locale locale = LocaleContextHolder.getLocale();
	
	private MessageSource messageSource = null;
	
	private RequestConfig config = null;
	
	/** Timeout in seconds */
	private int timeout = 30;
	
	public SyncthingRestAPIConnector() {
		
		this.config = RequestConfig.custom()
		  .setConnectTimeout(timeout * 1000)
		  .setConnectionRequestTimeout(timeout * 1000)
		  .setSocketTimeout(timeout * 1000).build();
	}
	
	
	/**
	 * 
	 * @param restUrl
	 * @param jsonRequest
	 * @return
	 */
	public BaseHttpResponse getRequest(String restUrl, String apiKey, String username, String password) {
		return getRequest(restUrl, apiKey, username, password, null);
	}
	
	/**
	 * 
	 * @param restUrl
	 * @param jsonRequest
	 * @return
	 */
	public BaseHttpResponse getRequest(String restUrl, String apiKey, String username, String password, MultiValueMap<String, String> queryParams) {
		BaseHttpResponse response = null;
		CloseableHttpClient client = null;
		try {
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(restUrl);
			
			if (queryParams != null && !queryParams.isEmpty()) {
				uriBuilder = uriBuilder.queryParams(queryParams);
			}
			
			UriComponents components = uriBuilder.buildAndExpand();
			
			HttpClientBuilder builder = HttpClientBuilder.create();
			
			if (username != null && password != null) {
				CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
		        UsernamePasswordCredentials userCredentials = new UsernamePasswordCredentials(username, password);
		        credentialsProvider.setCredentials(AuthScope.ANY, userCredentials);
		        builder.setDefaultCredentialsProvider(credentialsProvider);
			}
			
			client = builder.setDefaultRequestConfig(config).build();
			
			HttpGet request = new HttpGet(components.toUriString());
			//logger.debug("getRequest " + components.toUriString());
			if (apiKey != null && apiKey.length() > 0) {
		        request.addHeader("X-API-Key", apiKey);
			}
			/*if (username != null && password != null) {
				String credentials = Base64.getEncoder().encodeToString(new String(username + ":" + password).getBytes(StandardCharsets.UTF_8) ) ;
		        request.addHeader("Authorization", "Basic " + credentials);
				//request.setHeader("Authorization", "Basic " + credentials);
				
			}*/
			HttpResponse httpResponse = client.execute(request);
			//logger.debug("httpResponse " + httpResponse);
            response = new BaseHttpResponse(httpResponse, messageSource, locale);
            
		} catch (UnsupportedEncodingException e) {
			logger.error("UnsupportedEncodingException connecting: " + e.getMessage(), e);
			
		} catch (ClientProtocolException e) {
			logger.error("ClientProtocolException connecting: " + e.getMessage(), e);
			
		} catch (IOException e) {
			logger.error("IOException connecting: " + e.getMessage(), e);
			
		} finally {
			// Close the client
			IOUtils.closeQuietly(client);
			
		}
		return response;

	}
	
	
	/**
	 * 
	 * @param restUrl
	 * @param jsonRequest
	 * @return
	 */
	public BaseHttpResponse postJsonRequest(String restUrl, String jsonRequest, String apiKey, String username, String password, MultiValueMap<String, String> queryParams) {
		BaseHttpResponse response = null;
		CloseableHttpClient client = null;
		try {
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(restUrl);
			
			if (queryParams != null && !queryParams.isEmpty()) {
				uriBuilder = uriBuilder.queryParams(queryParams);
			}
			
			UriComponents components = uriBuilder.buildAndExpand();

			HttpClientBuilder builder = HttpClientBuilder.create();
			
			if (username != null && password != null) {
				CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
		        UsernamePasswordCredentials userCredentials = new UsernamePasswordCredentials(username, password);
		        credentialsProvider.setCredentials(AuthScope.ANY, userCredentials);
		        builder.setDefaultCredentialsProvider(credentialsProvider);
			}
			
			client = builder.setDefaultRequestConfig(config).build();
			HttpPost request = new HttpPost(components.toUriString());
			StringEntity params = new StringEntity(jsonRequest,StandardCharsets.UTF_8.name());
	        params.setContentType("application/json");
	        
	        request.setEntity(params);
	        if (apiKey != null && apiKey.length() > 0) {
	        	request.addHeader("X-API-Key", apiKey);
			}
	        /*if (username != null && password != null) {
				String credentials = Base64.getEncoder().encodeToString(new String(username + ":" + password).getBytes(StandardCharsets.UTF_8) ) ;
		        request.addHeader("Authorization", "Basic " + credentials);
				//request.setHeader("Authorization", "Basic " + credentials);
		        
			}*/
			
	    	//logger.debug("postJsonRequest " + components.toUriString());
	        
            HttpResponse httpResponse = client.execute(request);
            response = new BaseHttpResponse(httpResponse, messageSource, locale);
            
		} catch (UnsupportedEncodingException e) {
			logger.error("UnsupportedEncodingException connecting: " + e.getMessage(), e);
			
		} catch (ClientProtocolException e) {
			logger.error("ClientProtocolException connecting: " + e.getMessage(), e);
			
		} catch (IOException e) {
			logger.error("IOException connecting: " + e.getMessage(), e);
			
		} finally {
			// Close the client
			IOUtils.closeQuietly(client);
			
		}
		return response;

	}

	/**
	 * 
	 * @param restUrl
	 * @param jsonRequest
	 * @return
	 */
	public BaseHttpResponse postRequestGenerateJson(String restUrl, Object jsonObject, String apiKey, String username, String password) { 
		return postRequestGenerateJson(restUrl, jsonObject, apiKey, username, password, null);
	}
	
	public BaseHttpResponse postRequestGenerateJson(String restUrl, Object jsonObject, String apiKey, String username, String password, MultiValueMap<String, String> queryParams) { 
		String jsonRequest = convertToJson(jsonObject);
		logger.debug("jsonRequest " + jsonRequest);
		return postJsonRequest(restUrl, jsonRequest, apiKey, username, password, queryParams);
	}

	
	
	/**
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}


	/**
	 * @param locale the locale to set
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}


	/**
	 * @return the messageSource
	 */
	public MessageSource getMessageSource() {
		return messageSource;
	}


	/**
	 * 
	 * @param messageSource the messageSource to set
	 */
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	/**
	 * Convert object to Json string
	 * @param jsonObject
	 * @return object as json string
	 */
	protected String convertToJson(Object jsonObject) {
		String jsonRequest = null;
		ObjectMapper mapper = new ObjectMapper(); 
		try {
			mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
			jsonRequest = mapper.writeValueAsString(jsonObject);
			//logger.debug(Thread.currentThread().getName() +  " convertToJson " + jsonRequest);
		} catch (JsonProcessingException e) {
			logger.error("JsonProcessingException " + e.getMessage());
			
		}
		return jsonRequest;
	}
}
