package com.karens.coding.syncthing.wrapper.api.json.event.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.event.type.data.RemoteIndexUpdatedEventData;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RemoteIndexUpdatedEvent extends AbstractEvent {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1883057976207044657L;
	
	protected RemoteIndexUpdatedEventData data = null;

	/**
	 * @return the data
	 */
	public RemoteIndexUpdatedEventData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(RemoteIndexUpdatedEventData data) {
		this.data = data;
	}
	
	
}
