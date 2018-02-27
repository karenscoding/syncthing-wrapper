package com.karens.coding.syncthing.wrapper.api.json.event.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.event.type.data.StartingEventData;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StartingEvent extends AbstractEvent {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5044243615779946077L;
	protected StartingEventData data = null;

	/**
	 * @return the data
	 */
	public StartingEventData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(StartingEventData data) {
		this.data = data;
	}
	
	
}
