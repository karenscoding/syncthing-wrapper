package com.karens.coding.syncthing.wrapper.api.json.event.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.event.type.data.LoginAttemptEventData;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginAttemptEvent extends AbstractEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7089901671575962325L;
	
	protected LoginAttemptEventData data = null;

	/**
	 * @return the data
	 */
	public LoginAttemptEventData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(LoginAttemptEventData data) {
		this.data = data;
	}
	
	
}
