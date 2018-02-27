package com.karens.coding.syncthing.wrapper.utils;

import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * 
 * @author karen
 *
 */
public class MessageSourceUtils {
	/** Logger */
	private static final Logger logger = LogManager.getLogger(MessageSourceUtils.class);
	
	private static Locale defaultLocale = LocaleContextHolder.getLocale();
	
	private MessageSource messageSource = null;

	/**
	 * 
	 * @param messageKey
	 * @param defaultMessage
	 * @param args
	 * @return
	 */
	public String getMessage(String messageKey, String defaultMessage, String[] args) {
		String message = null;
		if (messageSource != null) {
			try {
				message = messageSource.getMessage(messageKey, args, defaultMessage, defaultLocale);
			} catch (Exception e) {
				message = defaultMessage;
				logger.error("MessageSourceUtils error " + e.getMessage());
			}
		} else{
			message = defaultMessage;
			logger.error("MessageSourceUtils messageSource is null using default ");
		}
		return message;
	}

	/**
	 * 
	 * @param messageSource
	 * @param locale
	 * @param messageKey
	 * @param defaultMessage
	 * @param args
	 * @return
	 */
	public static String getMessage(MessageSource messageSource, Locale locale,  String messageKey, String defaultMessage, String[] args) {
		String message = null;
		Locale messageLocale = locale;
		if (messageLocale == null) {
			messageLocale = defaultLocale;
		}
		if (messageSource != null) {
			try {
				//logger.debug("MessageSourceUtils about to get key " + messageKey + " from messageSource ");
				message = messageSource.getMessage(messageKey, args, defaultMessage, messageLocale);
				//logger.debug("MessageSourceUtils message result " + message);
				
			} catch (Exception e) {
				message = defaultMessage;
				logger.error("MessageSourceUtils error " + e.getMessage());
			}
		} else{
			message = defaultMessage;
			logger.error("MessageSourceUtils messageSource is null using default ");
		}
		return message;
	}

	/**
	 * @return the defaultLocale
	 */
	public static Locale getDefaultLocale() {
		return defaultLocale;
	}

	/**
	 * @param defaultLocale the defaultLocale to set
	 */
	public static void setDefaultLocale(Locale defaultLocale) {
		MessageSourceUtils.defaultLocale = defaultLocale;
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
	
}
