package com.karens.coding.syncthing.wrapper.http;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.StatusLine;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import com.karens.coding.syncthing.wrapper.errors.ErrorMessages;
import com.karens.coding.syncthing.wrapper.messages.MessageSourceKeys;
import com.karens.coding.syncthing.wrapper.utils.MessageSourceUtils;

/**
 * 
 * @author karen
 *
 */
public class BaseHttpResponse {
	/** Logger */
	private static final Logger logger = LogManager.getLogger(BaseHttpResponse.class);
	/** Http status code */
	private int statusCode =-1;
	/** Http status line */
	private StatusLine statusLine = null;
	/** User error message */
	private List<String> userErrorMessages = new ArrayList<>();
	/** User info message */
	private List<String> userInfoMessages = new ArrayList<>();
	/** User info message */
	private List<String> userSuccessMessages = new ArrayList<>();
	/** Technical error message */
	private List<String> techErrorMessages = new ArrayList<>();
	/** Http response */
	private HttpResponse httpResponse = null;
	/** Http entity */
	private HttpEntity httpEntity = null;
	/** The http response as a json string */
	private String json = null;
	/** The cookie headers */
	private Header[] cookieHeaders = null;
	/** The cookies as a string */
	private String cookies = null;
	/** The http response as a map of objects */
	private HashMap<String, Object> responseObjects = new HashMap<String, Object>();
	
	private MessageSource messageSource = null;
	
	private BufferedImage bufferedImage = null;
	
	/**
	 * 
	 * @param response
	 */
	public BaseHttpResponse(HttpResponse response) {
		this(response, null, LocaleContextHolder.getLocale());
	}
	
	/**
	 * 
	 * @param response
	 * @param messageSource
	 * @param locale
	 */
	public BaseHttpResponse(HttpResponse response, MessageSource messageSource, Locale locale) {
		httpResponse = response;
		this.messageSource = messageSource;
		try {
			if (httpResponse != null) {
				statusLine = httpResponse.getStatusLine();
				statusCode = httpResponse.getStatusLine().getStatusCode();
				//Check that the request was successful
				if (statusCode == HttpStatus.SC_OK) {
					httpEntity = httpResponse.getEntity();
					
					//logger.debug("httpResponse: " + httpResponse);
					//logger.debug("httpEntity: " + httpEntity);
					
					//logger.debug("httpEntity content type: " + httpEntity.getContentType());
					if (httpEntity.getContentType().getValue().equals("image/jpeg")) {
						bufferedImage = ImageIO.read(httpEntity.getContent());
		            	json = "";
					}
					else if (httpEntity.getContentType().getValue().startsWith("application/json")) {
						json = EntityUtils.toString(httpEntity, StandardCharsets.UTF_8.name());
					} else {
						json = EntityUtils.toString(httpEntity, StandardCharsets.UTF_8.name());
					}
					cookieHeaders = httpResponse.getHeaders("Set-Cookie");
					StringBuilder builder = new StringBuilder();
					for (Header header : cookieHeaders) {
						builder.append(header.getValue().toString());
						
					}
					cookies = builder.toString();
					//logger.debug("cookies: " + cookies);
					
				} else{
					String userErrorMessage = MessageSourceUtils.getMessage(
	            			messageSource, locale, MessageSourceKeys.GENERAL_HTTP_COMMUNICATION_FAILED_KEY, 
	            			ErrorMessages.UNABLE_TO_COMMUNICATE_WITH_SERVER, null);
					
					userErrorMessages.add(userErrorMessage);
					logger.error("BaseHttpResponse constructor userErrorMessage: " + userErrorMessage);
					logger.error("BaseHttpResponse constructor httpResponse {}", httpResponse);
				}
			} else{
				String userErrorMessage = MessageSourceUtils.getMessage(
            			messageSource, locale, MessageSourceKeys.GENERAL_HTTP_COMMUNICATION_FAILED_KEY, 
            			ErrorMessages.UNABLE_TO_COMMUNICATE_WITH_SERVER, null);
				
				userErrorMessages.add(userErrorMessage);
				logger.error("BaseHttpResponse constructor userErrorMessage: " + userErrorMessage);
				
			}
		} catch (ParseException e) {
			userErrorMessages.add(ErrorMessages.UNABLE_TO_PROCESS_THE_RESPONSE_DATA);
			String userErrorMessage = MessageSourceUtils.getMessage(
        			messageSource, locale, MessageSourceKeys.GENERAL_HTTP_COMMUNICATION_FAILED_KEY, 
        			ErrorMessages.UNABLE_TO_PROCESS_THE_RESPONSE_DATA, null);
			
			userErrorMessages.add(userErrorMessage);
			logger.error("BaseHttpResponse constructor userErrorMessage: " + userErrorMessage);
		} catch (IOException e) {
			String userErrorMessage = MessageSourceUtils.getMessage(
        			messageSource, locale, MessageSourceKeys.GENERAL_HTTP_COMMUNICATION_FAILED_KEY, 
        			ErrorMessages.UNABLE_TO_COMMUNICATE_WITH_SERVER, null);
			
			userErrorMessages.add(userErrorMessage);
			logger.error("BaseHttpResponse constructor userErrorMessage: " + userErrorMessage);
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}

	
	/**
	 * @return the statusLine
	 */
	public StatusLine getStatusLine() {
		return statusLine;
	}

	/**
	 * @return the httpResponse
	 */
	public HttpResponse getHttpResponse() {
		return httpResponse;
	}

	/**
	 * @return the json
	 */
	public String getJson() {
		return json;
	}


	/**
	 * @return the userErrorMessages
	 */
	public List<String> getUserErrorMessages() {
		return userErrorMessages;
	}

	/**
	 * @param userErrorMessages the userErrorMessages to set
	 */
	public void setUserErrorMessages(List<String> userErrorMessages) {
		this.userErrorMessages = userErrorMessages;
	}
	
	/**
	 * @param userErrorMessage the userErrorMessage to set
	 */
	public void addUserErrorMessage(String userErrorMessage) {
		this.userErrorMessages.add(userErrorMessage);
	}

	/**
	 * @return the techErrorMessages
	 */
	public List<String> getTechErrorMessages() {
		return techErrorMessages;
	}

	/**
	 * @param techErrorMessages the techErrorMessages to set
	 */
	public void setTechErrorMessages(List<String> techErrorMessages) {
		this.techErrorMessages = techErrorMessages;
	}
	
	/**
	 * @param techErrorMessage the techErrorMessage to add
	 */
	public void addTechErrorMessage(String techErrorMessage) {
		this.techErrorMessages.add(techErrorMessage);
	}
	
	

	/**
	 * @return the userSuccessMessages
	 */
	public List<String> getUserSuccessMessages() {
		return userSuccessMessages;
	}

	/**
	 * @param userSuccessMessages the userSuccessMessages to set
	 */
	public void setUserSuccessMessages(List<String> userSuccessMessages) {
		this.userSuccessMessages = userSuccessMessages;
	}
	
	/**
	 * @param userSuccessMessage the userSuccessMessage to add
	 */
	public void addUserSuccessMessage(String userSuccessMessage) {
		this.userSuccessMessages.add(userSuccessMessage);
	}

	/**
	 * @return the cookieHeaders
	 */
	public Header[] getCookieHeaders() {
		return cookieHeaders;
	}

	/**
	 * @return the cookies
	 */
	public String getCookies() {
		return cookies;
	}

	/**
	 * 
	 * @return
	 */
	public Map<String, Object> getResponseObjects() {
		return responseObjects;
	}

	/**
	 * @return the userInfoMessages
	 */
	public List<String> getUserInfoMessages() {
		return userInfoMessages;
	}

	/**
	 * @param userInfoMessages the userInfoMessages to set
	 */
	public void setUserInfoMessages(List<String> userInfoMessages) {
		this.userInfoMessages = userInfoMessages;
	}

	public void addUserInfoMessages(String userInfoMessage) {
		this.userInfoMessages.add(userInfoMessage);
	}
	
	/**
	 * 
	 * @param responseObject
	 */
	public void setResponseObjects(HashMap<String, Object> responseObject) {
		this.responseObjects = responseObject;
	}

	/**
	 * 
	 * @param responseObject
	 */
	public void addResponseObjects(String key, Object responseObject) {
		this.responseObjects.put(key, responseObject);
	}

	/**
	 * @return the messageSource
	 */
	public MessageSource getMessageSource() {
		return messageSource;
	}

	/**
	 * @param messageSource the messageSource to set
	 */
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	/**
	 * @return the bufferedImage
	 */
	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}

	/**
	 * @param bufferedImage the bufferedImage to set
	 */
	public void setBufferedImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BaseHttpResponse [statusCode=" + statusCode + ", statusLine=" + statusLine + ", userErrorMessages=" + userErrorMessages + ", userInfoMessages=" + userInfoMessages
				+ ", userSuccessMessages=" + userSuccessMessages + ", techErrorMessages=" + techErrorMessages + ", httpResponse=" + httpResponse + ", httpEntity=" + httpEntity
				+ ", json=" + json + ", cookieHeaders=" + Arrays.toString(cookieHeaders) + ", cookies=" + cookies + ", responseObjects=" + responseObjects + ", messageSource="
				+ messageSource + "]";
	}

	
	
}
