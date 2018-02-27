package com.karens.coding.syncthing.wrapper.api.json.system;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemLog implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3463956611580657602L;
	
	
	private List<SystemMessage> messages = null;

	/**
	 * @return the messages
	 */
	public List<SystemMessage> getMessages() {
		return messages;
	}

	/**
	 * @param messages the messages to set
	 */
	public void setMessages(List<SystemMessage> messages) {
		this.messages = messages;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SystemLog [messages=").append(messages).append("]");
		return builder.toString();
	}

	
}
