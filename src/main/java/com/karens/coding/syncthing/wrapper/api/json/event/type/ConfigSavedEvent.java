package com.karens.coding.syncthing.wrapper.api.json.event.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.Config;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConfigSavedEvent extends AbstractEvent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1283845392310387600L;
	
	protected Config data = null;
	
	/**
	 * @return the data
	 */
	public Config getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Config data) {
		this.data = data;
	}
}
