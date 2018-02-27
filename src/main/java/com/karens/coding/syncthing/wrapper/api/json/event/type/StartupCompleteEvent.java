package com.karens.coding.syncthing.wrapper.api.json.event.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.event.type.data.StartupCompleteEventData;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StartupCompleteEvent extends AbstractEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1256190569914180498L;
	
	protected StartupCompleteEventData data = null;

	/**
	 * @return the data
	 */
	public StartupCompleteEventData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(StartupCompleteEventData data) {
		this.data = data;
	}
	
	
}
